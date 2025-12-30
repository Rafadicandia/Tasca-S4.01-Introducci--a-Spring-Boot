

# 🚀 Task S4.01: Spring Boot REST API Foundation

This project is an introductory guide to **Spring Boot 3**, focusing on building a functional **User Management REST API**. The curriculum moves through three progressive levels, evolving from a simple health check to a professional, layered architecture.

## 🛠️ Project Specifications

| Feature | Details |
| --- | --- |
| **Java Version** | JDK 21 |
| **Spring Boot** | Version 3.x (Web, DevTools) |
| **Port Configuration** | 9000 |
| **Testing Tools** | JUnit 5, MockMvc, Mockito, Postman |
| **Architecture** | Layered (Controller → Service → Repository) |

---

## 📈 Learning Path

### 🔹 Level 1: The Foundation

* **Health Check:** Implementation of a `GET /health` endpoint.
* **JSON Mapping:** Using Jackson to return structured status objects.
* **Packaging:** Building and executing a standalone `.jar` file using Maven.

### 🔹 Level 2: In-Memory Management

* **CRUD Logic:** Implementation of Create, Read, and Filter operations.
* **Dynamic Routing:** Utilizing `@PathVariable` for IDs and `@RequestParam` for filtering by name.
* **Identification:** Integration of `UUID` for unique user tracking without a database.

### 🔹 Level 3: Professional Layered Architecture

* **SOLID Principles:** Decoupling logic into a three-tier system to improve maintainability.
* **Service Layer:** Handling business rules and email validation.
* **Repository Pattern:** Abstracting data access to support future database migrations.
* **Testing Strategy:** Transitioning from Web Layer tests to **Integration Tests** and **TDD** with Mockito.

---

## ⚙️ Installation & Setup

### 1. Clone the Repository

Open your terminal and run:

```bash
git clone https://github.com/Rafadicandia/Tasca-S4.01-Introducci--a-Spring-Boot.git
cd Tasca-S4.01-Introducci--a-Spring-Boot

```

### 2. Configure Environment

Set the server port in `src/main/resources/application.properties`:

```properties
server.port=9000

```

### 3. Build the Project

Resolve dependencies and compile the source code:

```bash
./mvnw clean install

```

---

## ▶️ Execution

### Run via Terminal

Once built, you can launch the application directly:

```bash
java -jar target/userapi-0.0.1-SNAPSHOT.jar

```

### Testing the API

You can verify the API is running by visiting:

> **Health Check:** `http://localhost:9000/health`
> **List Users:** `http://localhost:9000/users`

---

## 🧠 Core Architecture Highlights

* **Inversion of Control (IoC):** Leveraging Spring's Bean container for dependency management.
* **Separation of Concerns:**
* **Controller:** Handles HTTP status codes and mapping.
* **Service:** Manages business logic (e.g., "Email already exists" exceptions).
* **Repository:** Manages the `List<User>` data structure.



---

## 🤝 Contributions

Contributions are welcome! Please open an issue for bug reports or submit a Pull Request with your improvements.
