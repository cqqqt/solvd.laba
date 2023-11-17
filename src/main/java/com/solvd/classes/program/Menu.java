package com.solvd.classes.program;

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

    public void startMenu() throws FileException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int choice;

        try (BufferedWriter fileWriter = createLogFile()) {
            do {
                LOGGER.info("\n���� ������������ (������� ����� 0-5):");
                LOGGER.info("1 - ������ ���������.");
                LOGGER.info("2 - ������ ��������������.");
                LOGGER.info("3 - ������ �����������.");
                LOGGER.info("4 - ����� �������.");
                LOGGER.info("5 - �����.\n");

                choice = scanner.nextInt();
                fileWriter.write("����� ������������: " + choice + "\n");

                switch (choice) {
                    case 1:
                        String studentList = "\n������ ���������:\n" + formatList(university.getStudentList());
                        LOGGER.info(studentList);
                        fileWriter.write(studentList);
                        break;
                    case 2:
                        String employeeList = "\n������ ��������������:\n" + formatList(university.getEmployeeList());
                        LOGGER.info(employeeList);
                        fileWriter.write(employeeList);
                        break;
                    case 3:
                        String facultyList = "\n������ �����������:\n" + formatList(university.getFacultyList());
                        LOGGER.info(facultyList);
                        fileWriter.write(facultyList);
                        break;
                    case 4:
                        takeExam();
                        fileWriter.write("�������");
                        break;
                    case 5:
                        LOGGER.info("�� ��������!");
                        fileWriter.write("��������� ���������.");
                        break;
                    default:
                        String str = "�������� �����. ����������, ���������� �����.";
                        LOGGER.info(str);
                        fileWriter.write(str);
                }
                fileWriter.newLine();
            } while (choice != 5);
        }
        catch (FileException | IOException e) {
            FileException fileException = new FileException("������ ������ � ����: " + e.getMessage(), e);
            fileException.logError();
            throw fileException;
        }
    }

    private void takeExam() {
        List<Student> students = university.getStudentList();
        Exam exam = new Exam(students);
        exam.takeExamAndSaveResults();
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
