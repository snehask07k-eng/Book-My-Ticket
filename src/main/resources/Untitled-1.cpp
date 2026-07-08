#include <Servo.h>
#include <SoftwareSerial.h>
// ==================== PIN DEFINITIONS ====================
const int flameL = A0;
const int flameC = A1;
const int flameR = A2;
const int trigPin = 8;
const int echoPin = 2;
const int servoPin = 10;
// L298N Motor Driver Pins
const int IN1 = 6;
const int IN2 = 7;
const int ENA = 9;
const int IN3 = 11;
const int IN4 = 12;
const int ENB = 3;
const int pumpPin = A4; // Water Pump
const int buzzer = 13;
// Bluetooth HC-05
SoftwareSerial BT(4, 5); // RX, TX
Servo nozzleServo;
// ================ PID & CONTROL VARIABLES ====================
double kp = 0.85, ki = 0.02, kd = 0.6;
double error = 0, lastError = 0, integral = 0;
int baseSpeed = 150;
int threshold = 420;
void setup() {

Serial.begin(9600);
BT.begin(9600);
nozzleServo.attach(servoPin);
nozzleServo.write(90);
// Pin modes
pinMode(trigPin, OUTPUT);
pinMode(echoPin, INPUT);
pinMode(pumpPin, OUTPUT);
pinMode(buzzer, OUTPUT);
// Motor pins
pinMode(IN1, OUTPUT);
pinMode(IN2, OUTPUT);
pinMode(IN3, OUTPUT);
pinMode(IN4, OUTPUT);
pinMode(ENA, OUTPUT);
pinMode(ENB, OUTPUT);
digitalWrite(pumpPin, LOW);
BT.println("Fire Fighting Robot Ready (L298N)!");
BT.println("Waiting for fire...");
Serial.println("Robot Started with L298N");
}
long getDistance() {
digitalWrite(trigPin, LOW);
delayMicroseconds(2);
digitalWrite(trigPin, HIGH);
delayMicroseconds(10);
digitalWrite(trigPin, LOW);
long duration = pulseIn(echoPin, HIGH);
return duration * 0.034 / 2;
}
void setMotorSpeeds(int left, int right) {
// Left Motor
if (left > 0) {
digitalWrite(IN1, HIGH);
digitalWrite(IN2, LOW);
analogWrite(ENA, left);
}
else if (left < 0) {
digitalWrite(IN1, LOW);
digitalWrite(IN2, HIGH);
analogWrite(ENA, -left);
}
else {
digitalWrite(IN1, LOW);
digitalWrite(IN2, LOW);
analogWrite(ENA, 0);
}
// Right Motor
if (right > 0) {
digitalWrite(IN3, HIGH);
digitalWrite(IN4, LOW);
analogWrite(ENB, right);
}
else if (right < 0) {
digitalWrite(IN3, LOW);
digitalWrite(IN4, HIGH);
analogWrite(ENB, -right);
}
Else
{
digitalWrite(IN3, LOW);
digitalWrite(IN4, LOW);
analogWrite(ENB, 0);
}
}
void stopMotors() {
setMotorSpeeds(0, 0);
}
void loop() {
int valL = analogRead(flameL);
int valC = analogRead(flameC);
int valR = analogRead(flameR);
long distance = getDistance();
// Bluetooth Telemetry
static unsigned long lastSend = 0;
if (millis() - lastSend > 800)
{
BT.print("L:"); BT.print(valL);
BT.print(" C:"); BT.print(valC);
BT.print(" R:"); BT.print(valR);
BT.print(" D:"); BT.print(distance);
BT.println(" cm");
lastSend = millis();
}
if (valL < threshold || valC < threshold || valR < threshold) {
digitalWrite(buzzer, HIGH);
delay(60);
digitalWrite(buzzer, LOW);
if (distance < 28) { // Extinguish range
stopMotors();
nozzleServo.write(75);
digitalWrite(pumpPin, HIGH);
BT.println("=== EXTINGUISHING FIRE ===");
delay(3500);
digitalWrite(pumpPin, LOW);
nozzleServo.write(90);
BT.println("Fire Suppressed!");
delay(2000);
}
else
{
// PID Control
error = (valL - valR);
integral += error;
double derivative = error - lastError;
double pidOutput = (kp * error) + (ki * integral) + (kd * derivative);
lastError = error;
int leftSpeed = baseSpeed + pidOutput;

int rightSpeed = baseSpeed - pidOutput;
leftSpeed = constrain(leftSpeed, 0, 255);
rightSpeed = constrain(rightSpeed, 0, 255);
setMotorSpeeds(leftSpeed, rightSpeed);
}
}
Else
{
stopMotors();
}
delay(50);
}