package com.solvd.enums;

public enum Faculties {

    INFORMATION_TECHNOLOGY_AND_COMPUTER_SCIENCE("�������������� ���������� � ������������ ����"),
    HUMANITIES("������������ ����"),
    NATURAL_SCIENCES("������������ ����"),
    SOCIAL_SCIENCES("������������ ����"),
    ARTS_AND_DESIGN("�������� � �������");

    private final String name;

    Faculties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
