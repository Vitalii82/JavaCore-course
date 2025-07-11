# ✈️ AirportTripPlanner

AirportTripPlanner is a Java console application that helps users find the optimal route between airports with the lowest cost and shortest duration, considering baggage weight and ticket pricing.

## 📁 Project Structure

AirportTripPlanner/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── solvd/
        │           └── course/
        │               ├── Main.java
        │               ├── exceptions/
        │               ├── interfaces/
        │               ├── logic/
        │               ├── model/
        │               └── util/
        └── resources/
            └── log4j2.xml

## 🚀 Features

- Find best flight route between two airports
- Evaluate baggage cost using a policy system
- Create and print tickets
- Log success or failure with Log4j2
- Handle errors with 5 custom exceptions
- Use of Java features:
  - Interfaces
  - Generics
  - 5 different collection types
  - Custom LinkedList with add, get, and remove methods

## 🛠️ Build and Run (with Maven)

### 1. Compile the project
mvn clean compile

### 2. Run the application
mvn exec:java -Dexec.mainClass="com.solvd.course.Main"

### 3. Run tests (if any)
mvn test

## ✅ Benefits of Maven

- Standardized build system
- Quick and repeatable builds
- Easy plugin integration
- CI/CD compatibility
- Dependency management

## 📩 Author

Vitalii Svinovei — Java Developer & QA Automation Engineer  
Project created as part of Java Core educational practice
