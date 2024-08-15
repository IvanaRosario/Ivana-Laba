package main.java.com.solvd.laba;

public class Degree {
    private String name;
    private int duration;

    public Degree(String name, int duration) {
        this.name = name;
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Degree {" +
                name + '\'' + ", completion time: " +
                duration +
                '}';
    }
}

