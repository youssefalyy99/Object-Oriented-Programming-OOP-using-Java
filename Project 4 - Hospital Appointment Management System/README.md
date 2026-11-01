# Hospital Appointment Management System

A Java-based Hospital Appointment Management System developed to practice Object-Oriented Programming (OOP), inheritance, encapsulation, validation, and object interaction.

The system manages doctors, patients, and medical appointments while enforcing scheduling rules and preventing conflicting bookings.

## Features

### 1. Person Management
- Create people with personal information.
- Store ID, name, age, and phone number.
- Update personal information.
- Validate age and phone number.

### 2. Doctor Management
- Create doctors with professional information.
- Store medical specialty and consultation fee.
- Update professional information.
- Enforce doctor age requirements (25+).
- Validate consultation fees (0–10,000).

### 3. Patient Management
- Create patients with medical information.
- Generate and validate medical record numbers.
- Support all standard blood types.
- Calculate discount rates:
  - 20% for patients aged 12 or younger.
  - 20% for patients aged 65 or older.
  - No discount for other age groups.

### 4. Appointment Management
- Create appointments associated with a doctor and a patient.
- Generate unique appointment IDs.
- Track appointment statuses:
  - `New`
  - `Booked`
  - `Cancelled`
- Book and cancel appointments.
- Display appointment details.

### 5. Scheduling System
- Maintain separate schedules for doctors and patients.
- Limit each doctor and patient to a maximum of 5 appointments.
- Prevent conflicting appointments.
- Ensure appointments are at least 30 minutes apart.
- Automatically update both schedules after successful booking or cancellation.

## Appointment Rules

The system enforces the following scheduling restrictions:

| Rule | Requirement |
|---|---|
| Day | 1–31 |
| Working hours | 09:00–16:30 |
| Minute intervals | 00, 15, 30, 45 |
| Maximum appointments | 5 per doctor/patient |
| Minimum appointment separation | 30 minutes |
| Doctor minimum age | 25 |
| Consultation fee | 0–10,000 |

Appointments are converted into a numerical time key using:

`slotKey = day * 1440 + hour * 60 + minute`

This allows the system to compare appointment times using simple arithmetic and detect scheduling conflicts.

## Project Structure

```text
Lab4HW/
│
├── Appointment.java
│
├── Doctor.java
│
├── Patient.java
│
├── Person.java
│
└── Main.java
```

### Class Responsibilities

| Class | Responsibility |
|---|---|
| `Person` | Base class containing shared personal information and schedules. |
| `Doctor` | Extends Person and manages professional information. |
| `Patient` | Extends Person and manages medical information and discounts. |
| `Appointment` | Handles appointment creation, booking, cancellation, and scheduling validation. |
| `Main` | Runs test scenarios for the entire system. |

## Object-Oriented Programming Concepts

This project demonstrates several fundamental OOP concepts:

- **Encapsulation:** Using private and protected fields to control access to object data.
- **Inheritance:** Doctor and Patient inherit common attributes and behavior from Person.
- **Constructors:** Initializing objects while enforcing validation rules.
- **Method Overriding / Inheritance:** Reusing inherited functionality through the class hierarchy.
- **Static Members:** Maintaining a shared appointment counter for generating appointment IDs.
- **ArrayList:** Dynamically storing and managing appointment schedules.
- **Exception Handling:** Using `IllegalArgumentException` to reject invalid input.

## Testing

The project includes a dedicated `Main.java` file containing test scenarios covering the system's functionality.

The tests include:

1. Creating doctors and updating their information.
2. Creating patients and calculating discounts.
3. Validating medical record numbers and blood types.
4. Testing invalid appointment dates and times.
5. Successfully booking appointments.
6. Detecting doctor scheduling conflicts.
7. Detecting patient scheduling conflicts.
8. Testing maximum doctor appointment capacity.
9. Testing maximum patient appointment capacity.
10. Cancelling appointments and verifying schedule updates.
11. Preventing repeated booking and cancellation operations.

The testing program also checks invalid operations and expected exception handling.

## How to Run

### Requirements
- Java Development Kit (JDK 8 or later).
- Any Java-compatible IDE, such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

### Running the Project

1. Clone or download the repository.
2. Open the project in your preferred Java IDE.
3. Make sure all classes belong to the `Homework.Lab4HW` package.
4. Run `Main.java`.
5. Observe the console output to review the test results.

Alternatively, from the directory containing the `Homework` folder:

```bash
javac Homework/Lab4HW/*.java
java Homework.Lab4HW.Main
```

## Technologies Used

- Java
- Object-Oriented Programming
- Java Collections Framework (`ArrayList`)
- Regular Expressions
- Exception Handling

## Project Objective

The main objective of this project is to apply Java OOP concepts to a practical scenario involving multiple interacting classes.

It focuses on designing a structured class hierarchy, maintaining relationships between objects, enforcing business rules, and managing shared scheduling resources.

---

**Project:** Hospital Appointment Management System  
**Language:** Java  
**Category:** Object-Oriented Programming