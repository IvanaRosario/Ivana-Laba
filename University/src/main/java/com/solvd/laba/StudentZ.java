package com.solvd.laba;

import com.solvd.laba.enums.SubjectState;
import com.solvd.laba.interfaces.Attendable;
import com.solvd.laba.interfaces.Identifiable;
import com.solvd.laba.service.StudentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


public class StudentZ extends Person implements Attendable, Identifiable {

    private static final Logger LOGGER = LogManager.getLogger(StudentZ.class);
    private Degree degree;
    private HashMap<SubjectZ, Double> subjectsGrades = new HashMap<SubjectZ, Double>();
    private List<SubjectZ> subjects = new ArrayList<>();
    private int attendanceCount = 0;
    private static int studentCount=0;
    private SubjectState subjectState;

    public StudentZ(String name, int age, String personID, String address, String phoneNumb,
                    Degree degree, HashMap<SubjectZ, Double> subjectsGrades) {
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
        StudentManager studentManager = College.getStudentManager();
        studentManager.addStudents(this);
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
    public int getAttendanceCount()  {
        return attendanceCount;
    }

    public void setSubjectState(SubjectState subjectState) {
        this.subjectState = subjectState;
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

    public SubjectState getSubjectState() {
        return subjectState;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void addSubjectGrade(SubjectZ subject, Double grade) {
        this.subjectsGrades.put(subject, grade);
    }

    public void studentSubjectState(SubjectZ subject) {
        if( subjectsGrades.get(subject) >= 4){
                subjectState = SubjectState.PASSED;
                System.out.println("The student " + this.getName() +
                        " has " +  subjectState.getState() + " " +
                        subject.getSubjectName() );

        } else if( subjectsGrades.get(subject) <= 4){
                subjectState = SubjectState.RETAKING;
                System.out.println("\nThe Student " + this.getName() +
                        " is " + subjectState.getState() + " " +
                        subject.getSubjectName());

        }else if(subjects.contains(subject)) {
                subjectState = SubjectState.TAKING;
                System.out.println("\nThe Student " + this.getName() +
                        " is " + subjectState.getState() + " " +
                        subject.getSubjectName());

        } else {
                System.out.println("Subject " + subject.getSubjectName() +
                        " not found for the student " + this.getName());
        }
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public double calculateAverageWithoutDeferrals() {
        return subjectsGrades.values().stream()
                .mapToDouble(Double::doubleValue)
                .filter(e -> e>=4)
                .average()
                .orElse(0.0);
    }

    public double calculateFinalAverage() {
        return subjectsGrades.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public List<SubjectZ> getPassedSubjects() {
        return subjectsGrades.entrySet().stream()
                .filter(entry -> entry.getValue() >= 4)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



}

