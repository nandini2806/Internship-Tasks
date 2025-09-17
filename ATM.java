package com.internship;
import java.util.Scanner;

	// Class to represent the user's bank account
	class BankAccount {
	    private double balance;

	    public BankAccount(double initialBalance) {
	        this.balance = initialBalance;
	    }

	    public String deposit(double amount) {
	        if (amount <= 0) {
	            return "Deposit amount must be positive.";
	        }
	        balance += amount;
	        return "Deposited $" + amount + ". New balance: $" + balance;
	    }

	    public String withdraw(double amount) {
	        if (amount <= 0) {
	            return "Withdrawal amount must be positive.";
	        }
	        if (amount > balance) {
	            return "Insufficient balance.";
	        }
	        balance -= amount;
	        return "Withdrew $" + amount + ". New balance: $" + balance;
	    }

	    public String checkBalance() {
	        return "Your current balance is: $" + balance;
	    }
	}

	// Class to represent the ATM machine
	public class ATM {
	    private BankAccount account;
	    private Scanner scanner;

	    public ATM(BankAccount account) {
	        this.account = account;
	        this.scanner = new Scanner(System.in);
	    }

	    public void start() {
	        while (true) {
	            System.out.println("\n====== ATM MENU ======");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Select an option (1-4): ");

	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    System.out.println(account.checkBalance());
	                    break;
	                case "2":
	                    System.out.print("Enter amount to deposit: $");
	                    try {
	                        double depositAmount = Double.parseDouble(scanner.nextLine());
	                        System.out.println(account.deposit(depositAmount));
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input. Please enter a valid number.");
	                    }
	                    break;
	                case "3":
	                    System.out.print("Enter amount to withdraw: $");
	                    try {
	                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
	                        System.out.println(account.withdraw(withdrawAmount));
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input. Please enter a valid number.");
	                    }
	                    break;
	                case "4":
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please choose between 1 and 4.");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
	        ATM atm = new ATM(userAccount);
	        atm.start();
	    }
	}


