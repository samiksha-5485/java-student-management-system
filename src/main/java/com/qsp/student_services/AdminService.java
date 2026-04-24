package com.qsp.student_services;

import java.util.Scanner;

public class AdminService {

    public void adminService() {   // ✅ FIXED NAME
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ ADMIN MENU ------");
            System.out.println("1. Add/Update/Delete Course");
            System.out.println("2. View All Students");
            System.out.println("3. View All Courses");
            System.out.println("4. View All Enrollments");
            System.out.println("5. Assign Grades");
            System.out.println("6. Stored Procedure Operations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Course operation...");
                    break;

                case 2:
                    System.out.println("Viewing all students...");
                    break;

                case 3:
                    System.out.println("Viewing all courses...");
                    break;

                case 4:
                    System.out.println("Viewing all enrollments...");
                    break;

                case 5:
                    System.out.println("Assigning grades...");
                    break;

                case 6:
                    System.out.println("Stored procedure operations...");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}