# Book My Ticket

## 📌 Project Overview

Book My Ticket is a backend web application developed using **Java and Spring Boot** for managing movie ticket booking operations.

The application demonstrates backend development concepts including **Spring MVC, REST APIs, Hibernate/JPA, MySQL, and layered architecture**.

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring MVC
* REST API
* Hibernate
* JPA
* MySQL
* Maven
* HTML/CSS
* Git & GitHub

## ✨ Features

* Movie management
* Theatre management
* Show management
* User management
* Ticket booking
* Database operations using MySQL
* REST API-based backend communication
* Layered application architecture

## 🏗️ Project Architecture

```text
Client
  ↓
Controller
  ↓
Service
  ↓
DAO / Repository
  ↓
Hibernate / JPA
  ↓
MySQL Database
```

## 📂 Project Structure

```text
Book-My-Ticket/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## 🗄️ Database

The application uses **MySQL** as the relational database.

**Hibernate/JPA** is used to perform persistence and database operations.

Database configuration can be maintained in:

```text
src/main/resources/application.properties
```

## 🔗 REST APIs

The application provides REST APIs for managing different modules such as movies, users, theatres, shows, and bookings.

Example API operations:

```text
POST   /...
GET    /...
GET    /{id}
PUT    /{id}
DELETE /{id}
```

> Replace the example paths above with the exact endpoint mappings implemented in this project.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/snehask07k-eng/Book-My-Ticket.git
```

### 2. Open the project

Open the project in **IntelliJ IDEA** or **Eclipse**.

### 3. Configure MySQL

Update the database username, password, and database name in:

```text
src/main/resources/application.properties
```

### 4. Build the project

Using Maven:

```bash
./mvnw clean install
```

On Windows:

```bash
mvnw.cmd clean install
```

### 5. Run the application

Run the Spring Boot main application class.

## 🧪 API Testing

REST APIs can be tested using **Postman**.

## 📚 Learning Outcomes

Through this project, I gained practical experience in:

* Java backend development
* Spring Boot application development
* REST API development
* Spring MVC
* Hibernate/JPA
* MySQL database integration
* Layered architecture
* Maven project management
* API testing using Postman
* Git and GitHub

## 👩‍💻 Developer

**Sneha S**

Java Developer Fresher | Java Full Stack | Spring Boot | REST APIs | SQL | MySQL
