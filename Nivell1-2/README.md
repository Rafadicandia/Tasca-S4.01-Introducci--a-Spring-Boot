# 🚀 Task S4.01 - Developing a REST API with Spring Boot

This project is the initial contact with **Spring Boot** and the development of a **REST API**. The goal is to build a minimal yet functional API that can receive and return data in **JSON** format, utilizing HTTP methods and applying best practices from the start.

---

## 📄 Exercise Description

This exercise focuses on configuring and developing a simple REST API for user management.

### Level 1: Creating a Minimal REST API

The main objective is to set up and develop a basic REST API for managing users.

* Configure the project at [https://start.spring.io/](https://start.spring.io/) with the specifications detailed in the configuration section below.
* Implement minimal *endpoints* to demonstrate the API's ability to receive and return data in JSON format.
* Use appropriate HTTP methods (e.g., GET, POST).

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
    git clone [ADD_REPOSITORY_URL_HERE]
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