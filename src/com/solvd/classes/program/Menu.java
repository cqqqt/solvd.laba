package com.solvd.classes.program;

import com.solvd.classes.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Logger LOGGER = LogManager.getLogger(Menu.class);

    private final University university;

    public Menu() {
        this.university = University.Creator.generateDefaultUniversity();
    }

    private static <T> String formatList(List<T> list) {
        StringBuilder formattedList = new StringBuilder();
        for (T item : list) {
            formattedList.append(item.toString()).append("\n");
        }
        return formattedList.toString();
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n���� ������������ (������� ����� 0-4):");
            System.out.println("1 - ������ ���������.");
            System.out.println("2 - ������ ��������������.");
            System.out.println("3 - ������ �����������.");
            System.out.println("4 - �����.\n");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n������ ���������:\n" + formatList(university.getStudentList()));
                    break;
                case 2:
                    System.out.println("\n������ ��������������:\n" + formatList(university.getEmployeeList()));
                    break;
                case 3:
                    System.out.println("\n������ �����������:\n" + formatList(university.getFacultyList()));
                    break;
                case 4:
                    System.out.println("�� ��������!");
                    break;
                default:
                    System.out.println("������������ �����. ���������� �����.");
            }
        } while (choice != 4);
    }
}