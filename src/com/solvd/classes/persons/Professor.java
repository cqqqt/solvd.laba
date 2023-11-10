package com.solvd.classes.persons;

import com.solvd.classes.elements.Faculty;

import java.util.List;
import java.util.Objects;

public class Professor extends Teacher {

    private List<String> academicDegrees;
    private List<String> researchPapers;

    public Professor(String firstName, String lastName, String phoneNumber, int age, int payScale, Faculty faculty, List<String> academicDegrees, List<String> researchPapers) {
        super(firstName, lastName, phoneNumber, age, payScale, faculty);
        this.academicDegrees = academicDegrees;
        this.researchPapers = researchPapers;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "academicDegrees=" + academicDegrees +
                ", researchPapers=" + researchPapers +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(academicDegrees, professor.academicDegrees) &&
                Objects.equals(researchPapers, professor.researchPapers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), academicDegrees, researchPapers);
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

