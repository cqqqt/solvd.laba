package com.solvd.enums;

public enum Subjects {
    ENGLISH_LANGUAGE("ENGLISH LANGUAGE"),
    HISTORY("HISTORY"),
    MATHEMATICS("MATHEMATICS"),
    PHYSICS("PHYSICS"),
    CHEMISTRY("CHEMISTRY"),
    BIOLOGY("BIOLOGY"),
    LITERATURE("LITERATURE"),
    GEOGRAPHY("GEOGRAPHY"),
    SPORTS_AND_PHYSICAL_ACTIVITY("SPORTS_AND PHYSICAL ACTIVITY"),
    ECONOMICS("ECONOMICS"),
    SOCIAL_SCIENCES("SOCIAL SCIENCES");

    private final String name;

    Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
