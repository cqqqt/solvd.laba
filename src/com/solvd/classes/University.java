package com.solvd.classes;

import com.solvd.classes.elements.Classroom;
import com.solvd.classes.elements.Course;
import com.solvd.classes.elements.Faculty;
import com.solvd.classes.elements.Schedule;
import com.solvd.classes.persons.Employee;
import com.solvd.classes.persons.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.solvd.classes.persons.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class University {

    private static final Logger LOGGER = LogManager.getLogger(University.class);

    private String name;
    private String location;
    private List<Student> studentList = new ArrayList<>();
    private List<Employee> employeeList = new ArrayList<>();
    private List<Schedule> scheduleList = new ArrayList<>();
    private List<Faculty> facultyList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<Classroom> classroomList = new ArrayList<>();

    public University(String name, String location) {
        this.name = name;
        this.location = location;
        this.studentList = new ArrayList<>();
        this.employeeList = new ArrayList<>();
        this.scheduleList = new ArrayList<>();
        this.facultyList = new ArrayList<>();
        this.courseList = new ArrayList<>();
        this.classroomList = new ArrayList<>();
    }

    public static class Creator {

        private static final List<String> FIRST_NAMES = Arrays.asList("Алексей", "Максим", "Дмитрий", "Глеб", "Александр", "Павел");
        private static final List<String> LAST_NAMES = Arrays.asList("Курышев", "Орлов", "Прохоренко", "Прусаков", "Золотарев", "Уланов");
        private static final List<String> PHONE_NUMBERS = Arrays.asList("375296164399", "375296472834", "375294719060");
        private static final List<String> SPECIALIZATIONS = Arrays.asList("IT", "Математика", "Физика", "Химбио");

        private static Random random = new Random();

        private static <T> T getRandomElement(List<T> list) {
            return list.get(random.nextInt(list.size()));
        }

        private static Classroom generateRandomClassroom() {
            String number = "#" + random.nextInt(100);
            int capacity = random.nextInt(50) + 10;
            String equipment = getRandomElement(Arrays.asList("Проектор", "Доска", "Компьютеры"));
            return new Classroom(number, capacity, equipment);
        }

        private static Course generateRandomCourse(List<Student> students) {
            String name = getRandomElement(Arrays.asList("Мировая экономика", "История искусства", "Основы теории физической культуры", "Энергетический обмен в организме", "Климатология"));
            Teacher teacher = generateRandomTeacher();
            int hours = random.nextInt(4) + 1;
            return new Course(name, teacher, students, hours);
        }

        private static Faculty generateRandomFaculty(List<Employee> employees) {
            String facultyName = getRandomElement(Arrays.asList("Информационных Технологий и Компьютерных Наук", "Гуманитарных Наук", "Естественных Наук", "Общественных Наук", "Искусств и Дизайна"));
            Employee dean = getRandomElement(employees);
            return new Faculty(facultyName, dean);
        }

        private static Schedule generateRandomSchedule(List<Course> courses, List<Classroom> classrooms) {
            String name = "#" + random.nextInt(5);
            String dayOfWeek = getRandomElement(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
            String startTime = random.nextInt(12) + ":00";
            Course course = getRandomElement(courses);
            Classroom classroom = getRandomElement(classrooms);
            return new Schedule(name, dayOfWeek, startTime, course, classroom);
        }

        private static Employee generateRandomEmployee() {
            String firstName = getRandomElement(FIRST_NAMES);
            String lastName = getRandomElement(LAST_NAMES);
            String phoneNumber = getRandomElement(PHONE_NUMBERS);
            int age = random.nextInt(20) + 30;
            int payScale = random.nextInt(3) + 1;
            return new Employee(firstName, lastName, phoneNumber, age, payScale);
        }

        private static Student generateRandomStudent() {
            String firstName = getRandomElement(FIRST_NAMES);
            String lastName = getRandomElement(LAST_NAMES);
            String phoneNumber = getRandomElement(PHONE_NUMBERS);
            int age = random.nextInt(10) + 18;
            Employee e1 = generateRandomEmployee();
            Employee e2 = generateRandomEmployee();
            List<Employee> employeeList = Arrays.asList(e1, e2);
            Faculty faculty = generateRandomFaculty(employeeList);
            String specialization = getRandomElement(SPECIALIZATIONS);
            return new Student(firstName, lastName, phoneNumber, age, faculty, specialization);
        }

        private static Teacher generateRandomTeacher() {
            String firstName = getRandomElement(FIRST_NAMES);
            String lastName = getRandomElement(LAST_NAMES);
            String phoneNumber = getRandomElement(PHONE_NUMBERS);
            int age = random.nextInt(20) + 30;
            int payScale = random.nextInt(3) + 1;
            Employee e1 = generateRandomEmployee();
            Employee e2 = generateRandomEmployee();
            List<Employee> employeeList = Arrays.asList(e1, e2);
            Faculty faculty = generateRandomFaculty(employeeList);
            return new Teacher(firstName, lastName, phoneNumber, age, payScale, faculty);
        }

        public static University generateDefaultUniversity() {
            University university = new University("Default University", "Default Location");

            for (int i = 0; i < 10; i++) {
                university.studentList.add(generateRandomStudent());
            }

            for (int i = 0; i < 5; i++) {
                university.employeeList.add(generateRandomTeacher());
            }

            university.facultyList.add(generateRandomFaculty(university.employeeList));

            for (int i = 0; i < 3; i++) {
                university.classroomList.add(generateRandomClassroom());
            }

            university.courseList.add(generateRandomCourse(university.studentList));

            for (int i = 0; i < 2; i++) {
                university.scheduleList.add(generateRandomSchedule(university.courseList, university.classroomList));
            }

            return university;
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
