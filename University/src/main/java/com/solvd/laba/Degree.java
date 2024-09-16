package com.solvd.laba;

import com.solvd.laba.enums.CourseType;
import com.solvd.laba.interfaces.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Degree {
    private String name;
    private int duration;
    private List<SubjectZ> degreeSpecificSubjects = new ArrayList<>();
    private CourseType courseType;
    private static List<Degree> degreesList = new ArrayList<>();

    public Degree(String name, CourseType courseType) {
        this.name = name;
        this.courseType = courseType;
        duration = courseType.getDurationYears();
        degreesList.add(this);
    }

    @Override
    public String toString() {
        return "Degree = '" + name + '\'' +
                ", duration = " + duration +
                ", courseType = " + courseType;
    }

    public static List<Degree> getDegreesList() {
        return degreesList;
    }

    public CourseType getCourseType() {
        return courseType;
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

    public void sortDegreeByCourseType() {
        Sorter<Degree> sortByType = list -> {
            list.sort(Comparator.comparing(Degree::getCourseType));
         return list;
        };
        degreesList = sortByType.sort(degreesList);
    }

}

