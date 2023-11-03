package com.solvd.classes;

public class Faculty extends EducationalElement {
    protected String facultyName;
    private Employee dean;

    public Faculty(String facultyName, Employee dean) {
        super(facultyName);
        this.facultyName = facultyName;
        this.dean = dean;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Employee getDean() {
        return dean;
    }

    public void setDean(Employee dean) {
        this.dean = dean;
    }
}
