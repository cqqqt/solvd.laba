package com.solvd.classes;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private List<Employee> employees;

    public Staff() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}


