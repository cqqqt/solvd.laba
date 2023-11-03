package com.solvd.classes;

import com.solvd.enums.Subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Student extends Person {
    private Faculty faculty;
    private String specialization;
    private double GPA;
    private List<Integer> grades;
    private List<Subjects> subjects;

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
        int ticketNumber = random.nextInt(10) + 1;
        List<String> subjectNames = new ArrayList<>();
        for (Subjects subject : subjects) {
            subjectNames.add(subject.getName());
        }
        String subjectName = getRandomSubject(subjectNames);
        double result = (GPA + originalDifficulty) / 2;

        return "Предмет: " + subjectName + "\n" +
                "Номер билета: " + ticketNumber + "\n" +
                "Сложность билета: " + invertedDifficulty + "\n" +
                "Результат экзамена: " + (int) result;
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
                "} " + super.toString();
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
