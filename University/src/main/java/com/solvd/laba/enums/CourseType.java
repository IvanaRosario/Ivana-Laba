package com.solvd.laba.enums;

public enum CourseType {
    UNDERGRADUATE("Undergraduate", 5),
    POSTGRADUATE("Postgraduate", 4),
    DOCTORATE("Doctorate", 6);

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
