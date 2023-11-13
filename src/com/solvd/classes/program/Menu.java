package com.solvd.classes.program;

import com.solvd.classes.University;
import com.solvd.classes.education.Exam;
import com.solvd.classes.persons.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    public void startMenu() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int choice;

        try (BufferedWriter fileWriter = createLogFile()) {
            do {
                System.out.println("\n���� ������������ (������� ����� 0-5):");
                System.out.println("1 - ������ ���������.");
                System.out.println("2 - ������ ��������������.");
                System.out.println("3 - ������ �����������.");
                System.out.println("4 - ����� �������.");
                System.out.println("5 - �����.\n");

                choice = scanner.nextInt();
                fileWriter.write("����� ������������: " + choice + "\n");

                switch (choice) {
                    case 1:
                        String studentList = "\n������ ���������:\n" + formatList(university.getStudentList());
                        System.out.println(studentList);
                        fileWriter.write(studentList);
                        break;
                    case 2:
                        String employeeList = "\n������ ��������������:\n" + formatList(university.getEmployeeList());
                        System.out.println(employeeList);
                        fileWriter.write(employeeList);
                        break;
                    case 3:
                        String facultyList = "\n������ �����������:\n" + formatList(university.getFacultyList());
                        System.out.println(facultyList);
                        fileWriter.write(facultyList);
                        break;
                    case 4:
                        takeExam();
                        break;
                    case 5:
                        System.out.println("�� ��������!");
                        fileWriter.write("��������� ���������.");
                        break;
                    default:
                        System.out.println("������������ �����. ���������� �����.");
                        fileWriter.write("�������� �����. ����������, ���������� �����.");
                }
                fileWriter.newLine();
            } while (choice != 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void takeExam() {
        List<Student> students = university.getStudentList();
        Exam exam = new Exam(students);
        exam.takeExamAndSaveResults();
    }

    private BufferedWriter createLogFile() throws IOException {

        String filePath = "console_logs/console_input.txt";
        Path directoryPath = Paths.get("console_logs");

        Files.createDirectories(directoryPath);

        return new BufferedWriter(new FileWriter(filePath, true));
    }
}
