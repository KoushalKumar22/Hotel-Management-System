# Microservices Project with Eureka Server and API Gateway

This project demonstrates a microservices architecture that includes the following components:
- **Registration Service**: Handles user registration.
- **Booking Service**: Manages booking information.
- **Eureka Server**: Service discovery.
- **API Gateway**: Entry point for routing requests to microservices.

## Project Structure

### Services
1. **Eureka Server**
   - Acts as a service registry where all microservices register themselves.
2. **API Gateway**
   - Centralized routing for all microservices.
   - Load balancing and request filtering.
3. **Registration Service**
   - Manages user details and integrates with the Booking Service.
4. **Booking Service**
   - Handles booking-related data.

### Technologies Used
- **Spring Boot** for building microservices.
- **Spring Cloud Netflix Eureka** for service discovery.
- **Spring Cloud Gateway** for routing and load balancing.
- **JPA/Hibernate** for database operations.
- **postgreSQL** (can be replaced with other databases).
- **Docker** (optional) for containerization.

## Prerequisites

- Java 17+
- Maven 3.8+

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Run Eureka Server
Navigate to the `eureka-server` folder and run:
```bash
mvn spring-boot:run
```
Access the Eureka dashboard at `http://localhost:8761`.

### 3. Run API Gateway
Navigate to the `api-gateway` folder and run:
```bash
mvn spring-boot:run
```
API Gateway will listen on `http://localhost:8083`.

### 4. Run Microservices
- Navigate to `registration-service` and run:
  ```bash
  mvn spring-boot:run
  ```
- Navigate to `booking-service` and run:
  ```bash
  mvn spring-boot:run
  ```

### 5. Test Endpoints

#### Endpoints through API Gateway
- **Registration Service**:
  - `GET /register/Id/{id}`
  - `GET /register/allRegistrations`
- **Booking Service**:
  - `GET /booking/all`
  - `POST /booking/save`

#### Direct Endpoints (Bypassing Gateway)
- Registration Service: `http://localhost:8888`
- Booking Service: `http://localhost:9999`

### Example Request

#### Save Booking (Using Postman or Curl)
```bash
POST http://localhost:9999/booking/save
Content-Type: application/json

{
  "roomNo": 101,
  "tableNo": 5
}
```

### Eureka Dashboard
- Microservices will be listed in the Eureka dashboard at `http://localhost:8761`.


## Notes
- Ensure all microservices register with Eureka and are accessible via the API Gateway.
- Update the `application.yml` or `application.properties` files with the correct Eureka Server URL and service discovery settings.

## Future Enhancements
- Add New Services
- Add Resilience4j
- Add Splunk
- Add authentication and authorization using Spring Security and OAuth2.

---

### Author
[Koushal Kumar](https://github.com/koushalkumar22)

