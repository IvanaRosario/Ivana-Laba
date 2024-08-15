package main.java.com.solvd.laba;

public class Staff extends Person {
    private String workArea;

    public Staff(String name, int age, String personID, String address, String phoneNumb,String workArea) {
        super(name, age, personID, address, phoneNumb);
        this.workArea = workArea;
    }

    @Override
    public void academicActivity(Subject_Z subject) {
    }

    @Override
    public String toString() {
        return "Staff: " + getName() +
                "Work Area : " + workArea;
    }


}