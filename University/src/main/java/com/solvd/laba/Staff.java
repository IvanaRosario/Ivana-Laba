package com.solvd.laba;

import com.solvd.laba.interfaces.IAttendable;
import com.solvd.laba.interfaces.IPayable;

public class Staff extends Person implements IPayable, IAttendable {
    private String workArea;
    private int attendanceCount = 0;


    public Staff(String name, int age, String personID, String address, String phoneNumb,String workArea) {
        super(name, age, personID, address, phoneNumb);
        this.workArea = workArea;
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

        double salary = switch (this.workArea) {
            case "Administration" -> 950 + 1.28;
            case "RRHH" -> 900 * 1.28;
            case "Library" -> 850 * 1.28;
            case "Janitor" -> 800 * 1.28;
            default -> 0.0;
        };
        return salary;
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