# Spring Boot User Management Demo

## 🧭 Overview

This project is a simple Spring Boot web application demonstrating core concepts such as MVC layered architecture, dependency injection, annotations, in-memory data storage, and unit testing. It implements a user management system with CRUD operations accessible via REST API endpoints.

### ✨ Features

- **MVC Architecture**: Separation of concerns using Model, Repository, Service, and Controller layers.
- **Dependency Injection**: Utilizes Spring’s `@Autowired` with constructor-based injection.
- **In-Memory Storage**: Simulates a database using a `List<User>` in `FakeRepo`.
- **REST API**: Provides endpoints to add, retrieve, and delete users.
- **Unit Tests**: Covers service logic and edge cases using JUnit 5.
- **Gitflow Workflow**: Organized development using `main`, `develop`, and `feature/*` branches.

---

## 🛠️ Technologies

- Java: 17  
- Spring Boot: 3.3.5  
- JUnit: 5  
- Gradle: 8.13  

---

## ⚙️ Prerequisites

- **JDK 17** installed  
- **Gradle** (via wrapper included)  
- **Git** for version control  

---

## 🚀 How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Onele-Nongindzi/spring-boot-user-demo.git
   cd spring-boot-user-demo
2. Start the application:
- ./gradlew bootRun
3. Access the app at:
http://localhost:8080

Console logs show feedback like [name] added when endpoints are called.

## 📡 API Endpoints
Interact using curl, Postman, or a browser.

Method	Endpoint	Description	Example
- POST	/api/users?name={name}&surname={surname}	Add a new user	curl -X POST "http://localhost:8080/api/users?name=John&surname=Doe"
- GET	/api/users/{id}	Retrieve user by ID	curl -X GET "http://localhost:8080/api/users/1"
- DELETE	/api/users/{id}	Remove user by ID	curl -X DELETE "http://localhost:8080/api/users/1"

Console Output Examples:

- POST: [name] added

- GET: hello [name]

- DELETE: [name] removed

## ✅ How to Test
Run unit tests with:

- ./gradlew test
- Test results: build/reports/tests/test/index.html

Covers service logic and edge cases like invalid input or duplicates.

## 🧪 Manual Testing
Use the API endpoints listed above to manually verify:

1. Adding new users

2. Fetching existing users

3. Removing users

4. Check terminal output for success messages.

5. Follows the Gitflow branching model:

6. main: Stable, production-ready code

7. develop: Integrated changes under review

8. feature/xyz: Individual features

Example Workflow:

- git checkout -b feature/your-feature
- git commit -m "feat: add REST controller"
- git push origin feature/your-feature
- Then open a Pull Request to develop, and later merge into main.

Commit message types: feat, fix, test, docs, refactor, style, chore

## 🧰 Troubleshooting
Tests fail: Check the test report at build/reports/tests/test/index.html

API errors: Ensure server is running and using valid endpoints

Java issues: Verify JAVA_HOME is set to JDK 17

Gradle deprecations: Run ./gradlew build --warning-mode all to identify problems

## 🤝 Contributing
1. Fork the repo

#### Create your branch:
git checkout -b feature/your-feature

##### Commit and push your changes:
git commit -m "feat: add your feature"

#### Open a Pull Request to develop

## 📄 License
This project is licensed under the MIT License.
