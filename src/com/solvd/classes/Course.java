package com.solvd.classes;

import java.util.List;

public class Course extends EducationalElement {
    private Teacher teacher;
    private List<Student> students;
    private int hours;

    public Course(String name, Teacher teacher, List<Student> students, int hours) {
        super(name);
        this.teacher = teacher;
        this.students = students;
        this.hours = hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
