package com.solvd.classes.elements;

import com.solvd.interfaces.IEducationalElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Classroom implements IEducationalElement {

    private static final Logger LOGGER = LogManager.getLogger(Classroom.class);

    private String number;
    private int capacity;
    private String equipment;

    public Classroom(String number, int capacity, String equipment) {
        this.number = number;
        this.capacity = capacity;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Кабинет " + number + " {" +
                "\n\tвместимость: " + capacity +
                ", \n\tоборудование: " + equipment +
                " \n} ";
    }

    @Override
    public String getName() {
        return number;
    }

    public void setName(String name) {
        this.number = name;
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
