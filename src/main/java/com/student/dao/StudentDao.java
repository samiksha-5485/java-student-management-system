package com.student.dao;

import java.sql.*;
import java.util.Scanner;

public class StudentDao {

    Scanner sc = new Scanner(System.in);

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/main_Student_Management_System",
                "postgres",
                "root");
    }

    // ================= REGISTER =================
    public void registerStudent() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");

            System.out.print("Enter number of students: ");
            int count = sc.nextInt();

            for (int i = 0; i < count; i++) {

                System.out.print("Enter student id: ");
                ps.setInt(1, sc.nextInt());

                System.out.print("Enter name: ");
                ps.setString(2, sc.next());

                System.out.print("Enter email: ");
                ps.setString(3, sc.next());

                System.out.print("Enter DOB: ");
                ps.setString(4, sc.next());

                ps.addBatch();
                System.out.println("------------------");
            }

            ps.executeBatch();
            System.out.println("Students inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE =================
    public void updateStudent() {
        try (Connection con = getConnection()) {

            System.out.println("1. Update Name");
            System.out.println("2. Update Email");
            System.out.println("3. Update DOB");

            int choice = sc.nextInt();

            if (choice == 1) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET student_name=? WHERE student_id=?");

                System.out.print("Enter student id: ");
                ps.setInt(2, sc.nextInt());

                System.out.print("Enter new name: ");
                ps.setString(1, sc.next());

                ps.executeUpdate();
                System.out.println("Name Updated");

            } else if (choice == 2) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET student_email=? WHERE student_id=?");

                System.out.print("Enter student id: ");
                ps.setInt(2, sc.nextInt());

                System.out.print("Enter new email: ");
                ps.setString(1, sc.next());

                ps.executeUpdate();
                System.out.println("Email Updated");

            } else if (choice == 3) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET date_of_birth=? WHERE student_id=?");

                System.out.print("Enter student id: ");
                ps.setInt(2, sc.nextInt());

                System.out.print("Enter new DOB: ");
                ps.setString(1, sc.next());

                ps.executeUpdate();
                System.out.println("DOB Updated");

            } else {
                System.out.println("Invalid choice");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= ENROLL =================
    public void enrollCourse(int course_id) {
        try (Connection con = getConnection()) {

            // check course exists using c_id
            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT * FROM courses WHERE c_id=?");

            ps1.setInt(1, course_id);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO enrollment VALUES (?, ?, ?, ?)");

                System.out.print("Enter Enrollment id: ");
                ps.setInt(1, sc.nextInt());

                System.out.print("Enter Student id: ");
                ps.setInt(2, sc.nextInt());

                ps.setInt(3, course_id);

                System.out.print("Enter Grade: ");
                ps.setString(4, sc.next());

                ps.executeUpdate();
                System.out.println("Enrollment Successful");

            } else {
                System.out.println("Course ID not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= VIEW COURSES =================
    public void viewCourses() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();

            System.out.println("\nCourse List:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("c_id") + " | " +
                        rs.getString("c_name") + " | " +
                        rs.getInt("c_credits"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= VIEW GRADE =================
    public void viewGrade() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT c.c_name, e.grade " +
                    "FROM enrollment e JOIN courses c " +
                    "ON e.c_id = c.c_id " +
                    "WHERE e.s_id=?");

            System.out.print("Enter student id: ");
            ps.setInt(1, sc.nextInt());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " : " + rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}