package com.internship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter roll number: ");
                        int roll = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        if (grade.isEmpty()) throw new IllegalArgumentException("Grade cannot be empty.");

                        sms.addStudent(new Student(name, roll, grade));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter roll number to remove: ");
                    try {
                        int roll = Integer.parseInt(scanner.nextLine());
                        sms.removeStudent(roll);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number.");
                    }
                    break;

                case "3":
                    System.out.print("Enter roll number to edit: ");
                    try {
                        int roll = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

                        System.out.print("Enter new grade: ");
                        String grade = scanner.nextLine();
                        if (grade.isEmpty()) throw new IllegalArgumentException("Grade cannot be empty.");

                        sms.editStudent(roll, name, grade);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "4":
                    System.out.print("Enter roll number to search: ");
                    try {
                        int roll = Integer.parseInt(scanner.nextLine());
                        sms.searchStudent(roll);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number.");
                    }
                    break;

                case "5":
                    sms.displayAllStudents();
                    break;

                case "6":
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 6.");
            }
        }
    }
}

