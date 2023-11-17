package com.solvd.exceptions;

public class FileException extends Exception {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getDetailedMessage() {
        return "������ ��� ������ � ������: " + getMessage();
    }

    public void logError() {
        System.err.println(getDetailedMessage());
    }
}
