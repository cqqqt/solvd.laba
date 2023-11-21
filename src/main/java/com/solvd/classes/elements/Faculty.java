package com.solvd.classes.elements;

import com.solvd.classes.persons.Employee;
import com.solvd.interfaces.IEducationalElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Faculty implements IEducationalElement {

    private static final Logger LOGGER = LogManager.getLogger(Faculty.class);

    protected String facultyName;
    private Employee dean;

    public Faculty(String facultyName, Employee dean) {
        this.facultyName = facultyName;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return " Факультет " + facultyName + " {" +
                " \n\t\tдекан: " + dean +
                " \n\t} ";
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
