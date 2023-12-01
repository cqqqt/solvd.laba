package com.solvd.enums;

public enum Courses {

    WORLD_ECONOMY("������� ���������"),
    HISTORY_OF_ART("������� ���������"),
    FUNDAMENTALS_OF_THE_THEORY_OF_PHYSICAL_CULTURE("������ ������ ���������� ��������"),
    ENERGY_METABOLISM_IN_THE_BODY("�������������� ����� � ���������"),
    CLIMATOLOGY("������������");

    private final String name;

    Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
