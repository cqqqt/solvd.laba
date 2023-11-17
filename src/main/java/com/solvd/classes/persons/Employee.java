package com.solvd.classes.persons;

import com.solvd.classes.program.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Person {

    private static final Logger LOGGER = LogManager.getLogger(Employee.class);

    private int payScale;

    public Employee(String firstName, String lastName, String phoneNumber, int age, int payScale) {
        super(firstName, lastName, phoneNumber, age);
        this.payScale = payScale;
    }

    @Override
    public String toString() {
        return "Работник " + getFullName() + "{" +
                " уровень зарплаты : " + payScale +
                " } ";
    }

    public int getPayScale() {
        return payScale;
    }

    public void setPayScale(int payScale) {
        this.payScale = payScale;
    }
}
