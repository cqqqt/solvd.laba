package com.solvd.classes.menu;

import com.solvd.classes.University;
import com.solvd.classes.education.Exam;
import com.solvd.classes.elements.Faculty;
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
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class StudentMenu {

    private static final Logger LOGGER = LogManager.getLogger(StudentMenu.class);

    private final University university;

    public StudentMenu(University university) {
        this.university = university;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in, "windows-1251");
        int studentMenuChoice;

        do {
            LOGGER.info("\n���� ��������� (������� ����� 0-3):");
            LOGGER.info("1 - ����������� ������ ���������.");
            LOGGER.info("2 - �������� ��������.");
            LOGGER.info("3 - ������� ��������.");
            LOGGER.info("4 - ����������� ��������� ������ ������������� ��������.");
            LOGGER.info("0 - ��������� � ���������� ����.\n");

            studentMenuChoice = scanner.nextInt();

            switch (studentMenuChoice) {
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    LOGGER.info("������� ������� ��� ���������� ���������:");
                    int filterAge = scanner.nextInt();
                    filterStudentsByAge(filterAge);
                    break;
                case 5:
                    takeExam();
                    break;
                case 0:
                    LOGGER.info("����������� � ���������� ����.");
                    break;
                default:
                    LOGGER.info("�������� �����. ����������, ���������� �����.");
            }
        } while (studentMenuChoice != 0);
    }

    private void displayStudentList() {
        String studentList = "\n������ ���������:\n" + Menu.formatList(university.getStudentList());
        LOGGER.info(studentList);
    }

    private void filterStudentsByAge(int filterAge) {
        BiPredicate<Student, Integer> filterByAge = (student, age) -> student.getAge() > age;

        List<Student> studentsAboveAge = university.getStudentList().stream()
                .filter(student -> filterByAge.test(student, filterAge))
                .collect(Collectors.toList());

        String result = "\n�������� ������ " + filterAge + " ���:\n" + Menu.formatList(studentsAboveAge);
        LOGGER.info(result);
    }

    private void addStudent() {
        Scanner scanner = new Scanner(System.in, "windows-1251");

        LOGGER.info("������� ��� ��������:");
        String firstName = scanner.nextLine();

        LOGGER.info("������� ������� ��������:");
        String lastName = scanner.nextLine();

        LOGGER.info("������� ����� �������� ��������:");
        String phoneNumber = scanner.nextLine();

        LOGGER.info("������� ������� ��������:");
        int age = scanner.nextInt();

        Faculty faculty = university.getFacultyList().get(0);
        String specialization = "IT";

        Student newStudent = new Student(firstName, lastName, phoneNumber, age, faculty, specialization);

        university.getStudentList().add(newStudent);

        LOGGER.info("������� ������� ��������.");
    }

    private void deleteStudent() {
        Scanner scanner = new Scanner(System.in, "windows-1251");

        LOGGER.info("������� ��� �������� ��� ��������:");
        String firstName = scanner.nextLine();

        LOGGER.info("������� ������� �������� ��� ��������:");
        String lastName = scanner.nextLine();

        List<Student> studentList = university.getStudentList();
        Student studentToDelete = null;

        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) {
            studentList.remove(studentToDelete);
            LOGGER.info("������� ������� ������.");
        } else {
            LOGGER.info("������� �� ������.");
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

