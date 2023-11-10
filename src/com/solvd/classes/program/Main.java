package com.solvd.classes.program;

import com.solvd.classes.*;
import com.solvd.classes.elements.Classroom;
import com.solvd.classes.elements.Course;
import com.solvd.classes.elements.Faculty;
import com.solvd.classes.elements.Schedule;
import com.solvd.classes.persons.Employee;
import com.solvd.classes.persons.Professor;
import com.solvd.classes.persons.Student;
import com.solvd.classes.persons.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMenu();
    }
}
