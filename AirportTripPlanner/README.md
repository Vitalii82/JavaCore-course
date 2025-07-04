# AirportTripPlanner

## Overview
This is a simple Java project designed to simulate planning a trip for a passenger from one airport to another, optimizing for the lowest time and cost.

## Features
- OOP principles: inheritance, polymorphism, encapsulation, abstraction
- Exception handling with 5 custom exceptions
- Interface usage for loose coupling
- Baggage logic & overcharge calculator
- Logging via Log4j2 instead of System.out
- Route planning algorithm
- Modular structure using Maven

## Project Structure
- `model/` - business objects like Airport, Flight, Passenger
- `logic/` - services such as trip planning, notifications
- `exceptions/` - custom exception classes
- `interfaces/` - behaviors for Payable, Notifiable, etc.
- `resources/` - contains logging configuration

## Build & Run

### Prerequisites
- JDK 17+
- Maven 3+

### Run with Maven
```bash
mvn clean compile exec:java -Dexec.mainClass="Main"
