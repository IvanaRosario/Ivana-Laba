package com.solvd.laba;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private Degree degree;
    @JsonProperty
    private int degreeID;
    @JsonIgnore
    private HashMap<SubjectZ, Double> subjectsGrades = new HashMap<SubjectZ, Double>();
    @JsonProperty
    private List<SubjectZ> subjects = new ArrayList<>();
    @JsonIgnore
    private int attendanceCount = 0;
    @JsonIgnore
    private static int studentCount=0;
    @JsonIgnore
    private SubjectState subjectState;

    public StudentZ() {}

    public StudentZ(String name, int age, String address, String phoneNumb,
                    int degreeID, HashMap<SubjectZ, Double> subjectsGrades) {
        super(name, age, address, phoneNumb);
        this.degreeID = degreeID;
        this.subjectsGrades = subjectsGrades;
        studentCount++;
    }

    public StudentZ(String name, int age, String address, String phoneNumb, int degreeID) {
        super(name, age, address, phoneNumb);
        this.degreeID = degreeID;
        studentCount++;
        this.setDegree(this.degreeID);
    }

    private void setDegree(int degreeID) {
        this.degree = Degree.degreeName(degreeID);
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
        return "StudentZ: " + getName() + " ID: " + getPersonID()
                + " Age: " + getAge()
                + " Degree: " + getDegree();
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
        return Objects.hash(degreeID, getDegree(), getSubjects(), getSubjectState());
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

    public int getDegreeID() {
        return degreeID;
    }


    public Map<SubjectZ, Double> getSubjectsGrades() {
        return subjectsGrades;
    }

    public SubjectState getSubjectState() {
        return subjectState;
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

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
        this.degree = Degree.degreeName(degreeID);
    }
}

