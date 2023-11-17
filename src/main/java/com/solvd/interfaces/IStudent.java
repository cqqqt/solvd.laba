package com.solvd.interfaces;

import com.solvd.exceptions.StudentException;

import java.util.List;

public interface IStudent {
    List<Integer> getGrades();
    List<String> getSubjects();
    void setGPA(double GPA) throws StudentException;
}
