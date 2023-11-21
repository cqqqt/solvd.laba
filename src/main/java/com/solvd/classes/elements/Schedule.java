package com.solvd.classes.elements;

import com.solvd.interfaces.IEducationalElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Schedule implements IEducationalElement {

    private static final Logger LOGGER = LogManager.getLogger(Schedule.class);

    private String name;
    private String dayOfWeek;
    private String startTime;
    private Course course;
    private Classroom classroom;

    public Schedule(String name, String dayOfWeek, String startTime, Course course, Classroom classroom) {
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.course = course;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Расписание " + name + "{" +
                " \n\tдень недели: " + dayOfWeek +
                ", \n\tвремя начала: " + startTime +
                ", \n\tкурс: " + course +
                ", \n\tкабинет: " + classroom +
                " \n} ";
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
