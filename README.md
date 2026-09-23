# 🎬 Book My Ticket

## 📌 Project Overview

**Book My Ticket** is a web-based movie ticket booking application developed using **Java, Spring Boot, Spring MVC, Thymeleaf, Hibernate/JPA, and MySQL**.

The application provides functionality for managing movies, theatres, screens, seats, shows, users, and tickets through a Spring Boot backend with database persistence.

## 🛠️ Technologies Used

* Java 17
* Spring Boot 4.0.0
* Spring MVC
* Spring Data JPA
* Hibernate ORM
* MySQL 8
* Thymeleaf
* Maven
* HTML
* CSS
* JavaScript
* Git
* GitHub

## 🏗️ Application Architecture

```text
Web Browser
     ↓
Thymeleaf / HTML
     ↓
Controller
     ↓
Service Layer
     ↓
Repository Layer
     ↓
Spring Data JPA
     ↓
Hibernate
     ↓
MySQL Database
```

## ✨ Main Features

* User management
* Admin registration
* Movie management
* Theatre management
* Screen management
* Seat management
* Show management
* Show-seat management
* Ticket management
* MySQL database integration
* Server-side web pages using Thymeleaf
* Persistence using Spring Data JPA and Hibernate

## 📦 Main Modules

The project contains repository components for:

* User
* Movie
* Theatre
* Screen
* Seat
* Show
* Show Seat
* Ticket

## 🗄️ Database

The application uses **MySQL** for persistent data storage.

Database:

```text
book-my-ticket
```

The application connects to MySQL using the MySQL Connector/J driver.

Hibernate/JPA is used for ORM and database operations.

## 🔐 Admin Registration

The application includes an admin registration process.

On application startup, the project checks/registers the administrator account through the application's admin registration component.

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/snehask07k-eng/Book-My-Ticket.git
```

### 2. Open the project

Open the project using **IntelliJ IDEA** or **Eclipse**.

### 3. Configure MySQL

Make sure MySQL is installed and running.

Update the database configuration in:

```text
src/main/resources/application.properties
```

Use your own local MySQL username and password.

### 4. Build the project

On Windows:

```bash
mvnw.cmd clean install
```

Or using Maven:

```bash
mvn clean install
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

The application can be tested by opening the application in a browser and interacting with the available web pages.

Backend/database functionality can also be verified through application logs and MySQL.

## 📚 Key Learning Outcomes

* Developed a Java web application using Spring Boot
* Worked with Spring MVC and controller-based request handling
* Implemented database persistence using Spring Data JPA
* Used Hibernate ORM for database interaction
* Integrated MySQL with a Spring Boot application
* Worked with Thymeleaf for server-side web pages
* Implemented layered application architecture
* Worked with multiple JPA repository interfaces
* Used Maven for project build and dependency management
* Gained practical experience in developing a movie ticket booking application

## 👩‍💻 Developer

**Sneha S**

Java Developer Fresher | Java Full Stack | Spring Boot | REST APIs | SQL | MySQL
