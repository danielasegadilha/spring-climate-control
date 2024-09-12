# Climate Control CRUD with Spring Boot

## Overview

A Spring Boot application for managing climate data. This project allows you to:

- **Retrieve Current Temperatures:** Get temperature data for specific municipalities.
- **Calculate Average Monthly Temperature:** Compute the average temperature for a municipality for the current month.

## Features

- **GET /temperature:** Returns all the daily temperatures 
- **GET /temperature/{municipalityId}:** Fetch current temperature for a municipality.
- **GET /temperature/average/{municipalityId}:** Calculate the average temperature for the current month.

## Technologies

- Spring Boot
- JPA/Hibernate
- Swagger

## Getting Started

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/climate-control-crud.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd climate-control-crud
    ```
3. **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
