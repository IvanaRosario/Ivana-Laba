class DegreeProgram {
    private String name;
    private int duration; // in years
    

    public DegreeProgram(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void showDetails() {
        System.out.println("Degree Program: " + name + ", Duration: " + duration + " years");
    }
}
