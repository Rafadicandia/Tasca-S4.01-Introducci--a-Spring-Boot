# 🚀 Task S4.01 - Developing a REST API with Spring Boot

This project is the initial contact with **Spring Boot** and the development of a **REST API**. The goal is to build a minimal yet functional API that can receive and return data in **JSON** format, utilizing HTTP methods and applying best practices from the start.

---

## 📄 Exercise Description

This exercise focuses on configuring and developing a simple REST API for user management.

## Level 3: Refactoring to a Layered Architecture

This exercise focuses on evolving a basic API into a professional, scalable, and maintainable system by implementing a **Layered Architecture**. The goal is to separate concerns and adhere to **SOLID principles**, specifically the Single Responsibility Principle (SRP) and the Dependency Inversion Principle (DIP).

---

### 1. The Architectural Shift

Currently, the `UserController` handles everything: HTTP requests, business logic, and data storage. We will break this down into three distinct layers:

* **Controller Layer:** Manages HTTP requests and responses; delegates tasks to the Service.
* **Service Layer:** The "brain" of the app. It contains business logic, rules, and validations.
* **Repository Layer:** Manages data access (whether in-memory, a database, or an external API).

---

### 2. Implementation Steps

#### Step A: Establishing an Integration Test

Before moving code, convert your existing web tests into a full **Integration Test (End-to-End)**. This acts as a safety net to ensure the system still works after refactoring.

* **Tools:** Switch from `@WebMvcTest` to `@SpringBootTest` and use `@AutoConfigureMockMvc`.
* **Goal:** Verify that all layers work together correctly.

#### Step B: The Repository Pattern

Abstract your data access by creating a `UserRepository` interface. This allows the application to remain agnostic of how data is stored.

1. Define the **Interface** (e.g., `save`, `findAll`, `findById`).
2. Create a **Concrete Implementation** (e.g., `InMemoryUserRepository`) using a List.
3. Annotate the implementation with `@Repository` to register it as a Spring Bean.

#### Step C: The Service Layer

Move business logic out of the controller and into a `UserService`.

1. Define a `UserService` interface and a `UserServiceImpl` class.
2. **Inject** the Repository into the Service via the constructor.
3. Annotate with `@Service`.
4. Update the Controller to call the Service instead of the Repository or List directly.

---

### 3. Unit Testing with Mockito & TDD

Once the logic is in the Service layer, you can test it in isolation using **Mockito** to "mock" (simulate) the Repository.

**Task: Unique Email Validation (TDD Approach)**
Implement a rule where no two users can have the same email:

1. **Write the test first:** Use `@ExtendWith(MockitoExtension.class)` and `@Mock` to simulate repository behavior.
2. **Logic:** * If the email exists: Throw an `EmailAlreadyExistsException`.
* If it doesn't: Generate a UUID and save the user.


3. **Verify:** Ensure `repository.save()` is only called when the email is unique.

---

### Key Concepts to Master

* **Spring Beans & Dependency Injection:** Understanding how Spring manages object lifecycles.
* **Mockito:** Using `when(...).thenReturn(...)` and `verify()` for unit tests.
* **TDD (Test-Driven Development):** Writing failing tests before writing the implementation code.

Would you like me to provide a code template for the `UserServiceImplTest` using Mockito to help you get started?

---

## 💻 Technologies Used
| Technology | Version | Description |
| :--- | :--- | :--- |
| **Java** | **21** | Language and environment for development. |
| **Spring Boot** | **Latest stable version of v3.x.x** | Framework for rapidly building production-ready Spring applications. |
| **Maven** | **(N/A)** | Build automation and project management tool. |
| **Spring Web** | **(Dependency)** | Module providing web functionalities, including RESTful APIs. |
| **Spring Boot DevTools** | **(Dependency)** | Tools to improve development experience (e.g., automatic restart). |

---

## 🧱 Spring Initializr Project Configuration

The project was generated using [Spring Initializr](https://start.spring.io/) with the following settings:

| Configuration | Value |
| :--- | :--- |
| PROJECT | **Maven** |
| LANGUAGE | **Java** |
| SPRING BOOT | **Latest stable version of v3.x.x** |
| Group | **cat.itacademy.s04.t01** |
| Artifact | **userapi** |
| Name | **UserApi** |
| Description | **My first user manager REST API** |
| Package name | **cat.itacademy.s04.t01.userapi** |
| PACKAGING | **Jar** |
| JAVA | **Version 21** |
| Dependencies | **Spring Web, Spring Boot DevTools** |

---

## 📋 Requirements
* Operating System: Windows/macOS/Linux.
* **Java Development Kit (JDK): Version 21** or higher is recommended.
* **Maven:** Installed and configured for dependency management.
* Integrated Development Environment (IDE): (e.g., IntelliJ IDEA, VS Code, Eclipse) with Maven and Spring Boot support.

---

## 🛠️ Installation
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Rafadicandia/Tasca-S4.01-Introducci--a-Spring-Boot.git
    ```
2.  **Configure Application Port:**
    Set the server port in the configuration file:
    ```
    src/main/resources/application.properties
    ```
    Add the following line to the file:
    ```properties
    server.port=9000
    ```
3.  **IDE Configuration:**
    Open the folder as a Maven project in your IDE. The IDE should automatically synchronize the project and download dependencies.

4.  **Build the Project:**
    To ensure all dependencies are resolved and the project compiles correctly, run the following command in the terminal from the project root:
    ```bash
    ./mvnw clean install
    ```

---

## ▶️ Execution
Once the project is built, you can start the Spring Boot application.

1.  **Execute from IDE:** Run the main application class (typically the one containing the `@SpringBootApplication` annotation).
2.  **Execute from Terminal:** From the project root, run:
    ```bash
    java -jar target/userapi-*.jar
    ```
    The API will run on the configured port, **9000**. You can test the endpoints using tools like Postman or cURL.

---

## 🤝 Contributions
Contributions are welcome. Please report any bugs by opening an issue or suggest improvements via a clear and concise Pull Request.
