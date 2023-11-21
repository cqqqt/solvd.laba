package com.solvd.classes.elements;

import com.solvd.classes.persons.Student;
import com.solvd.classes.persons.Teacher;
import com.solvd.interfaces.IEducationalElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Course implements IEducationalElement {

    private static final Logger LOGGER = LogManager.getLogger(Course.class);

    private String name;
    private Teacher teacher;
    private List<Student> students;
    private int hours;

    public Course(String name, Teacher teacher, List<Student> students, int hours) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Курс " + name + "{" +
                " \n\tучитель: " + teacher +
                ", \n\tстуденты: " + students +
                ", \n\tотведенные часы: " + hours +
                " \n} ";
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
