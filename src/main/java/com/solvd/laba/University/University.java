public class University {
    private String name;
    private String city;
    private Faculty[] faculties;

    public University(String name, String city, Faculty[] faculties) {
        this.name = name;
        this.city = city;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public void showDetails() {
        System.out.println("University: " + name + ", City: " + city);
        for (Faculty faculty : faculties) {
            faculty.showDetails();
        }
    }
}