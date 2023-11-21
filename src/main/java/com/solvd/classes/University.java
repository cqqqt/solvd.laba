package com.solvd.classes;

import com.solvd.classes.elements.Classroom;
import com.solvd.classes.elements.Course;
import com.solvd.classes.elements.Faculty;
import com.solvd.classes.elements.Schedule;
import com.solvd.classes.persons.Employee;
import com.solvd.classes.persons.Person;
import com.solvd.classes.persons.Student;
import com.solvd.classes.persons.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class University {

    private static final Logger LOGGER = LogManager.getLogger(University.class);

    private String name;
    private String location;
    private static List<Student> studentList;
    private static List<Employee> employeeList;
    private static List<Schedule> scheduleList;
    private static List<Faculty> facultyList;
    private static List<Course> courseList;
    private static Set<Classroom> classroomSet;

    public University(String name, String location) {
        this.name = name;
        this.location = location;
        studentList = new ArrayList<>();
        employeeList = new ArrayList<>();
        scheduleList = new ArrayList<>();
        facultyList = new ArrayList<>();
        courseList = new ArrayList<>();
        classroomSet = new HashSet<>();
    }

    public static class Creator {

        private static final List<String> FIRST_NAMES = Arrays.asList("Артем", "Дмитрий", "Иван",
                "Николай", "Александр", "Максим", "Владимир", "Андрей", "Сергей", "Алексей", "Кирилл", "Егор", "Павел",
                "Василий", "Михаил");
        private static final List<String> LAST_NAMES = Arrays.asList("Иванов", "Смирнов", "Кузнецов",
                "Попов", "Васильев", "Петров", "Соколов", "Михайлов", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев",
                "Лебедев", "Семенов");
        private static final List<String> SPECIALIZATIONS = Arrays.asList("IT", "Математика", "Физика", "Химбио");

        private static final Random random = new Random();

        private static <T> T getRandomElement(List<T> list) {
            return list.get(random.nextInt(list.size()));
        }

        private static <T> T getRandomElementFromSet(Set<T> set) {
            List<T> list = List.copyOf(set);

            return getRandomElement(list);
        }

        private static String generateRandomPhoneNumber() {
            String prefix = random.nextBoolean() ? "37529" : "37544";
            StringBuilder phoneNumber = new StringBuilder(prefix);

            for (int i = 0; i < 7; i++) {
                phoneNumber.append(random.nextInt(10));
            }

            return phoneNumber.toString();
        }

        private static Classroom generateRandomClassroom() {
            String number = "#" + random.nextInt(100);
            int capacity = random.nextInt(50) + 10;
            String equipment = getRandomElement(Arrays.asList("Проектор", "Доска", "Компьютеры"));
            return new Classroom(number, capacity, equipment);
        }

        private static Course generateRandomCourse(List<Student> students) {
            String name = getRandomElement(Arrays.asList("Мировая экономика", "История искусства", "Основы теории " +
                    "физической культуры", "Энергетический обмен в организме", "Климатология"));
            Teacher teacher = generateRandomTeacher();
            int hours = random.nextInt(4) + 1;
            return new Course(name, teacher, students, hours);
        }

        private static Faculty generateRandomFaculty(List<Employee> employees) {
            String facultyName = getRandomElement(Arrays.asList("Информационных Технологий и Компьютерных Наук", "" +
                    "Гуманитарных Наук", "Естественных Наук", "Общественных Наук", "Искусств и Дизайна"));
            Employee dean = getRandomElement(employees);
            return new Faculty(facultyName, dean);
        }

        private static Schedule generateRandomSchedule(List<Course> courses, Set<Classroom> classrooms) {
            String name = "#" + random.nextInt(5);
            String dayOfWeek = getRandomElement(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
            String startTime = random.nextInt(12) + ":00";
            Course course = getRandomElement(courses);
            Classroom classroom = getRandomElementFromSet(classrooms);
            return new Schedule(name, dayOfWeek, startTime, course, classroom);
        }

        private static Employee generateRandomEmployee() {
            String firstName = getRandomElement(FIRST_NAMES);
            String lastName = getRandomElement(LAST_NAMES);
            String phoneNumber = generateRandomPhoneNumber();
            int age = random.nextInt(20) + 30;
            int payScale = random.nextInt(3) + 1;
            return new Employee(firstName, lastName, phoneNumber, age, payScale);
        }

        private static Student generateRandomStudent() {
            String firstName;
            String lastName;

            do {
                firstName = getRandomElement(FIRST_NAMES);
                lastName = getRandomElement(LAST_NAMES);
            } while (isNameAndLastNameAlreadyExist(firstName, lastName));

            String phoneNumber = generateRandomPhoneNumber();
            int age = random.nextInt(10) + 18;
            Employee e1 = generateRandomEmployee();
            Employee e2 = generateRandomEmployee();
            List<Employee> employeeList = Arrays.asList(e1, e2);
            Faculty faculty = generateRandomFaculty(employeeList);
            facultyList.add(faculty);
            String specialization = getRandomElement(SPECIALIZATIONS);
            return new Student(firstName, lastName, phoneNumber, age, faculty, specialization);
        }

        private static Teacher generateRandomTeacher() {
            String firstName = getRandomElement(FIRST_NAMES);
            String lastName = getRandomElement(LAST_NAMES);
            String phoneNumber = generateRandomPhoneNumber();
            int age = random.nextInt(20) + 30;
            int payScale = random.nextInt(3) + 1;
            Employee e1 = generateRandomEmployee();
            Employee e2 = generateRandomEmployee();
            List<Employee> employeeList = Arrays.asList(e1, e2);
            Faculty faculty = generateRandomFaculty(employeeList);
            facultyList.add(faculty);
            return new Teacher(firstName, lastName, phoneNumber, age, payScale, faculty);
        }

        public static University generateDefaultUniversity() {
            University university = new University("Solvd University", "Some Location");

            for (int i = 0; i < 10; i++) {
                studentList.add(generateRandomStudent());
            }

            for (int i = 0; i < 5; i++) {
                employeeList.add(generateRandomTeacher());
            }

            facultyList.add(generateRandomFaculty(employeeList));

            for (int i = 0; i < 3; i++) {
                classroomSet.add(generateRandomClassroom());
            }

            courseList.add(generateRandomCourse(studentList));

            for (int i = 0; i < 2; i++) {
                scheduleList.add(generateRandomSchedule(courseList, classroomSet));
            }

            return university;
        }
    }

    private static boolean isNameAndLastNameAlreadyExist(String firstName, String lastName) {
        for (Student person : studentList) {
            if (person != null) {
                if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                    return true;
                }
            }
        }

        for (Person person : employeeList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    return true;
                }
            } else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getFirstName().equals(firstName) && teacher.getLastName().equals(lastName)) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Set<Classroom> getClassroomSet() {
        return classroomSet;
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
