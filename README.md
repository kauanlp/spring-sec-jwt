# Simple Spring Security JWT Authentication Project

This project demonstrates the implementation of JWT (JSON Web Token) based authentication using Spring Security. It provides a REST API with endpoints for authentication and access to protected resources.

---

## **Flow of Operation**

### **1. Authentication (POST /authenticate)**

- **Objective**: Validate user credentials and provide a **JWT**.
- **Process**:
    1. The client (e.g., frontend application or Postman) sends a POST request to the `/authenticate` endpoint with a JSON payload containing `username` and `password`.
    2. The application validates the credentials against a database or in-memory configuration.
    3. If the credentials are valid:
        - A **JWT** is generated. This token contains user details (claims), such as the username and roles, and has an expiration time.
    4. The token is returned to the client.

- **Result**:
  The client receives a JWT, which will be used to access protected endpoints.


### **2. Authorization and Protected Access (GET /private)**

- **Objective**: Ensure only authenticated users can access protected resources.
- **Process**:
    1. The client includes the JWT in the request header:
       ```
       Authorization: Bearer <your-jwt-token>
       ```
    2. The application intercepts the request using Spring Security filters and validates the JWT:
        - The token is decoded.
        - Spring checks if the token is valid (signature, expiration, etc.).
    3. If the token is valid:
        - The request is granted access to the protected resource.
    4. If the token is invalid or missing:
        - The application returns an HTTP 401 (Unauthorized) error.

- **Result**:
  Authenticated users can access the resource, while unauthenticated requests are blocked.

---

## **Key Components**

1. **JWT**
    - **Signature**: The token is digitally signed to prevent tampering.
    - **Token Structure**:
        - **Header**: Contains the type of token (JWT) and the signing algorithm.
        - **Payload**: Contains user information (claims).
        - **Signature**: Ensures the token’s integrity.

2. **Spring Security**
    - Configures security to:
        - Enforce authentication for protected endpoints.
        - Validate JWT tokens.

3. **Filters**
    - A filter intercepts all incoming requests to check if the JWT token in the `Authorization` header is valid before passing the request to controllers.

4. **Token Generator**
    - Generates JWT tokens using a secret key configured in the project.

5. **Validators**
    - Validates the signature and expiration of incoming tokens.

---

## **How the Components Interact**

1. The client authenticates via `/authenticate` and receives a JWT.
2. To access `/private`, the client must include the token in the request header.
3. Spring Security validates the token:
    - If valid, the request is processed.
    - If invalid or missing, the request is rejected.