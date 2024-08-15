package main.java.com.solvd.laba;

import java.util.*;

public class Subject_Z {
    private String subjectName;
    private Professor_Z professor;
    private List<Student_Z> enrolledStudents = new ArrayList<>();
    private HashMap<Student_Z, Integer> studentsGrades = new HashMap<>();

    public Subject_Z(String subjectName, Professor_Z professor) {
        this.subjectName = subjectName;
        this.professor = professor;
    }

    public void assignGrades(HashMap<Student_Z, Integer> studentsGrades) {
            this.studentsGrades = studentsGrades;
    }

    public void enrolledStudent(Student_Z student) {
        this.enrolledStudents.add(student);
    }

    public void showStudents() {
        System.out.println("\nThe enrolled students in the subject " + subjectName + " are:");
        for(Student_Z student: enrolledStudents) {
            System.out.println(student);
        }
    }

    public void showGrades() {
        System.out.println("\nStudents grades in the subject: " + subjectName);
        for(Map.Entry<Student_Z, Integer> entry : studentsGrades.entrySet()) {
            System.out.println(entry.getKey() + ", Score: " + entry.getValue());
        }
    }

    public boolean hasStudentPassed(Student_Z student){
        return studentsGrades.get(student) > 4;
    }

    @Override
    public String toString() {
        return "Subject_Z:" + this.subjectName + ", Professor_Z:" + this.professor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Subject_Z subject = (Subject_Z) obj;
        return subjectName.equals(subject.subjectName);
    }

    @Override
    public int hashCode() {
        return subjectName.hashCode();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Professor_Z getProfessor() {
        return professor;
    }

    public List<Student_Z> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Map<Student_Z, Integer> getStudentsGrades() {
        return studentsGrades;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setProfessor(Professor_Z professor) {
        this.professor = professor;
    }

    public void setEnrolledStudents(List<Student_Z> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void setStudentGrade(Student_Z student, Integer grade) {
        this.studentsGrades.put(student, grade);
    }


}
