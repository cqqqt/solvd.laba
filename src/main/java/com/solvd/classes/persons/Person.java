package com.solvd.classes.persons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Person {

    private static final Logger LOGGER = LogManager.getLogger(Person.class);

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;

    public Person(String firstName, String lastName, String phoneNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Человек {" +
                " \n\tимя: " + firstName +
                ", \n\tфамилия: " + lastName +
                ", \n\tтелефон: " + phoneNumber +
                ", \n\tвозраст: " + age +
                " \n} ";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
