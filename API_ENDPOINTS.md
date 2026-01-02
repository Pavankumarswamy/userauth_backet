# API Documentation

## Base URL
`/api/v1`

## Endpoints

### 1. Add Single User
- **URL**: `/login`
- **Method**: `POST`
- **Description**: Adds a new user to the system.
- **Request Body**: JSON object representing the user.
  ```json
  {
    "username": "string",
    "email": "user@example.com",
    "password": "password123",
    "acceptedTermsAndConditions": true,
    "address": {
      "addressLine1": "string",
      "addressLine2": "string",
      "city": "string",
      "state": "string",
      "zipCode": "string",
      "country": "string"run as 
    }
  }
  ```
- **Response**: String message (e.g., "User added successfully!").

### 2. Get All Users
- **URL**: `/users`
- **Method**: `GET`
- **Description**: Retrieves a list of all registered users.
- **Response**: Array of user objects.
  ```json
  [
    {
      "id": 1,
      "username": "user1",
      "email": "user1@example.com",
      ...
    },
    ...
  ]
  ```

### 3. Get User by Email
- **URL**: `/user/{email}`
- **Method**: `GET`
- **Description**: Retrieves a specific user by their email address.
- **Path Variables**:
  - `email`: The email address of the user to retrieve.
- **Response**: User object.

### 4. Update User by Email
- **URL**: `/user/{email}`
- **Method**: `PUT`
- **Description**: Updates an existing user's information.
- **Path Variables**:
  - `email`: The email address of the user to update.
- **Request Body**: JSON object with updated user details.
- **Response**: String message (e.g., "User updated successfully!").

### 5. Delete User by Email
- **URL**: `/user/{email}`
- **Method**: `DELETE`
- **Description**: Deletes a user from the system based on their email.
- **Path Variables**:
  - `email`: The email address of the user to delete.
- **Response**: String message (e.g., "User with email ... deleted successfully!").

### 6. Add Multiple Users
- **URL**: `/users`
- **Method**: `POST`
- **Description**: Adds multiple users in a single request.
- **Request Body**: Array of user objects.
  ```json
  [
    {
      "username": "user1",
      ...
    },
    {
      "username": "user2",
      ...
    }
  ]
  ```
- **Response**: List of added user objects.

## Data Models

### User (Login)
| Field | Type | Description |
|-------|------|-------------|
| id | Long | Unique identifier (Auto-generated) |
| username | String | User's display name |
| email | String | User's email address (Must be valid format) |
| password | String | User's password (Min: 4, Max: 15 characters) |
| acceptedTermsAndConditions | Boolean | Whether terms were accepted |
| address | Object | Nested address object |
