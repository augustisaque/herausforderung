# T-Systems Herausforderung

Basic challange project using Java, Spring Boot, Docker, SQL and Maven.

## Installation

In the project directory run the command below to start the SQL Server in a docker container:

```bash
docker-compose -f stack.yml up
```
## Requests

Use the requests that are located in the file requisicoes_postman.txt to test the services.

## Database

Run the command below in your sql editor to create the database:

```bash
CREATE DATABASE tsystems;
```

To configure the sql port, user and password, see the file stack.yml located in the main directory.
