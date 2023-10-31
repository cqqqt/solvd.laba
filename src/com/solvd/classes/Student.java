package com.solvd.classes;

public class Student extends Person {
    private Faculty faculty;
    private String specialization;
    private double GPA;

    public Student(String firstName, String lastName, String phoneNumber, int age, Faculty faculty, String specialization, double GPA) {
        super(firstName, lastName, phoneNumber, age);
        this.faculty = faculty;
        this.specialization = specialization;
        this.GPA = GPA;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
