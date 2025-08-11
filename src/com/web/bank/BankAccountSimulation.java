package com.web.bank;

import java.util.ArrayList;
import java.util.Scanner;


class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for " + accountHolder);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + recipient.accountHolder);
            recipient.transactionHistory.add("Received ₹" + amount + " from " + accountHolder);
            System.out.println("₹" + amount + " transferred to " + recipient.accountHolder);
        } else {
            System.out.println("Transfer failed due to insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Available Balance: Rs." + balance);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History of " + accountHolder + ":");
        for (String t : transactionHistory) {
            System.out.println("- " + t);
        }
    }
}


public class BankAccountSimulation {

	
	
	    
	    	  private static ArrayList<Account> accounts = new ArrayList<>();
	    	    private static Scanner scanner = new Scanner(System.in);
	    	    
	    	    

	    	    public static void main(String[] args) {
	    	        System.out.println(" Welcome to Elevate Bank!");
	    	        System.out.print("Enter your name to create account: ");
	    	        String name = scanner.nextLine();

	    	        Account currentUser = new Account(name);
	    	        accounts.add(currentUser);
	    	        System.out.println(" Account successfully created for " + name + "\n");

	    	        int choice;
	    	        do {
	    	            System.out.println("\n========= Elevate Bank Menu =========");
	    	            System.out.println("1. Deposit Money");
	    	            System.out.println("2. Withdraw Money");
	    	            System.out.println("3. Check Balance");
	    	            System.out.println("4. View Transaction History");
	    	            System.out.println("5. Transfer Money");
	    	            System.out.println("6. Exit");
	    	            System.out.print("Enter your choice: ");
	    	            choice = scanner.nextInt();
	    	            scanner.nextLine(); // consume newline

	    	            switch (choice) {
	    	                case 1:
	    	                    System.out.print("Enter amount to deposit: Rs.");
	    	                    double dep = scanner.nextDouble();
	    	                    currentUser.deposit(dep);
	    	                    break;
	    	                case 2:
	    	                    System.out.print("Enter amount to withdraw: Rs.");
	    	                    double wd = scanner.nextDouble();
	    	                    currentUser.withdraw(wd);
	    	                    break;
	    	                case 3:
	    	                    currentUser.showBalance();
	    	                    break;
	    	                case 4:
	    	                    currentUser.showTransactionHistory();
	    	                    break;
	    	                case 5:
	    	                    transferMoney(currentUser);
	    	                    break;
	    	                case 6:
	    	                    System.out.println(" Thank you for banking with Elevate Bank!");
	    	                    break;
	    	                default:
	    	                    System.out.println(" Invalid option. Please try again.");
	    	            }
	    	        } while (choice != 6);
	    	    }

	    	    private static void transferMoney(Account sender) {
	    	        scanner.nextLine(); // consume newline
	    	        System.out.print("Enter recipient's name: ");
	    	        String recipientName = scanner.nextLine();

	    	        Account recipient = null;
	    	        for (Account acc : accounts) {
	    	            if (acc.getAccountHolder().equalsIgnoreCase(recipientName) && acc != sender) {
	    	                recipient = acc;
	    	                break;
	    	            }
	    	        }

	    	        if (recipient == null) {
	    	            System.out.print("Recipient not found. Do you want to create an account for " + recipientName + "? (yes/no): ");
	    	            String response = scanner.nextLine();
	    	            if (response.equalsIgnoreCase("yes")) {
	    	                recipient = new Account(recipientName);
	    	                accounts.add(recipient);
	    	                System.out.println("Recipient account created.");
	    	            } else {
	    	                System.out.println("Transfer cancelled.");
	    	                return;
	    	            }
	    	        }

	    	        System.out.print("Enter amount to transfer: Rs.");
	    	        double amount = scanner.nextDouble();
	    	        sender.transfer(recipient, amount);
	    	    }
	    	}