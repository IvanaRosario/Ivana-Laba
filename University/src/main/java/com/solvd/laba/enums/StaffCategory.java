package com.solvd.laba.enums;

public enum StaffCategory {
    ADMINISTRATIVE(40, 950, 3.00),
    MAINTENANCE_PRODUCTION_GENERAL_SERVICES(40, 950, 2.08),
    TECHNICAL(35, 850,1.73 ),
    ASSISTANCE(35, 850, 1.20);

    private int hoursPerWeek;
    private int baseSalary;
    private double salaryScale;

    StaffCategory(int hoursPerWeek, int baseSalary, double salaryScale) {
        this.hoursPerWeek = hoursPerWeek;
        this.baseSalary = baseSalary;
        this.salaryScale = salaryScale;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public double getSalaryScale() {
        return salaryScale;
    }

}
