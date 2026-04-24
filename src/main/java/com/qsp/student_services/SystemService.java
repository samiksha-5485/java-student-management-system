package com.qsp.student_services;

import java.util.Scanner;
import com.student.dao.SystemDao;

public class SystemService {

    Scanner sc = new Scanner(System.in);
    SystemDao dao = new SystemDao();

    // ✅ THIS METHOD NAME MUST MATCH DRIVER CALL
    public void systemMenu() {

        while (true) {
            System.out.println("\n----- SYSTEM MENU -----");
            System.out.println("1. Total Students");
            System.out.println("2. Total Courses");
            System.out.println("3. Total Enrollments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.totalStudents();
                    break;

                case 2:
                    dao.totalCourses();
                    break;

                case 3:
                    dao.totalEnrollments();
                    break;

                case 4:
                    System.out.println("Exiting System Menu...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}