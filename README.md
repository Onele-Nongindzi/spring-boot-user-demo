# Spring Boot User Management Demo
## Overview
This project is a simple Spring Boot web application demonstrating core concepts such as MVC layered architecture, dependency injection, annotations, in-memory data storage, and unit testing. It implements a user management system with CRUD operations (Create, Read, Delete) accessible via REST API endpoints.
Features

MVC Architecture: Separates concerns with Model (User), Repository (FakeRepo), Service (UserService), and Controller (UserController).
Dependency Injection: Uses Spring’s @Autowired for constructor-based injection.
In-Memory Storage: Simulates a database using a List<User> in FakeRepo.
REST API: Exposes endpoints for adding, retrieving, and removing users.
Unit Tests: Covers service methods and edge cases using JUnit 5.
Gitflow Workflow: Follows branching strategy with main, develop, and feature branches.

## Technologies

Java: 17
Spring Boot: 3.3.5
JUnit: 5
Gradle: 8.13

## Prerequisites

JDK 17: Ensure Java 17 is installed (e.g., Eclipse Temurin).
Gradle: Included via the Gradle wrapper (gradlew).
Git: For cloning and version control.

## How to Run

Clone the Repository:
git clone <repository-url>
cd spring-boot-user-demo


Start the Application:
./gradlew bootRun


The application runs on http://localhost:8080.
Console outputs (e.g., [name] added) appear when API endpoints are called.



## API Endpoints
Use tools like curl, Postman, or a browser to interact with the API. User IDs are auto-generated sequentially (starting from 1).



Method
Endpoint
Description
Example Request



## POST
/api/users?name={name}&surname={surname}
Add a new user
curl -X POST "http://localhost:8080/api/users?name=John&surname=Doe"


## GET
/api/users/{id}
Retrieve a user by ID
curl -X GET "http://localhost:8080/api/users/1"


## DELETE
/api/users/{id}
Remove a user by ID
curl -X DELETE "http://localhost:8080/api/users/1"


## Console Outputs:

POST: [name] added
GET: hello [name] (if user exists)
DELETE: [name] removed (if user exists)

## How to Test

Run Unit Tests:
./gradlew test


Tests cover UserService methods and edge cases (duplicates, invalid input, non-existent users).
View the test report: build/reports/tests/test/index.html.


## Manual Testing:

Use the API endpoints above to verify functionality.
Check the console for expected outputs.



## Project Structure
spring-boot-user-demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java        # Spring Boot entry point
│   │   │   ├── model/
│   │   │   │   ├── User.java              # User model
│   │   │   ├── repo/
│   │   │   │   ├── FakeRepoInterface.java # Repository interface
│   │   │   │   ├── FakeRepo.java          # In-memory repository
│   │   │   ├── service/
│   │   │   │   ├── UserService.java       # Service interface
│   │   │   │   ├── UserServiceImpl.java   # Service implementation
│   │   │   ├── controller/
│   │   │   │   ├── UserController.java    # REST controller
│   ├── test/
│   │   ├── java/com/example/demo/service/
│   │   │   ├── UserServiceTests.java      # Unit tests
├── build.gradle                           # Gradle build file
├── .gitignore                             # Git ignore file
├── README.md                              # Project documentation

## Git Workflow
This project follows the Gitflow branching model:

main: Stable, production-ready code.
develop: Integration branch for new features.
feature/xyz: Feature branches (e.g., feature/user-management).
Workflow:
Create a feature branch: git checkout -b feature/<feature-name>
Commit changes: git commit -m "<type>: <description>" (e.g., feat: add REST controller)
Push: git push origin feature/<feature-name>
Open a Pull Request to develop.
Merge to develop, then to main after review.



Commit Message Types: feat, fix, test, docs, refactor, style, chore.
Troubleshooting

Tests Fail: Check the test report (build/reports/tests/test/index.html) for details.
API Issues: Ensure the application is running (./gradlew bootRun) and use correct endpoint syntax.
Java Warning: Set JAVA_HOME to a valid JDK 17 path and run ./gradlew javaToolchains to diagnose.
Gradle Deprecation: Run ./gradlew build --warning-mode all to identify issues.

## Contributing

Fork the repository.
Create a feature branch: git checkout -b feature/your-feature.
Commit changes: git commit -m "feat: add your feature".
Push: git push origin feature/your-feature.
Open a Pull Request to develop.

## License
This project is licensed under the MIT License.
