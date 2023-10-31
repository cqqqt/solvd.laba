package com.solvd.classes;

import java.util.List;

public class University {
    private String name;
    private String location;
    private List<Person> persons;

    public University(String name, String location, List<Person> persons) {
        this.name = name;
        this.location = location;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
