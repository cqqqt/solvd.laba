package com.solvd.classes;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends EducationalElement {
    private String facultyName;
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
