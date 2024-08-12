class AdministrativeStaff extends NonAcademicStaff {
    private String position;

    public AdministrativeStaff(String name, int age, String workArea, String position) {
        super(name, age, workArea);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Overriding method
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Position: " + position);
    }
}
