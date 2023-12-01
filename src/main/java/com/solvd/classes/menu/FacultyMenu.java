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

public class FacultyMenu {

    private static final Logger LOGGER = LogManager.getLogger(FacultyMenu.class);

    private final University university;

    public FacultyMenu(University university) {
        this.university = university;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in, "windows-1251");
        int facultyMenuChoice;

        do {
            LOGGER.info("\nМеню факультетов (Введите цифру 0-3):");
            LOGGER.info("1 - Просмотреть список факультетов.");
            LOGGER.info("2 - Добавить факультет.");
            LOGGER.info("3 - Удалить факультет.");
            LOGGER.info("0 - Вернуться в предыдущее меню.\n");

            facultyMenuChoice = scanner.nextInt();

            switch (facultyMenuChoice) {
                case 1:
                    displayFacultyList();
                    break;
                case 2:
                    addFaculty();
                    break;
                case 3:
                    deleteFaculty();
                    break;
                case 0:
                    LOGGER.info("Возвращение в предыдущее меню.");
                    break;
                default:
                    LOGGER.info("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        } while (facultyMenuChoice != 0);
    }

    private void displayFacultyList() {
        String facultyList = "\nСписок факультетов:\n" + Menu.formatList(university.getFacultyList());
        LOGGER.info(facultyList);
    }

    private void addFaculty() {
        //todo
    }

    private void deleteFaculty() {
        //todo
    }

    private BufferedWriter createLogFile() throws IOException, FileException {
        String fileName = "console_logs/console_log_" + getCurrentDate() + ".txt";
        Path directoryPath = Paths.get("console_logs");

        try {
            Files.createDirectories(directoryPath);
            return new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            FileException fileException = new FileException("Ошибка при создании файла с логами: " + e.getMessage(), e);
            fileException.logError();
            throw fileException;
        }
    }

    private String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }
}

