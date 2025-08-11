"# task-5-Bank-Account-Simulation" 

Bank Account Simulation - Java OOP Project

Project Description
This project simulates basic bank operations using Java Object-Oriented Programming. It allows users to create a bank account and perform real-life banking operations such as deposit, withdraw, balance check, transaction history, and money transfer.

Objective
To understand and implement real-world bank functionalities using class-based Java programming.
The project helps in applying concepts of classes, objects, methods, encapsulation, and ArrayList handling in Java.

Tools Used
Java
 Eclipse
Terminal

Key Features
Only one-time account creation by the user
After account creation, user sees a bank-like menu with options
Deposit money
Withdraw money
Check account balance
View transaction history
Transfer money to other user-created accounts
If a recipient account does not exist during transfer, user is prompted to create it

Working Flow

The application starts by greeting the user and asks for their name to create a new account

Once the account is created, the user enters the main bank menu

The menu contains the following options:
a. Deposit Money - User can deposit any positive amount to their account
b. Withdraw Money - User can withdraw money if sufficient balance is available
c. Check Balance - User can check current account balance
d. View Transaction History - All activities like deposit, withdraw, transfer are stored and shown here
e. Transfer Money - User can send money to another account. If the account does not exist, the user can create it immediately
f. Exit - End the session

All operations are handled through a single Account class using encapsulated fields and methods

The user account and all transfer accounts are stored in an ArrayList to simulate a real bank environment

The transaction history is maintained using an ArrayList for each account

Outcomes
Understanding of object-oriented programming concepts like classes, objects, methods, constructors
Practical implementation of data structures like ArrayList
Simulation of real-life scenarios using core Java
User-friendly CLI-based banking system


