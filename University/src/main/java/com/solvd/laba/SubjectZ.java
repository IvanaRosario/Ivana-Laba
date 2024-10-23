package com.solvd.laba;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.enums.SubjectPeriod;
import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.interfaces.Filter;
import com.solvd.laba.interfaces.Enrollable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class SubjectZ implements Enrollable {

    private static final Logger LOGGER = LogManager.getLogger(SubjectZ.class);
    @JsonProperty("id")
    private int subjectId;
    @JsonProperty("name")
    private String subjectName;
    @JsonProperty
    private List<ProfessorZ> professors;
    @JsonProperty("students")
    private List<StudentZ> enrolledStudents = new ArrayList<>();
    @JsonIgnore
    private HashMap<StudentZ, Double> studentsGrades = new HashMap<StudentZ, Double>();
    @JsonIgnore
    private static int subjectCount = 0;
    @JsonProperty("period")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private SubjectPeriod subjectPeriod;

    public SubjectZ(String subjectName, SubjectPeriod period) {
        this.subjectName = subjectName;
        this.subjectPeriod = period;
        subjectCount++;
    }

    public SubjectZ() {
    }

    @Override
    public void enrollInSubject(StudentZ student) {
        if(this.subjectPeriod.isOpenRegistration()) {
            this.enrolledStudents.add(student);
            System.out.println("The student " + student.getName() +
                    " has ben successfully enrolled in " + this.getSubjectName() );
        } else {
            System.out.println("The registration period has already ended for the subject " + this.getSubjectName());
        }
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

    public void assignTeacher(ProfessorZ professor) throws ProfessorIsAlreadyHiredException {
        this.professors.add(professor);
    }

    public static int getSubjectCount() {
        return subjectCount;
    }

    public SubjectPeriod getSubjectPeriod() {
        return subjectPeriod;
    }


    public void assignGrades(HashMap<StudentZ, Double> studentsGrades) {
            this.studentsGrades = studentsGrades;
    }

    public void addStudentGrade(StudentZ student, Double grade) {
        this.studentsGrades.put(student, grade);
    }

    public void showGrades() {
        System.out.println("\nStudents grades in the subject: " + subjectName);
        studentsGrades.forEach((student, grade) ->
                System.out.println(student + ", Score: " + grade)
        );
    }

    public boolean hasStudentPassed(StudentZ student){
        return studentsGrades.get(student) > 4;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public List<ProfessorZ> getProfessors() {
        return professors;
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

    public void setProfessors(List<ProfessorZ> professors) {
        this.professors = professors;
    }

    public void setEnrolledStudents(List<StudentZ> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void showStudents() {
        enrolledStudents.stream()
                .filter(e -> e.getSubjectState().isEnrolled())
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    public List<StudentZ> filterStudents(Filter<StudentZ> condition) {
        return enrolledStudents.stream()
                .filter(condition::test)
                .collect(Collectors.toList());

    }

}
