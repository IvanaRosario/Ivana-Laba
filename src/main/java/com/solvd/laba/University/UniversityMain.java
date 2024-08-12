public class UniversityMain {
    public static void main(String[] args) {
        Student student1 = new Student("John Doe", 20, "20230001", "Electrical Engineering");
        Professor professor1 = new Professor("Dr. Smith", 45, "Mathematics");
        NonAcademicStaff staff1 = new NonAcademicStaff("Ana Garcia", 35, "Maintenance");
        Faculty faculty1 = new Faculty("FACET", "SMT");
        DegreeProgram degreeProgram1 = new DegreeProgram("Computer Engineering", 5);
        AdministrativeStaff admin1 = new AdministrativeStaff("Laura Martinez", 40, "Administration", "HR Manager");
        Library library1 = new Library("Central", "8:00 AM - 6:00 PM");

        Faculty[] faculties = {faculty1};
        University university1 = new University("Universidad Nacional de Tucuman", "Tucuman", faculties);

        Student[] students = {student1};

        Course course1 = new Course("Mathematics", professor1, students);

        university1.showDetails();

        degreeProgram1.showDetails();

        course1.showDetails();

        System.out.println("\nNon Academic Staff: ");
        staff1.showDetails();
        admin1.showDetails();

        library1.showDetails();
        
    }
}