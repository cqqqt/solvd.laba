package com.solvd;

import com.solvd.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        University university = new University("Solvd University", "Solvd Location");

        Faculty faculty = new Faculty("Faculty of Science", new Employee("John", "Doe", "1234567890", 45, 1000));

        Teacher teacher = new Teacher("Alice", "Smith", "9876543210", 35, 500, faculty);

        Student student = new Student("Aleksei", "Kuryshev", "375296164399", 20, faculty, "Computer Science");

        Classroom classroom = new Classroom("Room101", 50, "Projector");

        Course course = new Course("Introduction to Programming", teacher, new ArrayList<Student>(), 40);

        Schedule schedule = new Schedule("Schedule","Monday", "9:00 AM", course, classroom);

        Professor professor = new Professor("David", "Williams", "1111111111", 50, 1500, faculty, new ArrayList<String>(), new ArrayList<String>());

        course.getStudents().add(student);
        schedule.getCourse().getStudents().add(student);

        System.out.println("University Name: " + university.getName());
        System.out.println("Faculty Name: " + faculty.getFacultyName());
        System.out.println("Dean: " + faculty.getDean().getFirstName() + " " + faculty.getDean().getLastName());
        System.out.println("Teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Classroom Name: " + classroom.getName());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Schedule Day: " + schedule.getDayOfWeek() + ", Time: " + schedule.getStartTime());
        System.out.println("Professor: " + professor.getFirstName() + " " + professor.getLastName() + "\n\n\n");

        int choice;
        do {
            System.out.println("\nМеню студента (Введите цифру 0-3):");
            System.out.println("1 - Список предметов.");
            System.out.println("2 - Список оценок.");
            System.out.println("3 - Пройти экзамен.");
            System.out.println("0 - Выйти.\n");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nСписок предметов: " + student.getSubjects());
                    break;
                case 2:
                    System.out.println("\nСписок оценок: " + student.getGrades());
                    break;
                case 3:
                    System.out.println(student.takeExam());
                    break;
                case 0:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
