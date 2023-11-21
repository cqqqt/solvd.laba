package com.solvd.classes.education;

import com.solvd.classes.persons.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exam {

    private static final Logger LOGGER = LogManager.getLogger(Exam.class);

    private List<Student> students;

    public Exam(List<Student> students) {
        this.students = students;
    }

    public void takeExamAndSaveResults() {
        Random random = new Random();
        int originalDifficulty = random.nextInt(11);
        int invertedDifficulty = 10 - originalDifficulty;

        Scanner scanner = new Scanner(System.in);

        LOGGER.info("\nВыберите студента (введите номер):");
        for (int i = 0; i < students.size(); i++) {
            LOGGER.info((i + 1) + ". " + students.get(i).getFirstName() + " " + students.get(i).getLastName());
        }
        int studentChoice;
        do {
            studentChoice = scanner.nextInt();
        } while (studentChoice < 1 || studentChoice > students.size());

        Student student = students.get(studentChoice - 1);

        int ticketNumber;
        do {
            LOGGER.info("\nВведите номер билета (от 1 до 25):");
            ticketNumber = scanner.nextInt();
        } while (ticketNumber < 1 || ticketNumber > 25);

        double result = (student.getGPA() + originalDifficulty) / 2;
        String subject = student.getRandomSubject(student.getSubjects());
        LOGGER.info("\nПредмет: " + subject + "\n" +
                "Номер билета: " + ticketNumber + "\n" +
                "Сложность билета: " + invertedDifficulty + "\n" +
                "Результат экзамена: " + (int) result);

        saveResultToFile(student, subject, ticketNumber, invertedDifficulty, result);
    }

    private void saveResultToFile(Student student, String subject, int ticketNumber, int invertedDifficulty, double result) {
        String filePath = "exam_results/results.txt";

        try {
            new File("exam_results").mkdirs();

            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write("\nСтудент: " + student.getFirstName() + " " + student.getLastName() + "\n" +
                        "Предмет: " + subject + "\n" +
                        "Номер билета: " + ticketNumber + "\n" +
                        "Сложность билета: " + invertedDifficulty + "\n" +
                        "Результат экзамена: " + (int) result + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
