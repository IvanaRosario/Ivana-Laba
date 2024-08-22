package main.java.com.solvd.laba;

import java.util.*;

public class College {
    private final String name;
    private Set<Degree> degrees = new HashSet<>();
    private Set<ProfessorZ> professors = new HashSet<>();
    private Set<StudentZ> students = new HashSet<>();
    private Set<Staff> staff = new HashSet<>();

    public College(String name, Set<Degree> degrees, Set<ProfessorZ> professors, Set<StudentZ> students, Set<Staff> staff) {
        this.name = name;
        this.degrees = degrees;
        this.professors = professors;
        this.students = students;
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "College name: " + name;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

    public Set<ProfessorZ> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<ProfessorZ> professors) {
        this.professors = professors;
    }

    public Set<StudentZ> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentZ> students) {
        this.students = students;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }
}
