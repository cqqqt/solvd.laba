package com.solvd.exceptions;

public class StudentException extends Exception{

    public StudentException(String message) {
        super(message);
    }

    public String getDetailedMessage() {
        return "������ ��� ������ � ���������: " + getMessage();
    }
}
