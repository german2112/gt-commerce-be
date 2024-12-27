## **Overview**
This service is a key component of an e-commerce platform, responsible for managing user authentication and authorization using **Spring Security** with **JWT (JSON Web Tokens)**. The service provides secure endpoints for user registration, login, and role-based access control to protect sensitive resources.

The authentication service ensures a seamless and secure login experience, supporting scalability and performance requirements for modern e-commerce applications.

---

## **Features**
1. **JWT-Based Authentication**:
   - Issues secure JWT tokens upon successful user login.
   - Validates tokens on every API request to ensure user authenticity.

2. **User Roles and Permissions**:
   - Supports multiple roles, such as `ADMIN`, `CUSTOMER`, and `MERCHANT`.
   - Implements role-based access control to protect resources.

3. **User Management**:
   - Endpoints for user registration, login, and profile updates.

4. **Token Management**:
   - Stateless authentication using access tokens.
   - Optionally supports token refresh functionality.

5. **Spring Security Integration**:
   - Configures secure access to endpoints using Spring Security filters and annotations.

---

## **Technologies Used**
- **Spring Boot**: Provides a lightweight framework for rapid development.
- **Spring Security**: Manages authentication and authorization seamlessly.
- **JWT**: Ensures stateless and secure communication between the client and server.
- **PostgreSQL**: Stores user credentials and role data securely.
- **Docker**: Facilitates containerized deployment for consistent environments.

---

## **API Endpoints**
### **Authentication**
- **`POST /auth/register`**: Register a new user.
  - **Request Body**:
    ```json
    {
      "username": "john_doe",
      "password": "secure_password",
      "email": "john.doe@example.com",
      "role": "CUSTOMER"
    }
    ```
  - **Response**:
    ```json
    {
      "message": "User registered successfully"
    }
    ```

- **`POST /auth/login`**: Authenticate a user and generate a JWT token.
  - **Request Body**:
    ```json
    {
      "username": "john_doe",
      "password": "secure_password"
    }
    ```
  - **Response**:
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```

### **Protected Endpoints**
- **`GET /users/profile`**: Retrieve the authenticated user’s profile.
  - **Header**: `Authorization: Bearer <JWT_TOKEN>`
  - **Response**:
    ```json
    {
      "id": 1,
      "username": "john_doe",
      "email": "john.doe@example.com",
      "role": "CUSTOMER"
    }
    ```

- **`POST /admin/create-product`**: Add a new product (restricted to `ADMIN` role).
  - **Header**: `Authorization: Bearer <JWT_TOKEN>`

---

### **Future Enhancements**
Token Refresh Mechanism: Add support for token refresh endpoints.
OAuth2 Integration: Enable social login (e.g., Google, Facebook).
Audit Logs: Track user activities for enhanced security.
Rate Limiting: Implement rate limiting to prevent abuse.
Conclusion
The E-Commerce Authentication Service provides a secure, scalable, and efficient solution for user authentication and authorization. With Spring Security and JWT, it ensures that sensitive resources remain protected while delivering a seamless user experience.


