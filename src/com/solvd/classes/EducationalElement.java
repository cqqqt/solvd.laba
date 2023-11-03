package com.solvd.classes;

public abstract class EducationalElement {
    private String name;

    public EducationalElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}