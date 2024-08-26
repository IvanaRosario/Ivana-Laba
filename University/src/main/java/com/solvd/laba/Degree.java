package main.java.com.solvd.laba;

import java.util.ArrayList;
import java.util.List;

public class Degree {
    private String name;
    private int duration;
    private List<SubjectZ> degreeSpecificSubjects = new ArrayList<>();

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

