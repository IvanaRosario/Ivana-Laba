package main.java.com.solvd.laba;

import java.util.*;


public class Student_Z extends Person {
    private Degree degree;
    private Map<Subject_Z, Integer> subjectsGrades = new HashMap<>();
    private List<Subject_Z> subjects = new ArrayList<>();

    public Student_Z(String name, int age, String personID, String address, String phoneNumb,
                     Degree degree, Map<Subject_Z, Integer> subjectsGrades) {
        super(name, age, personID, address, phoneNumb);
        this.degree = degree;
        this.subjectsGrades = subjectsGrades;
    }

    public Student_Z(String name, int age, String personID, String address, String phoneNumb, Degree degree) {
        super(name, age, personID, address, phoneNumb);
        this.degree = degree;
    }

    @Override
    public void academicActivity(Subject_Z subject) {
        subjects.add(subject);
        subject.enrolledStudent(this);
    }

    @Override
    public String toString() {
        return "Student_Z: " + getName() +
                " ID: " + getPersonID();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student_Z student = (Student_Z) obj;
        return
                Objects.equals(getPersonID(), student.getPersonID()) &&
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

    public Degree getDegree() {
        return degree;
    }

    public Map<Subject_Z, Integer> getSubjectsGrades() {
        return subjectsGrades;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSubjectGrade(Subject_Z subject, Integer grade) {
        this.subjectsGrades.put(subject, grade);
    }

    public boolean isSubjectPassed(Subject_Z subject){
        return subjectsGrades.get(subject) > 4;
    }

 }

