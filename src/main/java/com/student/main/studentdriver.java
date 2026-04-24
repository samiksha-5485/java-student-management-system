package com.student.main;

import java.util.Scanner;

import com.qsp.student_services.AdminService;
import com.qsp.student_services.StudentService;

public class studentdriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StudentService studentService = new StudentService();
		AdminService adminService = new AdminService();

		int choice;

		do {

			System.out.println("\nStudent Management System......\n");

			System.out.println("1. Student Menu");
			System.out.println("2. Admin Menu");
			System.out.println("3. System Features");
			System.out.println("4. Exit");
			System.out.println();

			System.out.println("Enter Your Choices : ");

			choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println();
				System.out.println("1. Student Menu");
				studentService.studentService();
			}
			break;

			case 2: {
				System.out.println();
				System.out.println("2. Admin Menu");
				adminService.adminService();
			}
			break;

			case 3: {
			    System.out.println();
			    System.out.println("------ System Features ------");
			    System.out.println("1. Student Registration");
			    System.out.println("2. Update Student Profile");
			    System.out.println("3. Course Enrollment");
			    System.out.println("4. View Courses");
			    System.out.println("5. View Grades");
			}
			break;

			case 4: {
				System.out.println();
				System.out.println("Exited");
			}
			break;

			default: {
				System.out.println();
				System.out.println("Invalid choice..");
			}
			}

		} while (choice != 4);
	}
}