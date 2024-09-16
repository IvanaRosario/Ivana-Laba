package com.solvd.laba;

import com.solvd.laba.enums.TeacherCategory;
import com.solvd.laba.exceptions.GradeOutOfBoundsException;
import com.solvd.laba.interfaces.Attendable;
import com.solvd.laba.interfaces.Filter;
import com.solvd.laba.interfaces.IGradable;
import com.solvd.laba.interfaces.IPayable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;

public class ProfessorZ extends Person implements IPayable, Attendable, IGradable {

    private static final Logger LOGGER = LogManager.getLogger(ProfessorZ.class);
    private String department;
    private SubjectZ subject;
    private int attendanceCount = 0;
    private static int profCount = 0;
    private final int baseSalary = 3000;
    private final int lectureDuration = 2;
    private TeacherCategory teacherCategory;

    public ProfessorZ(String name, int age, String personID, String address, String phoneNumb,
                      String department, TeacherCategory category) {
        super(name, age, personID, address, phoneNumb);
        this.department = department;
        this.teacherCategory = category;
        profCount++;
    }

    @Override
    public void academicActivity(SubjectZ subject) {
       this.subject = subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProfessorZ professor = (ProfessorZ) obj;
        return Objects.equals(getPersonID(), professor.getPersonID()) &&
                Objects.equals(getName(), professor.getName()) &&
                Objects.equals(getDepartment(), professor.getDepartment()) &&
                Objects.equals(getSubject(), professor.getSubject());
    }

    @Override
    public int hashCode() {
        int result = getPersonID().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + subject.hashCode();
        return result;
    }

    @Override
    public void getInformation() {
        System.out.println("Hello. My name is: "+ super.getName()+ " I'm a teacher in " + this.subject);
    }

    @Override
    public void attend(boolean isPresent) {
        if (isPresent) {
            attendanceCount++;
            System.out.println(name + " is present for the lecture.");
        } else {
            System.out.println(name + " is absent for the lecture.");
        }
    }

    @Override
    public int getAttendanceCount() {
        return attendanceCount;
    }

    @Override
    public String toString() {
        return "Professor: " + getName() +
                ", specialization: " + department +
                ", subject: " + subject + ", ID: " + getPersonID();
    }

    @Override
    public void assignGrade(StudentZ student, double score) {
        try{
            assignGradeToStudent(student,score);
        } catch (GradeOutOfBoundsException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public final double calculateSalary() {

        int hourlyRate = 50;
        double baseSalaryWithBonus = baseSalary + hourlyRate * attendanceCount * lectureDuration;
        return Optional.of(teacherCategory)
                .filter(category -> category == TeacherCategory.FULL)
                .map(category -> baseSalaryWithBonus * 1.2)
                .orElse(baseSalaryWithBonus);
    }

    public String getDepartment() {
        return department;
    }

    public static int getProfCount() {
        return profCount;
    }

    public TeacherCategory getTeacherCategory() {
        return teacherCategory;
    }

    public SubjectZ getSubject() {
        return subject;
    }

    public void setSubject(SubjectZ subject) {
        this.subject = subject;
    }

    private void assignGradeToStudent(StudentZ student, double score) throws GradeOutOfBoundsException {
        if(score<0 || score>10) {
            throw new GradeOutOfBoundsException("The grade assigned to the student " + student.getName() + " is not correct.");
        }
        student.addSubjectGrade(subject, score);
        subject.addStudentGrade(student, score);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static String getDepartmentHead(String department) {
        return switch (department) {
            case "Calculus I" -> "Dr. John Doe";
            case "Mathematics" -> "Dr. Jane Smith";
            default -> "Unknown Department";
        };
    }

    public void promote(TeacherCategory newLevel) {
        this.teacherCategory = newLevel;
    }

}
