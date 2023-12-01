package com.solvd.classes.menu;

import com.solvd.classes.University;
import com.solvd.classes.education.Exam;
import com.solvd.classes.persons.Student;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Logger LOGGER = LogManager.getLogger(Menu.class);

    private final University university;
    private final Map<Integer, String> subMenus;

    public Menu() {
        this.university = University.Creator.generateDefaultUniversity();
        this.subMenus = createSubMenus();
    }

    private Map<Integer, String> createSubMenus() {
        Map<Integer, String> subMenus = new HashMap<>();
        subMenus.put(1, "Студенты");
        subMenus.put(2, "Преподаватели");
        subMenus.put(3, "Факультеты");
        subMenus.put(4, "Экзамены");
        return subMenus;
    }

    private void displaySubMenu() {
        LOGGER.info("\nВыберите меню (Введите цифру 1-" + subMenus.size() + "):");
        for (Map.Entry<Integer, String> entry : subMenus.entrySet()) {
            LOGGER.info(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static <T> String formatList(List<T> list) {
        StringBuilder formattedList = new StringBuilder();
        for (T item : list) {
            formattedList.append(item.toString()).append("\n");
        }
        return formattedList.toString();
    }

    public void startMenu() throws FileException {
        Scanner scanner = new Scanner(System.in, "windows-1251");
        int choice;

        try (BufferedWriter fileWriter = createLogFile()) {
            do {
                displaySubMenu();

                choice = scanner.nextInt();
                fileWriter.write("Меню университета: " + choice + "\n");

                if (subMenus.containsKey(choice)) {
                    handleSubMenuChoice(choice);
                } else {
                    LOGGER.info("Неверный выбор. Пожалуйста, попробуйте снова.");
                    fileWriter.write("Неверный выбор. Пожалуйста, попробуйте снова.");
                }
                fileWriter.newLine();
            } while (choice != subMenus.size() + 1);
        } catch (FileException | IOException e) {
            FileException fileException = new FileException("Ошибка записи в файл: " + e.getMessage(), e);
            fileException.logError();
            throw fileException;
        }
    }

    private void handleSubMenuChoice(int choice) {
        String menuName = subMenus.get(choice);

        switch (menuName) {
            case "Студенты":
                handleStudentMenu();
                break;
            case "Преподаватели":
                handleEmployeeMenu();
                break;
            case "Факультеты":
                handleFacultyMenu();
                break;
//todo            case "Экзамены":
//                вывести файл с экзаменами
//                break;
            default:
                LOGGER.info("Неверный выбор меню.");
        }
    }

    private void handleStudentMenu() {
        StudentMenu studentMenu = new StudentMenu(university);
        studentMenu.displayMenu();
    }

    private void handleEmployeeMenu() {
        EmployeeMenu employeeMenu = new EmployeeMenu(university);
        employeeMenu.displayMenu();
    }

    private void handleFacultyMenu() {
        FacultyMenu facultyMenu = new FacultyMenu(university);
        facultyMenu.displayMenu();
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












//    public void startMenu() throws FileException {
//        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        int choice;
//
//        try (BufferedWriter fileWriter = createLogFile()) {
//            do {
//                LOGGER.info("\nМеню университета (Введите цифру 0-5):");
//                LOGGER.info("1 - Список студентов.");
//                LOGGER.info("2 - Список преподавателей.");
//                LOGGER.info("3 - Список факультетов.");
//                LOGGER.info("4 - Сдать экзамен.");
//                LOGGER.info("5 - Выйти.\n");
//
//                choice = scanner.nextInt();
//                fileWriter.write("Выбор пользователя: " + choice + "\n");
//
//                switch (choice) {
//                    case 1:
//                        String studentList = "\nСписок студентов:\n" + formatList(university.getStudentList());
//                        LOGGER.info(studentList);
//                        fileWriter.write(studentList);
//                        break;
//                    case 2:
//                        String employeeList = "\nСписок преподавателей:\n" + formatList(university.getEmployeeList());
//                        LOGGER.info(employeeList);
//                        fileWriter.write(employeeList);
//                        break;
//                    case 3:
//                        String facultyList = "\nСписок факультетов:\n" + formatList(university.getFacultyList());
//                        LOGGER.info(facultyList);
//                        fileWriter.write(facultyList);
//                        break;
//                    case 4:
//                        takeExam();
//                        fileWriter.write("Экзамен");
//                        break;
//                    case 5:
//                        LOGGER.info("До свидания!");
//                        fileWriter.write("Программа завершена.");
//                        break;
//                    default:
//                        String str = "Неверный выбор. Пожалуйста, попробуйте снова.";
//                        LOGGER.info(str);
//                        fileWriter.write(str);
//                }
//                fileWriter.newLine();
//            } while (choice != 5);
//        }
//        catch (FileException | IOException e) {
//            FileException fileException = new FileException("Ошибка записи в файл: " + e.getMessage(), e);
//            fileException.logError();
//            throw fileException;
//        }
//    }