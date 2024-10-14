package com.solvd.laba;

import com.solvd.laba.enums.StaffCategory;
import com.solvd.laba.interfaces.Attendable;
import com.solvd.laba.interfaces.IPayable;

public class Staff extends Person implements IPayable, Attendable {
    private StaffCategory workArea;
    private int attendanceCount = 0;

    public Staff(String name, int age, String address, String phoneNumb, StaffCategory workArea) {
        super(name, age, address, phoneNumb);
        this.workArea = workArea;
    }

    public StaffCategory getWorkArea() {
        return workArea;
    }

    @Override
    public void academicActivity(SubjectZ subject) {
    }

    @Override
    public String toString() {
        return "Staff: " + getName() +
                "Work Area : " + workArea;
    }

    @Override
    public void getInformation() {
        System.out.println("Hello. My name is: "+ super.getName()+ " and I work in the " + this.workArea + " area");
    }


    @Override
    public double calculateSalary() {
        return workArea.getBaseSalary()* workArea.getSalaryScale();
    }

    @Override
    public void attend(boolean isPresent) {
        if (isPresent) {
            attendanceCount++;
            System.out.println(name + " is present for work.");
        } else {
            System.out.println(name + " is absent from work.");
        }
    }

    @Override
    public int getAttendanceCount() {
        return attendanceCount;
    }
}