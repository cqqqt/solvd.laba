package com.solvd.classes.persons;

import com.solvd.classes.elements.Faculty;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {

    protected Faculty faculty;
    protected List<String> subjects;
    protected int experienceAge;

    public Teacher(String firstName, String lastName, String phoneNumber, int age, int payScale, Faculty faculty) {
        super(firstName, lastName, phoneNumber, age, payScale);
        this.faculty = faculty;
        this.subjects = new ArrayList<>();
        this.experienceAge = 0;
    }

    @Override
    public String toString() {
        return "Учитель {" +
                ", имя: " + getFirstName() +
                ", фамилия:" + getLastName() +
                ", телефон: " + getPhoneNumber() +
                ", возраст: " + getAge() +
                ", уровень зарплаты: " + getPayScale() +
                ", факультет: " + faculty +
                ", предметы: " + subjects +
                "} ";
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public int getExperienceAge() {
        return experienceAge;
    }

    public void setExperienceAge(int experienceAge) {
        this.experienceAge = experienceAge;
    }
}

