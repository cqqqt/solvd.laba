package com.solvd.classes;

import java.util.List;

public class Professor extends Teacher {
    private List<String> academicDegrees;
    private List<String> researchPapers;

    public Professor(String firstName, String lastName, String phoneNumber, int age, int payScale, Faculty faculty, List<String> academicDegrees, List<String> researchPapers) {
        super(firstName, lastName, phoneNumber, age, payScale, faculty);
        this.academicDegrees = academicDegrees;
        this.researchPapers = researchPapers;
    }

    public List<String> getAcademicDegrees() {
        return academicDegrees;
    }

    public void setAcademicDegrees(List<String> academicDegrees) {
        this.academicDegrees = academicDegrees;
    }

    public List<String> getResearchPapers() {
        return researchPapers;
    }

    public void setResearchPapers(List<String> researchPapers) {
        this.researchPapers = researchPapers;
    }
}

