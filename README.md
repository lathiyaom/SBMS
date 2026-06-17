# Spring Boot RestClient - External API Integration

## Overview

This project demonstrates how to consume external REST APIs using Spring Boot's `RestClient`.

The application fetches user data from the DummyJSON API and processes the response using DTOs, a service layer, and a dedicated API client layer following clean architecture principles.

## Features

* Spring Boot 4.x
* RestClient Integration
* DTO-Based Response Mapping
* Service Layer Architecture
* External API Client Layer
* Exception Handling
* Logging Support
* Clean and Maintainable Code Structure

## API Used

DummyJSON Users API

```
GET https://dummyjson.com/users
```

Example Response:

```json
{
  "users": [
    {
      "id": 1,
      "firstName": "Emily",
      "lastName": "Johnson",
      "email": "emily.johnson@x.dummyjson.com"
    }
  ],
  "total": 208,
  "skip": 0,
  "limit": 30
}
```

## Project Structure

```
src/main/java
│
├── config
│   └── RestClientConfig.java
│
├── client
│   └── UserApiClient.java
│
├── dto
│   ├── UserDto.java
│   └── UsersResponse.java
│
├── service
│   └── UserService.java
│
├── runner
│   └── AppRunner.java
│
└── Application.java
```

## Architecture

```
Application Startup
        │
        ▼
CommandLineRunner
        │
        ▼
UserService
        │
        ▼
UserApiClient
        │
        ▼
RestClient
        │
        ▼
DummyJSON API
```

## RestClient Configuration

```java
@Bean
public RestClient restClient() {

    HttpComponentsClientHttpRequestFactory factory =
            new HttpComponentsClientHttpRequestFactory();

    factory.setReadTimeout(10_000);
    factory.setConnectionRequestTimeout(10_000);

    return RestClient.builder()
            .requestFactory(factory)
            .build();
}
```

## Running the Application

### Clone Repository

```bash
git clone <repository-url>
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

## Sample Output

```text
--------------------------------
ID       : 1
Name     : Emily Johnson
Email    : emily.johnson@x.dummyjson.com
Phone    : +81 965-431-3024
Username : emilys
--------------------------------
```

## Best Practices Implemented

* Constructor Dependency Injection
* DTO-Based Deserialization
* Separation of Concerns
* External API Client Layer
* Service Layer Abstraction
* Centralized RestClient Configuration
* Exception Handling
* Structured Logging

## Future Improvements

* Global Exception Handling
* Retry Mechanism
* Circuit Breaker (Resilience4j)
* Request/Response Logging
* API Authentication
* Unit & Integration Testing
* Pagination Support
* Caching with Redis

## Technologies Used

* Java 21
* Spring Boot
* Spring Web
* RestClient
* Maven
* DummyJSON API

## Learning Outcomes

By completing this project, you will understand:

* How to configure and use Spring RestClient
* How to consume external REST APIs
* How to map JSON responses to DTOs
* How to design service and client layers
* How external integrations are implemented in enterprise applications
* Clean architecture principles for Spring Boot applications
