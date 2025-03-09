![alt](logo.webp)

# NotifyX

This is a Spring Boot project for TCC (Demo project).

## Requirements

- Java 17
- Maven 3.6+

## Building the Project

To build the project, run:

```bash
mvn clean install
```

## Running the Application

To run the application, use:

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## API Documentation

The API documentation is available through Swagger UI:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Specification: http://localhost:8080/api-docs

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── phrq/
│   │           └── notifyback/
│   │               ├── config/
│   │               │   └── OpenApiConfig.java
│   │               ├── controller/
│   │               ├── service/
│   │               ├── repository/
│   │               ├── model/
│   │               ├── dto/
│   │               ├── exception/
│   │               ├── util/
│   │               └── NotifybackApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── phrq/
                └── notifyback/
                    └── NotifybackApplicationTests.java
```

## Package Structure

- `controller`: REST controllers for handling HTTP requests
- `service`: Business logic implementation
- `repository`: Data access layer interfaces
- `model`: Domain model classes
- `dto`: Data Transfer Objects for API requests/responses
- `exception`: Custom exceptions and error handlers
- `util`: Utility classes and helper methods
- `config`: Application configuration classes

## Features

- Spring Boot 3.4.3
- Java 17
- RESTful API support
- OpenAPI 3.0 Documentation (Swagger)
- Development tools (Spring Boot DevTools)
- Lombok for reducing boilerplate code
- Comprehensive test support 