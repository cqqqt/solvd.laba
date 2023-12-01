package com.solvd.enums;

public enum Faculties {

    INFORMATION_TECHNOLOGY_AND_COMPUTER_SCIENCE("Информационных Технологий и Компьютерных Наук"),
    HUMANITIES("Гуманитарных Наук"),
    NATURAL_SCIENCES("Естественных Наук"),
    SOCIAL_SCIENCES("Общественных Наук"),
    ARTS_AND_DESIGN("Искусств и Дизайна");

    private final String name;

    Faculties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
