package com.solvd.laba;

import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.interfaces.IEnrollable;

import java.util.*;

public class SubjectZ implements IEnrollable {
    private String subjectName;
    private ProfessorZ professor;
    private List<StudentZ> enrolledStudents = new ArrayList<>();
    private HashMap<StudentZ, Double> studentsGrades = new HashMap<StudentZ, Double>();
    private static int subjectCount = 0;

    public void assignTeacher(ProfessorZ professor) throws ProfessorIsAlreadyHiredException {
        this.professor = professor;
    }

    public SubjectZ(String subjectName) {
        this.subjectName = subjectName;
        subjectCount++;
    }

    public static int getSubjectCount() {
        return subjectCount;
    }

    public void assignGrades(HashMap<StudentZ, Double> studentsGrades) {
            this.studentsGrades = studentsGrades;
    }

    @Override
    public void enrollInSubject(StudentZ student) {
        this.enrolledStudents.add(student);
    }

    public void setStudentGrade(StudentZ student, Double grade) {
        this.studentsGrades.put(student, grade);
    }

    public void showStudents() {
        System.out.println("\nThe enrolled students in the subject " + subjectName + " are:");
        for(StudentZ student: enrolledStudents) {
            System.out.println(student);
        }
    }

    public void showGrades() {
        System.out.println("\nStudents grades in the subject: " + subjectName);
        for(Map.Entry<StudentZ, Double> entry : studentsGrades.entrySet()) {
            System.out.println(entry.getKey() + ", Score: " + entry.getValue());
        }
    }

    public boolean hasStudentPassed(StudentZ student){
        return studentsGrades.get(student) > 4;
    }

    @Override
    public String toString() {
        return "SubjectZ: " + this.subjectName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SubjectZ subject = (SubjectZ) obj;
        return subjectName.equals(subject.subjectName);
    }

    @Override
    public int hashCode() {
        return subjectName.hashCode();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public ProfessorZ getProfessor() {
        return professor;
    }

    public List<StudentZ> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Map<StudentZ, Double> getStudentsGrades() {
        return studentsGrades;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setProfessor(ProfessorZ professor) {
        this.professor = professor;
    }

    public void setEnrolledStudents(List<StudentZ> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }



}
