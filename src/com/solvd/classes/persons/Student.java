package com.solvd.classes.persons;

import com.solvd.classes.elements.Faculty;
import com.solvd.enums.Subjects;

import java.util.*;

public class Student extends Person {

    private Faculty faculty;
    private String specialization;
    private double GPA;
    private final List<Integer> grades;
    private final List<Subjects> subjects;

    public Student(String firstName, String lastName, String phoneNumber, int age, Faculty faculty, String specialization) {
        super(firstName, lastName, phoneNumber, age);
        this.faculty = faculty;
        this.specialization = specialization;
        this.grades = generateRandomGrades();
        this.GPA = calculateAverageGrade();
        this.subjects = getRandomSubjects();
    }

    private List<Integer> generateRandomGrades() {
        List<Integer> randomGrades = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int grade = random.nextInt(11);
            randomGrades.add(grade);
        }

        return randomGrades;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public List<Subjects> getRandomSubjects() {
        List<Subjects> subjectsList = new ArrayList<>();
        Random random = new Random();
        while (subjectsList.size() < 3) {
            int randomIndex = random.nextInt(Subjects.values().length);
            Subjects randomSubject = Subjects.values()[randomIndex];
            if (!subjectsList.contains(randomSubject)) {
                subjectsList.add(randomSubject);
            }
        }
        return subjectsList;
    }

    public String getRandomSubject(List<String> subjectsList) {
        Random random = new Random();
        int randomIndex = random.nextInt(subjectsList.size());
        return subjectsList.get(randomIndex);
    }

    public String takeExam() {
        Random random = new Random();
        int originalDifficulty = random.nextInt(11);
        int invertedDifficulty = 10 - originalDifficulty;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n�������� ������� (������� �����):");
        List<String> subjectNames = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            Subjects subject = subjects.get(i);
            String subjectName = subject.getName();
            subjectNames.add(subjectName);
            System.out.println((i + 1) + ". " + subjectName);
        }
        int subjectChoice;
        do {
            subjectChoice = scanner.nextInt();
        } while (subjectChoice < 1 || subjectChoice > subjects.size());

        String subjectName = subjectNames.get(subjectChoice - 1);

        int ticketNumber;
        do {
            System.out.println("\n������� ����� ������ (�� 1 �� 25):");
            ticketNumber = scanner.nextInt();
        } while (ticketNumber < 1 || ticketNumber > 25);

        double result = (GPA + originalDifficulty) / 2;

        return "\n�������: " + subjectName + "\n" +
                "����� ������: " + ticketNumber + "\n" +
                "��������� ������: " + invertedDifficulty + "\n" +
                "��������� ��������: " + (int) result;
    }


    private double calculateAverageGrade() {
        double total = 0;
        for (int grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty=" + faculty +
                ", specialization='" + specialization + '\'' +
                ", GPA=" + GPA +
                ", grades=" + grades +
                ", subjects=" + subjects +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Double.compare(student.GPA, GPA) == 0 &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(specialization, student.specialization) &&
                Objects.equals(grades, student.grades) &&
                Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, specialization, GPA, grades, subjects);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
