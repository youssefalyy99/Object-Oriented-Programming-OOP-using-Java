# Project 01 — Movie Ticket Booking System

## Overview

A Java console-based Movie Ticket Booking System developed as part of my Object-Oriented Programming (OOP) coursework.

The project models movie tickets and manages their booking status, seat assignments, discounts, and booking fees. It applies fundamental OOP concepts to represent a real-world ticket booking scenario.

## Features

- **Ticket Creation:** Creates movie tickets with a ticket ID, movie name, customer name, seat number, and ticket price.
- **Input Validation:** Rejects ticket creation when the ticket price is zero or negative.
- **Booking Management:** Books tickets, cancels bookings, and places tickets on hold.
- **Booking Fee Calculation:** Adds a 10% booking fee when a ticket is successfully booked.
- **Discount Management:** Supports discounts between 0% and 50%.
- **Seat Management:** Allows customers to change their seats unless the ticket is booked or cancelled.
- **Ticket Information Display:** Prints ticket details, booking status, discount percentage, booking fee, and billing information.

## OOP Concepts Covered

- **Classes and Objects:** Represents individual movie tickets using the `MovieTicket` class.
- **Encapsulation:** Uses private fields to protect ticket data and manage changes through methods.
- **Constructors:** Initializes ticket objects and establishes their default booking and billing states.
- **Methods:** Separates operations such as booking, cancellation, holding tickets, applying discounts, and changing seats.
- **Conditional Statements:** Implements validation and booking rules using `if-else` statements.
- **Exception Handling:** Uses `IllegalArgumentException` to reject invalid ticket prices during object creation.

## Class Overview

### `MovieTicket`

The main class responsible for storing ticket information and managing ticket-related operations.

| Method | Responsibility |
|---|---|
| `MovieTicket(...)` | Initializes a ticket and validates its price. |
| `GetTicketInfo()` | Displays ticket details and billing information. |
| `BookTicket()` | Books the ticket and applies a 10% booking fee. |
| `CancelBooking()` | Cancels the booking and resets the booking fee. |
| `HoldTicket()` | Places the ticket on hold and resets the booking fee. |
| `ApplyDiscount(double DiscPct)` | Applies a valid discount percentage up to 50%. |
| `ChangeSeat(String Seat)` | Changes the seat when the booking status permits it. |

## Technologies

- Java
- Object-Oriented Programming
- Java standard library

## Learning Objectives

- Practice designing classes that represent real-world entities.
- Apply encapsulation to ticket attributes.
- Implement business rules and validation.
- Manage object state through methods.
- Perform basic billing calculations using conditional logic and arithmetic operations.

## Future Improvements

- Add a main menu for interacting with the booking system.
- Improve booking-status validation and ticket state transitions.
- Correct the billing calculation to apply discounts accurately.
- Add input validation for ticket IDs, customer details, and seat numbers.
- Improve monetary calculations and output formatting.

---

*This project is part of my ongoing Java OOP coursework portfolio.*