package com.solvd.laba.enums;

public enum CourseType {
    UNDERGRADUATE("Undergraduate", 4),
    POSTGRADUATE("Postgraduate", 3),
    DOCTORATE("Doctorate", 5);

    private final String courseName;
    private final int durationYears;

    CourseType(String courseName, int durationYears) {
        this.courseName = courseName;
        this.durationYears = durationYears;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDurationYears() {
        return durationYears;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
