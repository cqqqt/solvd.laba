package com.solvd.interfaces;

import com.solvd.exceptions.TeacherException;

import java.util.List;

public interface ITeacher {
    List<String> getSubjects();
    void setExperienceAge(int experienceAge) throws TeacherException;
}
