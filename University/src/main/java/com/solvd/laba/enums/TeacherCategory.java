package com.solvd.laba.enums;

public enum TeacherCategory {
    FULL("Exclusive Dedication", 40),
    ASOCIATE("Exclusive Dedication", 40),
    ASSISTAN("Semi-exclusive Dedication", 20),
    HEAD_OF_PRACTICAL_WORK("Semi-exclusive Dedication", 20),
    TEACHING_ASSISTAN("Simple Dedication", 10);

    private String dedication;
    private int hoursPerWeek;

    TeacherCategory(String dedication, int hoursPerWeek) {
        this.dedication = dedication;
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getDedication() {
        return dedication;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }
}
