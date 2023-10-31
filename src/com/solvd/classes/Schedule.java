package com.solvd.classes;

public class Schedule extends EducationalElement {
    private String dayOfWeek;
    private String startTime;
    private Course course;
    private Classroom classroom;

    public Schedule(String name, String dayOfWeek, String startTime, Course course, Classroom classroom) {
        super(name);
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.course = course;
        this.classroom = classroom;
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
