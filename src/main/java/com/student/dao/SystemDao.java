package com.student.dao;

import java.sql.*;

public class SystemDao {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/main_Student_Management_System",
                "postgres",
                "root");
    }

    // Total Students
    public void totalStudents() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT COUNT(*) FROM students");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Students: " + rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Total Courses
    public void totalCourses() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT COUNT(*) FROM course");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Courses: " + rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Total Enrollments
    public void totalEnrollments() {
        try (Connection con = getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT COUNT(*) FROM enrollment");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Enrollments: " + rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}