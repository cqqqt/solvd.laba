package com.solvd.classes;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private Faculty faculty;
    private List<String> subjects;
    private int experienceAge;

    public Teacher(String firstName, String lastName, String phoneNumber, int age, int payScale, Faculty faculty) {
        super(firstName, lastName, phoneNumber, age, payScale);
        this.faculty = faculty;
        this.subjects = new ArrayList<>();
        this.experienceAge = 0;
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

