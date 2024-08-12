class Library {
    private String name;
    private String hours;

    public Library(String name, String hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void showDetails() {
        System.out.println("Library: " + name + ", Hours: " + hours);
    }
}
