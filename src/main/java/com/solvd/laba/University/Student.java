public class Student extends Person {
    private String studentID;
    private String career;

    public Student(String name, int age, String studentID, String career) {
        super(name, age);
        this.studentID = studentID;
        this.career = career;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String matricula) {
        this.studentID = matricula;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String carrera) {
        this.career = carrera;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Student ID: " + studentID);
    }
}
