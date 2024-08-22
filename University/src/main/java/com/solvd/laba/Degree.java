package main.java.com.solvd.laba;

import java.util.ArrayList;
import java.util.List;

public class Degree {
    private String name;
    private int duration;
    private static final List<SubjectZ> complementaryCycle = new ArrayList<>();
    private List<SubjectZ> degreeSpecificSubjects = new ArrayList<>();

    static {
        complementaryCycle.add(new SubjectZ("Physics I"));
        complementaryCycle.add(new SubjectZ("Calculus I"));
        complementaryCycle.add(new SubjectZ("Algebra I"));
        complementaryCycle.add(new SubjectZ("Chemistry"));
        complementaryCycle.add(new SubjectZ("Calculus II"));
        complementaryCycle.add(new SubjectZ("Physics II"));
        complementaryCycle.add(new SubjectZ("Algebra II"));
    }


    public Degree(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public List<SubjectZ> getDegreeSpecificSubjects() {
        return degreeSpecificSubjects;
    }

    public void setDegreeSpecificSubjects(List<SubjectZ> degreeSpecificSubjects) {
        this.degreeSpecificSubjects = degreeSpecificSubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "Degree {" +
                name + '\'' + ", completion time: " +
                duration +
                '}';
    }
}

