package com.solvd.classes.elements;

import com.solvd.classes.persons.Employee;
import com.solvd.interfaces.IEducationalElement;

public class Faculty implements IEducationalElement {

    protected String facultyName;
    private Employee dean;

    public Faculty(String facultyName, Employee dean) {
        this.facultyName = facultyName;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Факультет " + facultyName + " {" +
                "декан: " + dean +
                "} " + super.toString();
    }

    @Override
    public String getName() {
        return facultyName;
    }

    public void setName(String name) {
        this.facultyName = name;
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
