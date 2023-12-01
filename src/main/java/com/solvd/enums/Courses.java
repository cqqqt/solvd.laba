package com.solvd.enums;

public enum Courses {

    WORLD_ECONOMY("Мировая экономика"),
    HISTORY_OF_ART("История искусства"),
    FUNDAMENTALS_OF_THE_THEORY_OF_PHYSICAL_CULTURE("Основы теории физической культуры"),
    ENERGY_METABOLISM_IN_THE_BODY("Энергетический обмен в организме"),
    CLIMATOLOGY("Климатология");

    private final String name;

    Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
