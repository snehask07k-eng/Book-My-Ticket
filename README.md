# 🎬 Book My Ticket

A full-stack movie ticket booking application developed using **Java, Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA, Hibernate, MySQL, Redis, and supporting services**.

The application provides functionality for managing users, movies, theatres, screens, seats, shows, and booked tickets.

## 🚀 Features

* User registration and login
* User management
* Movie management
* Theatre management
* Screen management
* Seat management
* Show management
* Movie ticket booking
* Booked ticket management
* Seat layout management
* Password-related operations
* Admin registration
* Database initialization and data seeding
* QR code generation
* Email integration
* Cloudinary integration for media management
* Redis service integration
* Global exception handling
* AES-based encryption utility

## 🛠️ Technologies Used

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java            | Application development         |
| Spring Boot     | Backend framework               |
| Spring MVC      | Web/application layer           |
| Spring Data JPA | Database repository layer       |
| Hibernate       | ORM                             |
| MySQL           | Relational database             |
| Redis           | Data/service integration        |
| Thymeleaf       | Server-side web pages           |
| Maven           | Build and dependency management |
| Cloudinary      | Media/cloud image handling      |
| HTML/CSS        | Frontend                        |
| JavaScript      | Client-side functionality       |

## 🏗️ Architecture

```text
                User / Browser
                      │
                      ▼
              Thymeleaf / Web UI
                      │
                      ▼
                 Controller
                      │
                      ▼
                  Service
                      │
                      ▼
                Repository
                      │
              ┌───────┴────────┐
              ▼                ▼
        JPA / Hibernate       Redis
              │
              ▼
             MySQL
```

## 📂 Project Structure

```text
src/main/java/com/jsp/book/

├── config/
│   └── MyConfig.java
│
├── controller/
│   └── UserController.java
│
├── dto/
│   ├── LoginDto.java
│   ├── MovieDto.java
│   ├── PasswordDto.java
│   ├── ScreenDto.java
│   ├── SeatLayoutForm.java
│   ├── SeatRowDto.java
│   ├── ShowDto.java
│   ├── TheaterDto.java
│   └── UserDto.java
│
├── entity/
│   ├── BookedTicket.java
│   ├── Movie.java
│   ├── Screen.java
│   ├── Seat.java
│   ├── Show.java
│   ├── ShowSeat.java
│   ├── Theater.java
│   └── User.java
│
├── exception/
│   └── GlobalExceptionHandler.java
│
├── repository/
│   ├── MovieRepository.java
│   ├── ScreenRepository.java
│   ├── SeatRepository.java
│   ├── ShowRepository.java
│   ├── ShowSeatRepository.java
│   ├── TheaterRepository.java
│   ├── TicketRepository.java
│   └── UserRepository.java
│
├── service/
│   ├── RedisService.java
│   ├── RedisServiceImpl.java
│   ├── UserService.java
│   └── UserServiceImpl.java
│
└── util/
    ├── AdminRegistration.java
    ├── AES.java
    ├── CloudinaryHelper.java
    ├── CloudinaryMigrator.java
    ├── DataSeeder.java
    ├── EmailHelper.java
    └── QrHelper.java
```

## 🗃️ Main Entities

The application contains the following major domain entities:

* User
* Movie
* Theater
* Screen
* Seat
* Show
* ShowSeat
* BookedTicket

These entities are persisted using **JPA/Hibernate**.

## 📦 DTO Layer

DTO classes are used to transfer application data between different layers and handle form/request data.

Examples include:

* `LoginDto`
* `MovieDto`
* `ScreenDto`
* `ShowDto`
* `TheaterDto`
* `UserDto`
* `PasswordDto`
* `SeatLayoutForm`

## 🗄️ Repository Layer

The project contains Spring Data repository interfaces for:

* Movies
* Screens
* Seats
* Shows
* Show Seats
* Theatres
* Tickets
* Users

## 🔧 Utility Components

The project includes utility components for:

### AES

Provides AES-based encryption-related functionality.

### QR Helper

Handles QR code generation functionality.

### Email Helper

Provides email-related functionality.

### Cloudinary Helper

Handles Cloudinary-related media operations.

### Data Seeder

Provides initial application data.

### Admin Registration

Handles administrator registration during application initialization.

## ⚠️ Global Exception Handling

The application contains a centralized:

```text
GlobalExceptionHandler
```

for handling application exceptions.

## 🗄️ Database

The application uses **MySQL** for persistent data storage.

The database used by the application is:

```text
book-my-ticket
```

Hibernate/JPA handles object-relational mapping between Java entities and database tables.

## ▶️ How to Run

### Prerequisites

Install:

* Java 17
* MySQL 8
* Maven
* Git

### 1. Clone the repository

```bash
git clone https://github.com/snehask07k-eng/Book-My-Ticket.git
```

### 2. Open the project

Open the project in **VS Code, IntelliJ IDEA, or Eclipse**.

### 3. Configure MySQL

Update your database configuration in:

```text
src/main/resources/application.properties
```

Use your own MySQL username and password.

### 4. Build the project

Windows:

```bash
mvnw.cmd clean install
```

### 5. Run the application

```bash
mvnw.cmd spring-boot:run
```

The application is configured to run on:

```text
http://localhost
```

## 🧪 Testing

The application can be tested through the web interface and by verifying database operations using MySQL.

## 📚 Key Learning Outcomes

* Developed a full-stack Java application using Spring Boot
* Implemented MVC-based web application architecture
* Worked with Spring Data JPA and Hibernate
* Integrated MySQL with a Spring Boot application
* Implemented DTO-based data transfer
* Worked with Redis integration
* Implemented centralized exception handling
* Worked with email and QR-code functionality
* Integrated Cloudinary for media management
* Used Maven for dependency and project management
* Used Git and GitHub for source-code management

## 👩‍💻 Developer

**Sneha S**

Java Developer Fresher | Java Full Stack | Spring Boot | REST APIs | SQL | MySQL
