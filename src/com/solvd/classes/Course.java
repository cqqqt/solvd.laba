package com.solvd.classes;

import java.util.List;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Course{" +
                "teacher=" + teacher +
                ", students=" + students +
                ", hours=" + hours +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Course course = (Course) o;
        return hours == course.hours &&
                Objects.equals(teacher, course.teacher) &&
                Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teacher, students, hours);
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
