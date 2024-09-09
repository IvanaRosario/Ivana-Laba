package com.solvd.laba;

import com.solvd.laba.service.StudentManager;
import com.solvd.laba.service.TeacherManager;
import java.util.*;

public class College {
    private final String name;
    private Set<Staff> staff = new HashSet<>();
    private static TeacherManager teacherManager;
    private static StudentManager studentManager;

    static {
        teacherManager = new TeacherManager();
        studentManager = new StudentManager();
    }

    public String getName() {
        return name;
    }

    public static TeacherManager getTeacherManager() {
        return teacherManager;
    }

    public static StudentManager getStudentManager() {
        return studentManager;
    }

    public College(String name, Set<Staff> staff) {
        this.name = name;
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "College name: " + name;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }
}
