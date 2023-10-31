package com.solvd.classes;

public class Classroom extends EducationalElement {
    private int capacity;
    private String equipment;

    public Classroom(String name, int capacity, String equipment) {
        super(name);
        this.capacity = capacity;
        this.equipment = equipment;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
