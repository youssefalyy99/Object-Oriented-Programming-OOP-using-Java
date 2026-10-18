# Project 03 — Delivery Order Management System

## Overview

A Java-based Delivery Order Management System developed as part of my Object-Oriented Programming (OOP) coursework.

The project simulates a delivery ordering process in which customers can create orders, choose between cash and digital wallet payments, calculate delivery fees, confirm payments, and update delivery status.

The system integrates a custom `DigitalWallet` class to process wallet payments, demonstrating how multiple classes can work together to implement a more complete application.

## Features

- **Order Creation:** Creates delivery orders with an order ID, customer information, delivery address, item count, and subtotal.
- **Input Validation:** Rejects orders with non-positive subtotals or item counts.
- **Multiple Payment Methods:** Supports cash and digital wallet payments through overloaded constructors.
- **Wallet Integration:** Uses the `DigitalWallet` class to process wallet payments through its withdrawal method.
- **Delivery Fee Calculation:** Calculates delivery fees according to the order subtotal:
  - Below 500: 50.00
  - From 500 to 999.99: 30.00
  - 1,000 and above: 10.00
- **Order Information Display:** Displays order details, payment method, subtotal, delivery fee, and total cost.
- **Customer Information Management:** Allows the customer name and delivery address to be updated.
- **Payment Confirmation:** Tracks whether an order has been paid and updates its payment status.
- **Delivery Status Management:** Prevents an unpaid order from being marked as delivered and identifies orders already marked as delivered.

## OOP Concepts Covered

- **Classes and Objects:** Models delivery orders and digital wallets as Java objects.
- **Encapsulation:** Uses private fields to protect order information and internal state.
- **Constructors:** Initializes delivery orders and validates order data.
- **Constructor Overloading:** Provides separate constructors for cash orders and wallet orders.
- **Composition and Object Relationships:** Stores a `DigitalWallet` reference inside `DeliveryOrder` to support wallet-based payments.
- **Method Reuse:** Calls `DigitalWallet.Withdraw()` to process wallet payments instead of implementing a second withdrawal mechanism.
- **Access Modifiers:** Uses private methods for internal delivery fee calculations and public methods for order operations.
- **Conditional Logic:** Implements payment validation, delivery status checks, and delivery fee rules.
- **State Management:** Tracks payment and delivery using boolean fields and a payment status string.
- **Exception Handling:** Uses `IllegalArgumentException` to reject invalid order subtotals and item counts.

## Class Overview

### `DeliveryOrder`

Responsible for managing order information, calculating delivery fees, processing payment confirmation, and tracking delivery status.

| Method | Responsibility |
|---|---|
| `DeliveryOrder(...)` | Creates a cash order. |
| `DeliveryOrder(..., DigitalWallet wallet)` | Creates an order associated with a digital wallet. |
| `ViewOrder()` | Displays order and billing information. |
| `ChangeUserName(String name)` | Updates the customer's name. |
| `ChangeDeliveryAddress(String name)` | Updates the delivery address. |
| `CalculateDeliveryCost(double Subtotal)` | Calculates the delivery fee based on the subtotal. |
| `ConfirmPayment()` | Confirms cash payment or attempts to withdraw the subtotal from the associated wallet. |
| `GetDeliveryStatues()` | Updates or reports the delivery status. |

### `DigitalWallet`

A supporting class developed separately and reused by the delivery order system.

It manages wallet balances and transactions, including withdrawals used during order payment confirmation.

## Technologies

- Java
- Object-Oriented Programming
- Java standard library

## Learning Objectives

- Model a real-world delivery workflow using Java classes.
- Implement constructor overloading for different payment methods.
- Reuse functionality across collaborating classes.
- Apply encapsulation and validation to business operations.
- Manage payment and delivery states.
- Integrate wallet transactions into an order management workflow.

## Future Improvements

- Include delivery fees in the amount charged to the wallet.
- Ensure cash orders cannot be marked as paid repeatedly without an appropriate state check.
- Validate wallet references and order details.
- Prevent delivery before successful payment.
- Separate payment status from delivery status.
- Improve naming consistency and monetary calculations.
- Return explicit success or failure results from payment and delivery operations.

---

*This project is part of my ongoing Java OOP coursework portfolio.*