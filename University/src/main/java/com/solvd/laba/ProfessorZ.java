package main.java.com.solvd.laba;

import java.util.*;

public class ProfessorZ extends Person implements IPayable, IAttendable, IGradable {
    private String department;
    private SubjectZ subject;
    private int attendanceCount = 0;
    private static int profCount = 0;
    private final int baseSalary = 3000;
    private final int lectureDuration = 2;


    public ProfessorZ(String name, int age, String personID, String address, String phoneNumb, String department) {
        super(name, age, personID, address, phoneNumb);
        this.department = department;
        profCount++;
    }

    @Override
    public void academicActivity(SubjectZ subject) {
       this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public SubjectZ getSubject() {
        return subject;
    }

    public void setSubject(SubjectZ subject) {
        this.subject = subject;
    }

    public static String getDepartmentHead(String department) {
        switch (department) {
            case "Calculus I":
                return "Dr. John Doe";
            case "Mathematics":
                return "Dr. Jane Smith";
            default:
                return "Unknown Department";
        }
    }

    @Override
    public String toString() {
        return "ProfessorZ: " + getName() +
                ", specialization:" + department + '\'' +
                ", subject: " + subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProfessorZ professor = (ProfessorZ) obj;
        return
                Objects.equals(getPersonID(), professor.getPersonID()) &&
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
    public final double calculateSalary() {
        int hourlyRate = 50;

        return baseSalary + hourlyRate*attendanceCount*lectureDuration;
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
    public void assignGrade(StudentZ student, double score) {
        student.setSubjectGrade(subject, score);
        subject.setStudentGrade(student, score);
    }

}
