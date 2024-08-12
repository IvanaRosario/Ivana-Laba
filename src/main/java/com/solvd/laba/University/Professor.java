public class Professor extends Person {
    private String specialization;

    public Professor(String nombre, int edad, String specialization) {
        super(nombre, edad);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Specialization: " + specialization);
    }

}
