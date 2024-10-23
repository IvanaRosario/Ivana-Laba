package com.solvd.laba;

import com.solvd.laba.enums.*;
import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.service.ProfessorServiceImpl;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import static com.solvd.laba.JaxB.unmarshal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Main {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");


    public static  void main(String[] arg) throws ProfessorIsAlreadyHiredException, Exception {

        Degree degree1 = new Degree(1,"Computer Engineering", CourseType.UNDERGRADUATE);
        Degree degree2 = new Degree(2,"Bachelor on Physics", CourseType.DOCTORATE);
        Degree degree3 = new Degree(3,"Associate degree in Computer Programing", CourseType.POSTGRADUATE);
//
//
//
//        Staff staff1 = new Staff("Lola Flores", 40,"ST0001", "Street 123",
//                "155678934", StaffCategory.ADMINISTRATIVE);
//
//        // Declaración de Profesores
//        ProfessorZ professor1 = new ProfessorZ("Juan Perez", 38,"PR0001", "Street 456",
//                "123456789", "Mathematics", TeacherCategory.HEAD_OF_PRACTICAL_WORK);
//        ProfessorZ professor2 = new ProfessorZ("Pepe Rodriguez", 55,"PR0002", "Street 456",
//                "123456789", "Mathematics", TeacherCategory.ASSISTAN);
//
//        // Declaración de Estudiantes
//        StudentZ student1 = new StudentZ("Rosario Flores", 20, "ST0001", "Street 789",
//                "123543234",degree1);
//        StudentZ student2 = new StudentZ("Melina Molina", 26, "ST0002", "Street 321",
//                "123456987", degree2);
//
//        //Declaracion de Materias
//        SubjectZ subject1 = new SubjectZ("Calculus", SubjectPeriod.FIRST_QUARTER);
//        SubjectZ subject2 = new SubjectZ("Algebra", SubjectPeriod.FIRST_QUARTER);
//        SubjectZ subject3 = new SubjectZ("Calculus II", SubjectPeriod.SECOND_QUARTER);
//        SubjectZ subject4 = new SubjectZ("Algebra II", SubjectPeriod.SECOND_QUARTER);
//
//        subject1.assignTeacher(professor1);
//
//        College facet = new College("UNT",Set.of(staff1));
//
//        professor1.academicActivity(subject1);
//        professor2.academicActivity(subject2);
//
//        System.out.println("--- Enrollment of students in subjects ---");
//        student1.academicActivity(subject1);
//        student1.academicActivity(subject2);
//        student1.academicActivity(subject3);
//        student1.academicActivity(subject4);
//        student2.academicActivity(subject1);
//        student2.academicActivity(subject2);
//        student2.academicActivity(subject3);
//        student2.academicActivity(subject4);
//
//        System.out.println("\n" + facet);
//        professor1.assignGrade(student1,9);
//        professor1.assignGrade(student2, 10);
//
//        subject1.showStudents();
//        subject2.showStudents();
//        subject1.showGrades();
//        subject1.getEnrolledStudents().sort(Comparator.comparing(Person::getName));
//        // 1º Custom lambda function with generics
//        List<StudentZ> passedStudents = subject1.filterStudents(student ->
//                subject1.getStudentsGrades().get(student) >= 4);
//        passedStudents.forEach(System.out::println);
//
//        System.out.println("\n------Members of the university------");
//        System.out.println("The total number of enrolled students is: " + StudentZ.getStudentCount() + " They are:");
//        student1.getInformation();
//        student2.getInformation();
//        System.out.println("\nThe total number of hired professors is: " + ProfessorZ.getProfCount() + " They are:");
//        professor1.getInformation();
//        professor2.getInformation();
//        System.out.println("\nNON-TEACHING STAFF");
//        staff1.getInformation();
//
//        TeacherManager teacherManager = College.getTeacherManager();
//        teacherManager.hireTeacher(professor1);
//        teacherManager.hireTeacher(professor2);
//        teacherManager.assignTeacherToSubject(professor1,subject1);
//        teacherManager.saveTeacherListToTXTFile("profs");
//        teacherManager.removeProfessorFromCollegeStaff(professor1);
//        System.out.println("\nProfessors by Category");
//        teacherManager.showProfessorByCategory(TeacherCategory.ASSISTAN);
//        System.out.println("\nProfessors by Subject");
//        teacherManager.filterProfessorsBySubject(subject1);
//
//        StudentManager studentManager = College.getStudentManager();
//        studentManager.saveStudent(student1, subject2);
//        studentManager.saveStudent(student2, subject1);
//        studentManager.saveStudent(student1, subject1);
//        studentManager.saveStudent(student2, subject2);
//        studentManager.saveStudentsListToTXTFile("studs");
//
//        student1.studentSubjectState(subject1);
//
//        System.out.println("\nFind Student by name: 'Melina' ...");
//        studentManager.findStudentByName("Melina")
//                .ifPresentOrElse(
//                        System.out::println,
//                        () -> System.out.println("Student not found.")
//                );
//
//        System.out.println("Final average of student: " + student2 + " " + student2.calculateFinalAverage());
//        System.out.println("Average Without Deferrals of student: " + student2 + " " +
//                student2.calculateAverageWithoutDeferrals());
//        System.out.println("Passed Subjects of student: " + student2 + " " + student2.getPassedSubjects());
//
//        degree1.sortDegreeByCourseType();
//        System.out.println("\nThis is the range of courses offered at the university ");
//        Degree.getDegreesList().forEach(System.out::println);
//
//
//        System.out.println("\n------Entering the library book management system------");
//        Library library = new Library(new Book("Calculus I", "Tom M. Apostol", "BM0001"));
//        System.out.println(student1 + " has requested a book..." );
//        library.lendBook(student1);
//
//
//
//
//        System.out.println("\nREFLECTION");
//
//        Class<? extends StudentZ> objClasStudent = student1.getClass();
//        String className = objClasStudent.getSimpleName();
//        System.out.println("REFLECION IN THE  " + className.toUpperCase() + " CLASS");
//
//        //Fields
//        Field[] allFieldsInClass = objClasStudent.getDeclaredFields();
//        for(Field var : allFieldsInClass) {
//            System.out.println("\nName of Global Variable: [" + var.getName() + "]");
//
//            System.out.println("  Access Modifier: " + (Modifier.isPublic(var.getModifiers()) ? "Public" : "Private"));
//
//            System.out.println("  Type: " + var.getType().getTypeName());
//        }
//
//        Field classField = null;
//        Object valueVariable = null;
//        try {
//
//            classField = objClasStudent.getDeclaredField("degree");
//            classField.setAccessible(true);
//            valueVariable = classField.get(student1);
//            System.out.println("\nValue of field ["  + classField.getName() + "] is: " + valueVariable);
//
//        } catch(NoSuchFieldException ex) {
//            ex.printStackTrace();
//            System.out.println("\nNo such field was found in class " + objClasStudent);
//
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//            System.out.println("\nField could not be accessed.");
//        }
//
//
//        // Methods
//        Method method = null;
//        try {
//            System.out.println("Age student: " + student1.getName() + " before reflection: " + student1.getAge());
//            method = objClasStudent.getMethod("setAge", int.class);
//            method.invoke(student1, 99);
//            System.out.println("Age student: " + student1.getName() + " after reflection: " + student1.getAge());
//
//        } catch (NoSuchMethodException ex) {
//            ex.printStackTrace();
//            System.out.println("No such method was found in class " + objClasStudent);
//        }
//
//        Method[] allMethodsInClass = objClasStudent.getDeclaredMethods();
//        for(Method meth : allMethodsInClass) {
//            System.out.println("\nMethod name: " + meth.getName());
//            System.out.println("  Number of parameters:  " + meth.getParameterCount());
//            System.out.println("  Access Modifier: " + (Modifier.isPublic(meth.getModifiers()) ? "Public." : "Private"));
//            System.out.println("  Return type: " + meth.getReturnType().getTypeName());
//
//            Type[] parametersType = meth.getGenericParameterTypes();
//            System.out.println("  Types of parameters: ");
//            if(meth.getParameterCount() == 0) {
//                System.out.println("   ---");
//            }
//            for(Type type : parametersType) {
//                System.out.println("  " + type.getTypeName());
//            }
//
//        }
//
//        // Constructor
//        Constructor classConstructor = objClasStudent.getConstructor(String.class, int.class,
//                String.class,String.class, String.class, Degree.class);
//
//        StudentZ student3 = (StudentZ) classConstructor.newInstance(
//                "Anna Smith", 24, "ST0003", "Address 123", "6784532214", degree3);
//
//        System.out.println("\nNew student: " + student3.getName());
//

//
//        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_db",
//                "root", "gringuita")) {
//
//            StudentDAO dao = new MySQLStudentDAO(conn);
//            StudentZ newStudent = new StudentZ("Brad Pitt", 29, "Example 123",
//                    "1234654543", 2);
//
//            dao.insert(newStudent);
//
//            System.out.println("The student has been registered whit id " + newStudent.getPersonID());
//
//            List<StudentZ> students = dao.getAll();
//            for(StudentZ std : students) {
//                System.out.println(std.toString());
//            }
//
//        }


//        try (Connection conn = ConnectionPolling.getConnection()) {
//
//            StudentServiceImpl stdService = new StudentServiceImpl(new MySQLStudentDAO(conn));
//            SubjectServiceImpl subjectService = new SubjectServiceImpl(new MySQLSubjectDAO(conn));
//            ProfessorServiceImpl profService = new ProfessorServiceImpl(new MySQLProfessorDAO(conn));
//
//            StudentZ newStudent = new StudentZ("Bill Skarsgard", 23, "123 Main St", "555-1234", 2);
//            try {
//                stdService.create(newStudent);
//                System.out.println("Student inserted with ID: " + newStudent.getPersonID());
//            } catch (DAOException e) {
//                System.err.println("Error inserting student: " + e.getMessage());
//            }
//
//            try {
//                StudentZ student = stdService.getById(11);
//                System.out.println("Student retrieved: " + student.getName());
//            } catch (DAOException e) {
//                System.err.println("Error retrieving student: " + e.getMessage());
//            }
//
//            try {
//                newStudent.setAddress("456 New St");
//                stdService.update(newStudent);
//                System.out.println("Student updated.");
//            } catch (DAOException e) {
//                System.err.println("Error updating student: " + e.getMessage());
//            }
//
//            try {
//                List<SubjectZ> subjects = subjectService.getAll();
//                System.out.println("Subjects: " + subjects.size());
//                for (SubjectZ subject : subjects) {
//                    System.out.println(subject.getSubjectName());
//                }
//            } catch (DAOException e) {
//                System.err.println("Error retrieving subjects: " + e.getMessage());
//            }
//
//            try {
//                ProfessorZ professor = profService.getById(2);
//                profService.delete(professor);
//                System.out.println("Professor deleted.");
//            } catch (DAOException e) {
//                System.err.println("Error deleting professor: " + e.getMessage());
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Connection error: " + e.getMessage());
//        }


        //marshal
//        Staff staff = new Staff();
//        staff.setName("Roberto Gomez");
//        staff.setAge(34);
//        staff.setAddress("Address 001");
//        staff.setPhoneNumb("2222-03465");
//        staff.setWorkArea(StaffCategory.ADMINISTRATIVE);
//        staff.setPersonID(1);
//        JaxB.marshal(staff, Staff.class);

        // 1,, ,01-13-2013
//        Date specificDate = sdf.parse("2013/01/13");
//        Book book = new Book(1, "General Chemistry: The Essential Concepts", "Raymond Chang", specificDate);
//
//        Library library = new Library(List.of(book));
//
//        JaxB.marshal(library, Library.class);
//
//        // unmarshal
//        Staff staff2 = unmarshal("./staff.xml", Staff.class);
//        System.out.println(staff2);
//        Date specificDate2 = sdf.parse("1983/01/01");
//        Book book2 = new Book(2, "Linear Algebra with Applications", " Steven J Leon", specificDate2);
//
//        Library library1 = unmarshal("./Library.xml", Library.class);
//        library1.getBooks().add(book2);
//
//        JaxB.marshal(library1, Library.class);



        StudentZ student = JsonParser.parseJason(
                "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\student.json",
                StudentZ.class);
        System.out.println("Student parsed: " + student);

        ProfessorZ professor = JsonParser.parseJason(
                "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\professor.json",
                ProfessorZ.class);
        System.out.println("Professor parsed: " + professor);

        SubjectZ subject = JsonParser.parseJason(
                "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\subject.json",
                SubjectZ.class);
        System.out.println("Subject parsed: " + subject);

        Book book = JsonParser.parseJason(
                "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\book.json" ,
                Book.class);
        System.out.println("Book parsed: " + book);





    }
}