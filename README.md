# Certo

A platform for ECET aspirants. This Spring Boot application serves as the backend for user management and authentication.

## 🛠 Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 4.0.1
- **Key Dependencies:**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Web
  - Spring Boot Starter Validation
  - MySQL Driver
  - Lombok
- **Build Tool:** Maven

## 📋 Architecture Overview

The application follows a proper layered architecture:

```
Controller Layer (logincontroller.java)
    ↓
Service Interface (loginservice.java)
    ↓
Service Implementation (loginserviceimplentatio.java)
    ↓
Repository Layer (loginrepo.java)
    ↓
Database (MySQL - certo)
```

## 🚀 Features & API Endpoints

### 1. User Registration
- **URL:** `POST http://localhost:8081/api/v1/login`
- **Description:** Adds a single user with username, email, password, and terms acceptance status.
- **Request Body:**
  ```json
  {
    "username": "john_doe",
    "email": "john@example.com",
    "password": "pass123",
    "acceptedTermsAndConditions": true,
    "address": {
       "street": "123 Main St",
       "city": "Nellore",
       "state": "AP",
       "zipCode": "524001"
    }
  }
  ```

### 2. Fetch All Users
- **URL:** `GET http://localhost:8081/api/v1/users`
- **Description:** Retrieves all users registered in the database.
- **Response:** JSON array of user objects.

## 📊 Database Schema

### Table: `users`

| Column Name                      | Type         | Nullable | Description                          |
|----------------------------------|--------------|----------|--------------------------------------|
| id                               | BIGINT       | NO       | Primary Key (Auto Increment)         |
| username                         | VARCHAR(255) | YES      | User's username                      |
| email                            | VARCHAR(255) | YES      | User's email address                 |
| password                         | VARCHAR(255) | YES      | User's password                      |
| accepted_terms_and_conditions    | TINYINT(1)   | YES      | Boolean for T&C acceptance           |
| address_id                       | BIGINT       | YES      | Foreign Key to Address table         |

### Table: `address` (Linked One-To-One)
*Note: Linked to User entity via One-To-One relationship.*

## � Getting Started

### Prerequisites
- JDK 17 or later
- MySQL Server
- Maven (optional, wrapper provided)

### Installation & Run
1. Clone the repository.
2. Configure your database settings in `application.properties`.
3. Run the application:

```powershell
.\mvnw.cmd spring-boot:run
```

### Usage Examples (PowerShell)

**Add a User:**
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/login -Method POST -UseBasicParsing -ContentType "application/json" -Body '{"username":"john_doe","email":"john@example.com","password":"pass123","acceptedTermsAndConditions":true}'
```

**Fetch All Users:**
```powershell
(Invoke-WebRequest -Uri http://localhost:8081/api/v1/users -Method GET -UseBasicParsing).Content
```

## 📁 Project Structure

```
src/main/java/com/cetnext/certo/
├── controller/
│   └── logincontroller.java         # REST endpoints
├── service/
│   ├── loginservice.java            # Service interface
│   └── implementation/
│       └── loginserviceimplentatio.java # Service implementation
├── repo/
│   └── loginrepo.java               # JPA Repository
└── models/
    └── login.java                   # Entity model
```
