package com.solvd.classes;

import java.util.ArrayList;
import java.util.List;

public class PartTimeStudent extends Student {
    private List<Course> courses;
    private List<Schedule> schedule;

    public PartTimeStudent(String firstName, String lastName, String phoneNumber, int age, Faculty faculty, String specialization) {
        super(firstName, lastName, phoneNumber, age, faculty, specialization);
        this.courses = new ArrayList<>();
        this.schedule = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}
