# OrangeHRM Automation Testing

## About the Project

This project is an automated testing framework developed to test the main functionalities of the OrangeHRM web application using Selenium WebDriver, Java, and Cucumber.

**Application Under Test:** [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)

The project follows the Page Object Model (POM) design pattern to keep test logic and page interactions organized and maintainable.

## Technologies Used

- **Java** – Programming language
- **Selenium WebDriver** – Web UI automation
- **Cucumber** – Behavior-Driven Development (BDD)
- **Gherkin** – Writing readable test scenarios
- **JUnit** – Test execution and assertions
- **Maven** – Dependency management and build tool
- **Page Object Model (POM)** – Test framework design pattern
- **PageFactory** – Web element initialization

## Test Scenarios

### Login Tests
- Successful login with valid credentials
- Login attempt with an invalid password
- Login attempt with empty credentials

### Employee Management Tests
- Search for an existing employee
- Search for a non-existing employee
- Add a new employee
- Edit an existing employee's information

## Project Structure

```text
src
└── test
    └── java
        ├── features
        │   ├── employee.feature
        │   └── login.feature
        ├── pages
        │   ├── AddEmployeePage.java
        │   ├── BasePage.java
        │   ├── DashboardPage.java
        │   ├── EmployeePage.java
        │   └── LoginPage.java
        ├── runner
        │   └── TestRunner.java
        ├── stepDefinitions
        │   ├── EmployeeStep.java
        │   └── LoginStep.java
        └── utilities
            └── Hooks.java
```

## How to Run the Tests

1. Clone the repository:

   ```bash
   git clone https://github.com/frkn-dgn/OrangeHRM-Automation.git
   ```

2. Open the project in IntelliJ IDEA.
3. Make sure Java and Maven are configured.
4. Run the Cucumber test suite using `TestRunner.java`.

## Purpose

The purpose of this project is to practice UI test automation, BDD with Cucumber, and maintainable test automation framework design.

