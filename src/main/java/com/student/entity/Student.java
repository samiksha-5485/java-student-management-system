package com.student.entity;

public class Student {

    private int studentId;
    private String studentName;
    private String email;
    private String dob;

    // Constructor
    public Student(int studentId, String studentName, String email, String dob) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.dob = dob;
    }

    // Getters & Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}