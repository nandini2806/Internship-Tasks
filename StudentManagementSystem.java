package com.internship;
import java.io.*;
import java.util.*;

	public class StudentManagementSystem {
	    private Map<Integer, Student> students = new HashMap<>();
	    private final String FILE_NAME = "students.txt";

	    public StudentManagementSystem() {
	        loadStudentsFromFile();
	    }

	    public void addStudent(Student student) {
	        if (students.containsKey(student.getRollNumber())) {
	            System.out.println("Student with this roll number already exists!");
	        } else {
	            students.put(student.getRollNumber(), student);
	            saveStudentsToFile();
	            System.out.println("Student added successfully.");
	        }
	    }

	    public void removeStudent(int rollNumber) {
	        if (students.remove(rollNumber) != null) {
	            saveStudentsToFile();
	            System.out.println("Student removed.");
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    public void editStudent(int rollNumber, String newName, String newGrade) {
	        Student student = students.get(rollNumber);
	        if (student != null) {
	            student.setName(newName);
	            student.setGrade(newGrade);
	            saveStudentsToFile();
	            System.out.println("Student updated.");
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    public void searchStudent(int rollNumber) {
	        Student student = students.get(rollNumber);
	        if (student != null) {
	            System.out.println(student);
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    public void displayAllStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students available.");
	        } else {
	            for (Student student : students.values()) {
	                System.out.println(student);
	            }
	        }
	    }

	    private void saveStudentsToFile() {
	        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
	            for (Student student : students.values()) {
	                pw.println(student.getRollNumber() + "," + student.getName() + "," + student.getGrade());
	            }
	        } catch (IOException e) {
	            System.out.println("Error saving student data: " + e.getMessage());
	        }
	    }

	    private void loadStudentsFromFile() {
	        File file = new File(FILE_NAME);
	        if (!file.exists()) return;

	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                int roll = Integer.parseInt(parts[0]);
	                String name = parts[1];
	                String grade = parts[2];
	                students.put(roll, new Student(name, roll, grade));
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("Error loading student data: " + e.getMessage());
	        }
	    }
	}



