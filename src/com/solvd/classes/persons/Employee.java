package com.solvd.classes.persons;

public class Employee extends Person {

    private int payScale;

    public Employee(String firstName, String lastName, String phoneNumber, int age, int payScale) {
        super(firstName, lastName, phoneNumber, age);
        this.payScale = payScale;
    }

    public int getPayScale() {
        return payScale;
    }

    public void setPayScale(int payScale) {
        this.payScale = payScale;
    }
}
