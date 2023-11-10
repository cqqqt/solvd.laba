package com.solvd.enums;

public enum Subjects {

    ENGLISH_LANGUAGE("���������� ����"),
    HISTORY("�������"),
    MATHEMATICS("����������"),
    PHYSICS("������"),
    CHEMISTRY("�����"),
    BIOLOGY("��������"),
    LITERATURE("����������"),
    GEOGRAPHY("���������"),
    SPORTS_AND_PHYSICAL_ACTIVITY("���������� ��������"),
    ECONOMICS("���������"),
    SOCIAL_SCIENCES("��������������");

    private final String name;

    Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
