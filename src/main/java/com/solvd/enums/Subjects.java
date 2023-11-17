package com.solvd.enums;

public enum Subjects {

    ENGLISH_LANGUAGE("¿Õ√À»…— »… ﬂ«€ "),
    HISTORY("»—“Œ–»ﬂ"),
    MATHEMATICS("Ã¿“≈Ã¿“» ¿"),
    PHYSICS("‘»«» ¿"),
    CHEMISTRY("’»Ã»ﬂ"),
    BIOLOGY("¡»ŒÀŒ√»ﬂ"),
    LITERATURE("À»“≈–¿“”–¿"),
    GEOGRAPHY("¡»Œ√–¿‘»ﬂ"),
    SPORTS_AND_PHYSICAL_ACTIVITY("‘»«»◊≈— ¿ﬂ  ”À‹“”–¿"),
    ECONOMICS("› ŒÕŒÃ» ¿"),
    SOCIAL_SCIENCES("Œ¡Ÿ≈—“¬Œ«Õ¿Õ»≈");

    private final String name;

    Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
