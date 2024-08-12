class NonAcademicStaff extends Person {
    private String workArea;

    public NonAcademicStaff(String name, int age, String workArea) {
        super(name, age);
        this.workArea = workArea;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    // Overriding method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Work Area: " + workArea);
    }
}