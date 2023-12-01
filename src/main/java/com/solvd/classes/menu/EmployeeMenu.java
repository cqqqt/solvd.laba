package com.solvd.classes.menu;

import com.solvd.classes.University;
import com.solvd.exceptions.FileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EmployeeMenu{

    private static final Logger LOGGER = LogManager.getLogger(EmployeeMenu.class);

    private final University university;

    public EmployeeMenu(University university) {
        this.university = university;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in, "windows-1251");
        int employeeMenuChoice;

        do {
            LOGGER.info("\n���� �������������� (������� ����� 0-3):");
            LOGGER.info("1 - ����������� ������ ��������������.");
            LOGGER.info("2 - �������� �������������.");
            LOGGER.info("3 - ������� �������������.");
            LOGGER.info("0 - ��������� � ���������� ����.\n");

            employeeMenuChoice = scanner.nextInt();

            switch (employeeMenuChoice) {
                case 1:
                    displayEmployeeList();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 0:
                    LOGGER.info("����������� � ���������� ����.");
                    break;
                default:
                    LOGGER.info("�������� �����. ����������, ���������� �����.");
            }
        } while (employeeMenuChoice != 0);
    }

    private void displayEmployeeList() {
        String employeeList = "\n������ ��������������:\n" + Menu.formatList(university.getEmployeeList());
        LOGGER.info(employeeList);
    }

    private void addEmployee() {
        //todo
    }

    private void deleteEmployee() {
        //todo
    }

    private BufferedWriter createLogFile() throws IOException, FileException {
        String fileName = "console_logs/console_log_" + getCurrentDate() + ".txt";
        Path directoryPath = Paths.get("console_logs");

        try {
            Files.createDirectories(directoryPath);
            return new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            FileException fileException = new FileException("������ ��� �������� ����� � ������: " + e.getMessage(), e);
            fileException.logError();
            throw fileException;
        }
    }

    private String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }
}
