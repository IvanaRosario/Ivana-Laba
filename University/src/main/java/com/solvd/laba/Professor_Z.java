package main.java.com.solvd.laba;

import java.util.*;

public class Professor_Z extends Person{
    private String department;
    private Subject_Z subject;

    public Professor_Z(String name, int age, String personID, String address, String phoneNumb, String department) {
        super(name, age, personID, address, phoneNumb);
        this.department = department;
    }

    @Override
    public void academicActivity(Subject_Z subject) {
       this.subject = subject;
    }

    public void gradeStudentExam(Student_Z student, int score) {
        student.setSubjectGrade(subject, score);
        subject.setStudentGrade(student, score);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Subject_Z getSubject() {
        return subject;
    }

    public void setSubject(Subject_Z subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Professor_Z: " + getName() +
                ", specialization:" + department + '\'' +
                ", subject: " + subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Professor_Z professor = (Professor_Z) obj;

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

        return
                result;
    }
}
