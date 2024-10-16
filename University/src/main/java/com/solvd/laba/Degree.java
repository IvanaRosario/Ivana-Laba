package com.solvd.laba;

import com.solvd.laba.enums.CourseType;
import com.solvd.laba.interfaces.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Degree {
    private int degreeID;
    private String name;
    private int duration;
    private List<SubjectZ> degreeSpecificSubjects = new ArrayList<>();
    private final CourseType courseType;
    private static List<Degree> degreesList = new ArrayList<Degree>();


    public Degree(int id, String name, CourseType courseType) {
        this.degreeID = id;
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

    public static Degree degreeName(int id) {
        Degree degree = null;
        for(Degree dgr: Degree.degreesList) {
            if(dgr.getDegreeID() == id) {
                degree = dgr;
            } else {
                System.out.println("Degree not found.");
            }
        }
        return degree;
    }

    public int getDegreeID() {
        return degreeID;
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

