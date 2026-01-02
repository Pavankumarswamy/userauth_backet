# API Testing Guide

## Prerequisites
- MySQL server running on localhost:3306
- Database named 'certo' should exist
- Spring Boot application running on port 8081

## API Endpoints

### 1. Add Single User
**Endpoint:** `POST http://localhost:8081/api/v1/login`

**Description:** Adds a single user to the database.

**Sample Request:**
```bash
curl -X POST http://localhost:8081/api/v1/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "pass123",
    "acceptedTermsAndConditions": true
  }'
```

**PowerShell:**
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/login -Method POST -UseBasicParsing -ContentType "application/json" -Body '{"username":"john_doe","email":"john@example.com","password":"pass123","acceptedTermsAndConditions":true}'
```

**Sample Response:**
```
User added successfully!
```

---

### 2. Add Multiple Users
**Endpoint:** `POST http://localhost:8081/api/v1/users`

**Description:** Adds multiple users at once to the database.

**Sample Request:**
```bash
curl -X POST http://localhost:8081/api/v1/users \
  -H "Content-Type: application/json" \
  -d '[
    {
      "username": "user1",
      "email": "user1@example.com",
      "password": "pass1",
      "acceptedTermsAndConditions": true
    },
    {
      "username": "user2",
      "email": "user2@example.com",
      "password": "pass2",
      "acceptedTermsAndConditions": false
    }
  ]'
```

**PowerShell:**
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/users -Method POST -UseBasicParsing -ContentType "application/json" -Body '[{"username":"user1","email":"user1@example.com","password":"pass1","acceptedTermsAndConditions":true},{"username":"user2","email":"user2@example.com","password":"pass2","acceptedTermsAndConditions":false}]'
```

**Sample Response:**
```json
[
  {
    "id": 1,
    "username": "user1",
    "email": "user1@example.com",
    "password": "pass1",
    "acceptedTermsAndConditions": true
  },
  {
    "id": 2,
    "username": "user2",
    "email": "user2@example.com",
    "password": "pass2",
    "acceptedTermsAndConditions": false
  }
]
```

---

### 3. Get All Users
**Endpoint:** `GET http://localhost:8081/api/v1/users`

**Description:** Retrieves all users from the database.

**Sample Request:**
```bash
curl -X GET http://localhost:8081/api/v1/users
```

**PowerShell:**
```powershell
(Invoke-WebRequest -Uri http://localhost:8081/api/v1/users -Method GET -UseBasicParsing).Content | ConvertFrom-Json | ConvertTo-Json -Depth 3
```

**Sample Response:**
```json
[
  {
    "id": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "password": "pass123",
    "acceptedTermsAndConditions": true
  }
]
```

---

### 4. Get User by Email
**Endpoint:** `GET http://localhost:8081/api/v1/user/{email}`

**Description:** Retrieves a specific user by their email address.

**Sample Request:**
```bash
curl -X GET http://localhost:8081/api/v1/user/john@example.com
```

**PowerShell:**
```powershell
(Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/john@example.com -Method GET -UseBasicParsing).Content
```

**Sample Response:**
```json
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "password": "pass123",
  "acceptedTermsAndConditions": true
}
```

---

### 5. Update User by Email
**Endpoint:** `PUT http://localhost:8081/api/v1/user/{email}`

**Description:** Updates an existing user identified by their email.

**Sample Request:**
```bash
curl -X PUT http://localhost:8081/api/v1/user/john@example.com \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_updated",
    "email": "john_new@example.com",
    "password": "newpass123",
    "acceptedTermsAndConditions": true
  }'
```

**PowerShell:**
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/john@example.com -Method PUT -UseBasicParsing -ContentType "application/json" -Body '{"username":"john_updated","email":"john_new@example.com","password":"newpass123","acceptedTermsAndConditions":true}'
```

**Sample Response:**
```
User updated successfully!
```

---

### 6. Delete User by Email
**Endpoint:** `DELETE http://localhost:8081/api/v1/user/{email}`

**Description:** Deletes a user from the database by their email.

**Sample Request:**
```bash
curl -X DELETE http://localhost:8081/api/v1/user/john@example.com
```

**PowerShell:**
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/john@example.com -Method DELETE -UseBasicParsing
```

**Sample Response:**
```
User with email john@example.com deleted successfully!
```

---

## Complete Testing Flow

### 1. Start the Application:
```powershell
.\mvnw.cmd spring-boot:run
```

### 2. Add a single user:
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/login -Method POST -UseBasicParsing -ContentType "application/json" -Body '{"username":"alice","email":"alice@example.com","password":"pass123","acceptedTermsAndConditions":true}'
```

### 3. Add multiple users:
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/users -Method POST -UseBasicParsing -ContentType "application/json" -Body '[{"username":"bob","email":"bob@example.com","password":"pass456","acceptedTermsAndConditions":true},{"username":"charlie","email":"charlie@example.com","password":"pass789","acceptedTermsAndConditions":false}]'
```

### 4. Get all users:
```powershell
(Invoke-WebRequest -Uri http://localhost:8081/api/v1/users -Method GET -UseBasicParsing).Content
```

### 5. Get specific user:
```powershell
(Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/alice@example.com -Method GET -UseBasicParsing).Content
```

### 6. Update user:
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/alice@example.com -Method PUT -UseBasicParsing -ContentType "application/json" -Body '{"username":"alice_updated","email":"alice_new@example.com","password":"newpass","acceptedTermsAndConditions":true}'
```

### 7. Delete user:
```powershell
Invoke-WebRequest -Uri http://localhost:8081/api/v1/user/bob@example.com -Method DELETE -UseBasicParsing
```

---

## Field Descriptions

| Field Name                    | Type    | Required | Description                                      |
|-------------------------------|---------|----------|--------------------------------------------------|
| username                      | String  | Yes      | Username for the user                            |
| email                         | String  | Yes      | Email address of the user (unique identifier)    |
| password                      | String  | Yes      | User's password                                  |
| acceptedTermsAndConditions    | Boolean | No       | Whether user accepted terms and conditions       |

**Note:** The `acceptedTermsAndConditions` field defaults to `false` if not provided.

---

## API Summary Table

| Method | Endpoint                  | Description                |
|--------|---------------------------|----------------------------|
| POST   | /api/v1/login             | Add single user            |
| POST   | /api/v1/users             | Add multiple users         |
| GET    | /api/v1/users             | Get all users              |
| GET    | /api/v1/user/{email}      | Get user by email          |
| PUT    | /api/v1/user/{email}      | Update user by email       |
| DELETE | /api/v1/user/{email}      | Delete user by email       |
