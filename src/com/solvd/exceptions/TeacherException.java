package com.solvd.exceptions;

public class TeacherException extends Exception{

    public TeacherException(String message) {
        super(message);
    }

    public String getDetailedMessage() {
        return "������ ��� ������ � ��������: " + getMessage();
    }
}
