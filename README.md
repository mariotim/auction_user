# Auction User

This service provides functionality to create users and generate tokens

## Installation

### Clone the Repository

You can clone the repository using the following command:

```bash
git clone https://github.com/mariotim/auction_user.git
```

## Compile the Project

To compile the project, navigate to the project directory and run:

```bash
mvn clean package
```

## Usage

### Start Spring Boot Application

To start the Spring Boot application, navigate to the project directory and run:

```bash
java -jar target/auction_user-1.0-SNAPSHOT.jar
```

## API Endpoints
Create user and generate token

### The service exposes an API endpoints to register a user .

##### Register user

```
curl -X POST localhost:8081/api/auth/register \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{
        "username": "test",
        "active": true,
        "password": "test"
    }' 

```

##### Login

```
curl -X POST localhost:8081/api/auth/login \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{
        "username": "test",
        "password": "test"
    }' 

```
