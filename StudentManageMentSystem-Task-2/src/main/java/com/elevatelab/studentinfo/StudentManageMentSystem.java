package com.elevatelab.studentinfo;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManageMentSystem {
	
    static ArrayList<Student2>students=new ArrayList<>();
    static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 5);
    }
    //add Student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id=scn.nextInt();
        scn.nextLine();
        System.out.print("Enter Name: ");
        String name=scn.nextLine();
        System.out.print("Enter Marks: ");
        double marks=scn.nextDouble();
        System.out.println("Enter the phone: ");
        long phone=scn.nextLong();
        System.out.println("Enter the email: ");
        String email=scn.next();
        
        Student2 student2=new Student2(id,name,marks,phone,email);
        students.add(student2);
        System.out.println("Student added successfully");
    }

    //View students
    private static void viewStudents() {
        if (students.isEmpty())
            System.out.println("No students to display");

        System.out.println("Student List:");
        for (Student2 s:students)
            System.out.println(s);
    }

    //Update student
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id=scn.nextInt();
        boolean found=false;

        for (Student2 s :students) {
            if (s.getId()==id) {
                scn.nextLine();
                System.out.print("Enter new name: ");
                String name=scn.nextLine();
                System.out.print("Enter new marks: ");
                double marks=scn.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                found = true;
                System.out.println("Student updated successfully");
                break;
            }
        }

        if (!found)
            System.err.println("Student not found!");
    }
    
    //delete student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scn.nextInt();
        boolean removed=students.removeIf(s->s.getId()==id);
        if (removed)
            System.out.println("Student deleted successfully");
        else
            System.err.println("Student not found!");
    }
}

