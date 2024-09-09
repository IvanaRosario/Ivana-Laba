package com.solvd.laba;

import com.solvd.laba.interfaces.IAttendable;
import java.util.*;

public class StudentZ extends Person implements IAttendable {
    private Degree degree;
    private Map<SubjectZ, Double> subjectsGrades = new HashMap<SubjectZ, Double>();
    private List<SubjectZ> subjects = new ArrayList<>();
    private int attendanceCount = 0;
    private static int studentCount=0;

    public StudentZ(String name, int age, String personID, String address, String phoneNumb,
                    Degree degree, Map<SubjectZ, Double> subjectsGrades) {
        super(name, age, personID, address, phoneNumb);
        this.degree = degree;
        this.subjectsGrades = subjectsGrades;
        studentCount++;
    }

    public StudentZ(String name, int age, String personID, String address, String phoneNumb, Degree degree) {
        super(name, age, personID, address, phoneNumb);
        this.degree = degree;
        studentCount++;
    }

    @Override
    public void academicActivity(SubjectZ subject) {
        subjects.add(subject);
        subject.enrollInSubject(this);
    }

    @Override
    public String toString() {
        return "StudentZ: " + getName() + " ID: " + getPersonID();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentZ student = (StudentZ) obj;
        return Objects.equals(getPersonID(), student.getPersonID()) &&
               getName().equals(student.getName()) &&
               Objects.equals(getDegree(), student.getDegree());
    }

    @Override
    public int hashCode() {
        int result = getPersonID().hashCode();
        result = 31* result + getName().hashCode();
        result = 31* result + getDegree().hashCode();
        return result;
    }

    public List<SubjectZ> getSubjects() {
        return subjects;
    }

    public Degree getDegree() {
        return degree;
    }

    public Map<SubjectZ, Double> getSubjectsGrades() {
        return subjectsGrades;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSubjectGrade(SubjectZ subject, Double grade) {
        this.subjectsGrades.put(subject, grade);
    }

    public boolean isSubjectPassed(SubjectZ subject){
        return subjectsGrades.get(subject) > 4;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    @Override
    public void getInformation() {
        System.out.println("Helo! my name is: " + super.getName() + " and Im studing: " + this.degree);
    }


    @Override
    public void attend(boolean isPresent) {
        if (isPresent) {
            attendanceCount++;
        }
    }

    @Override
    public int getAttendanceCount() {
        return attendanceCount;
    }
}

