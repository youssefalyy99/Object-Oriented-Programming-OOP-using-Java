# Project 02 — Digital Wallet System

## Overview

A Java-based Digital Wallet System developed as part of my Object-Oriented Programming (OOP) coursework.

The project simulates a digital wallet that manages user information, account balances, deposits, withdrawals, and transfers between wallets. It also implements transaction fees and tracks the number of successful transactions.

## Features

- **Wallet Creation:** Creates a wallet with a unique wallet ID, owner name, and initial balance.
- **Balance Validation:** Rejects wallet creation when the initial balance is zero or negative.
- **Wallet Information:** Displays wallet details, current balance, and transaction count.
- **Profile Management:** Allows the wallet owner's name and wallet ID to be changed.
- **Deposits:** Adds funds to a wallet after deducting the applicable transaction fee.
- **Withdrawals:** Withdraws funds while checking that the wallet can cover both the requested amount and the transaction fee.
- **Wallet Transfers:** Transfers funds between wallets while deducting a transaction fee from the sender.
- **Tiered Transaction Fees:** Calculates fees based on the transaction amount:
  - Below 500: 5.00
  - From 500 to 999.99: 10.00
  - 1,000 and above: 15.00
- **Transaction Tracking:** Counts successful deposits, withdrawals, and transfers for each wallet.

## OOP Concepts Covered

- **Classes and Objects:** Models individual digital wallets using the `DigitalWallet` class.
- **Encapsulation:** Uses private fields to restrict direct access to wallet information and balance.
- **Constructors:** Initializes wallet objects and validates their initial balances.
- **Methods:** Separates wallet operations into reusable methods.
- **Access Modifiers:** Uses `public` methods for wallet operations and a `private` method for internal fee calculation.
- **Conditional Logic:** Implements validation, transaction fee rules, and insufficient-balance checks.
- **Return Values:** Uses a boolean return value in `Withdraw()` to indicate whether a withdrawal succeeded.
- **Object Interaction:** Enables one `DigitalWallet` object to transfer funds to another wallet object.
- **Exception Handling:** Uses `IllegalArgumentException` to reject invalid initial balances.

## Class Overview

### `DigitalWallet`

The main class responsible for storing wallet information and managing financial transactions.

| Method | Responsibility |
|---|---|
| `DigitalWallet(...)` | Initializes a wallet and validates its starting balance. |
| `WalletInfo()` | Displays wallet information and transaction count. |
| `ChangeUserName(String name)` | Updates the wallet owner's name. |
| `ChangeID(String id)` | Updates the wallet ID. |
| `calculateTransactionFee(double amount)` | Calculates the applicable transaction fee. |
| `Deposit(double num)` | Deposits funds after deducting the transaction fee. |
| `Withdraw(double num)` | Validates and processes withdrawals, returning success or failure. |
| `transfer(DigitalWallet x, double num)` | Transfers funds to another wallet and updates transaction counts. |

## Technologies

- Java
- Object-Oriented Programming
- Java standard library

## Learning Objectives

- Apply encapsulation to protect wallet data.
- Implement financial operations with validation rules.
- Use methods to organize transaction logic.
- Work with multiple interacting objects.
- Apply conditional logic to transaction fees and balance checks.
- Track changes in object state through transaction counts.

## Future Improvements

- Validate wallet IDs and owner names.
- Prevent duplicate wallet IDs.
- Improve receiver-wallet validation during transfers.
- Ensure deposits and transfers handle transaction fees consistently.
- Use `BigDecimal` instead of `double` for more reliable monetary calculations.
- Return clear success or failure results from all transaction methods.
- Prevent invalid wallet ID changes and other invalid state updates.

---

*This project is part of my ongoing Java OOP coursework portfolio.*
