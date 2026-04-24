package com.student.dao;

import java.sql.*;
import java.util.Scanner;

public class AdminDao {

    Scanner sc = new Scanner(System.in);

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/main_Student_Management_System",
                "postgres",
                "root");
    }

    // ================= COURSE CRUD =================

    // CREATE
    public void addCourse() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("INSERT INTO courses VALUES (?, ?, ?)");

            System.out.print("Enter Course ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Course Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter Credits: ");
            ps.setInt(3, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Course Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public void viewCourses() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();

            System.out.println("\nCourses:");
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

    // UPDATE
    public void updateCourse() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE courses SET c_name=? WHERE c_id=?");

            System.out.print("Enter Course ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter New Course Name: ");
            ps.setString(1, sc.next());

            ps.executeUpdate();
            System.out.println("Course Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteCourse() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM courses WHERE c_id=?");

            System.out.print("Enter Course ID: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Course Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= STUDENT =================

    public void viewAllStudents() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();

            System.out.println("\nStudents:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " | " +
                        rs.getString("student_name") + " | " +
                        rs.getString("student_email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ================= ENROLLMENT =================

    public void viewEnrollments() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM enrollment");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nEnrollments:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("enrollment_id") + " | " +
                        rs.getInt("student_id") + " | " +
                        rs.getInt("course_id") + " | " +
                        rs.getString("grade"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignGrade() {
        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE enrollment SET grade=? WHERE enrollment_id=?");

            System.out.print("Enter Enrollment ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter Grade: ");
            ps.setString(1, sc.next());

            ps.executeUpdate();
            System.out.println("Grade Assigned Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}