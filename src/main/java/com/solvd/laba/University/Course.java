class Course {
    private String name;
    private Professor professor;
    private Student[] students;

    public Course(String name, Professor professor, Student[] students) {
        this.name = name;
        this.professor = professor;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void showDetails() {
        System.out.println("\nCourse: " + name);
        System.out.println("Professor details: ");
        professor.showDetails();
        for (Student student : students) {
            System.out.println("Students details: ");
            student.showDetails();
        }
    }
}

