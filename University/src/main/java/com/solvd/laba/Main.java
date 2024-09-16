package com.solvd.laba;

import com.solvd.laba.enums.*;
import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.service.StudentManager;
import com.solvd.laba.service.TeacherManager;

import java.lang.reflect.*;
import java.util.*;

public class Main {

    public static void main(String[] arg) throws ProfessorIsAlreadyHiredException, Exception {

        Degree degree1 = new Degree("Computer Engineering", CourseType.UNDERGRADUATE);
        Degree degree2 = new Degree("Bachelor on Physics", CourseType.DOCTORATE);
        Degree degree3 = new Degree("Associate degree in Computer Programing", CourseType.POSTGRADUATE);



        Staff staff1 = new Staff("Lola Flores", 40,"ST0001", "Street 123",
                "155678934", StaffCategory.ADMINISTRATIVE);

        // Declaración de Profesores
        ProfessorZ professor1 = new ProfessorZ("Juan Perez", 38,"PR0001", "Street 456",
                "123456789", "Mathematics", TeacherCategory.HEAD_OF_PRACTICAL_WORK);
        ProfessorZ professor2 = new ProfessorZ("Pepe Rodriguez", 38,"PR0002", "Street 456",
                "123456789", "Mathematics", TeacherCategory.ASSISTAN);

        // Declaración de Estudiantes
        StudentZ student1 = new StudentZ("Rosario Flores", 20, "ST0001", "Street 789",
                "123543234",degree1);
        StudentZ student2 = new StudentZ("Melina Molina", 26, "ST0002", "Street 321",
                "123456987", degree2);

        //Declaracion de Materias
        SubjectZ subject1 = new SubjectZ("Calculus", SubjectPeriod.FIRST_QUARTER);
        SubjectZ subject2 = new SubjectZ("Algebra", SubjectPeriod.FIRST_QUARTER);
        SubjectZ subject3 = new SubjectZ("Calculus II", SubjectPeriod.SECOND_QUARTER);
        SubjectZ subject4 = new SubjectZ("Algebra II", SubjectPeriod.SECOND_QUARTER);

        subject1.assignTeacher(professor1);

        College facet = new College("UNT",Set.of(staff1));

        professor1.academicActivity(subject1);
        professor2.academicActivity(subject2);

        System.out.println("--- Enrollment of students in subjects ---");
        student1.academicActivity(subject1);
        student1.academicActivity(subject2);
        student1.academicActivity(subject3);
        student1.academicActivity(subject4);
        student2.academicActivity(subject1);
        student2.academicActivity(subject2);
        student2.academicActivity(subject3);
        student2.academicActivity(subject4);

        System.out.println("\n" + facet);
        professor1.assignGrade(student1,9);
        professor1.assignGrade(student2, 10);

        subject1.showStudents();
        subject2.showStudents();
        subject1.showGrades();
        subject1.getEnrolledStudents().sort(Comparator.comparing(Person::getName));
        // 1º Custom lambda function with generics
        List<StudentZ> passedStudents = subject1.filterStudents(student ->
                subject1.getStudentsGrades().get(student) >= 4);
        passedStudents.forEach(System.out::println);

        System.out.println("\n------Members of the university------");
        System.out.println("The total number of enrolled students is: " + StudentZ.getStudentCount() + " They are:");
        student1.getInformation();
        student2.getInformation();
        System.out.println("\nThe total number of hired professors is: " + ProfessorZ.getProfCount() + " They are:");
        professor1.getInformation();
        professor2.getInformation();
        System.out.println("\nNON-TEACHING STAFF");
        staff1.getInformation();

        TeacherManager teacherManager = College.getTeacherManager();
        teacherManager.hireTeacher(professor1);
        teacherManager.hireTeacher(professor2);
        teacherManager.assignTeacherToSubject(professor1,subject1);
        teacherManager.saveTeacherListToTXTFile("profs");
        teacherManager.removeProfessorFromCollegeStaff(professor1);
        System.out.println("\nProfessors by Category");
        teacherManager.showProfessorByCategory(TeacherCategory.ASSISTAN);
        System.out.println("\nProfessors by Subject");
        teacherManager.filterProfessorsBySubject(subject1);

        StudentManager studentManager = College.getStudentManager();
        studentManager.saveStudent(student1, subject2);
        studentManager.saveStudent(student2, subject1);
        studentManager.saveStudent(student1, subject1);
        studentManager.saveStudent(student2, subject2);
        studentManager.saveStudentsListToTXTFile("studs");

        student1.studentSubjectState(subject1);

        System.out.println("\nFind Student by name: 'Melina' ...");
        studentManager.findStudentByName("Melina")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Student not found.")
                );

        System.out.println("Final average of student: " + student2 + " " + student2.calculateFinalAverage());
        System.out.println("Average Without Deferrals of student: " + student2 + " " +
                student2.calculateAverageWithoutDeferrals());
        System.out.println("Passed Subjects of student: " + student2 + " " + student2.getPassedSubjects());

        degree1.sortDegreeByCourseType();
        System.out.println("\nThis is the range of courses offered at the university ");
        Degree.getDegreesList().forEach(System.out::println);


        System.out.println("\n------Entering the library book management system------");
        Library library = new Library(new Book("Calculus I", "Tom M. Apostol", "BM0001"));
        System.out.println(student1 + " has requested a book..." );
        library.lendBook(student1);

        System.out.println("\nREFLECTION");

        Class<? extends StudentZ> objClasStudent = student1.getClass();
        String className = objClasStudent.getSimpleName();

        //Fields
        Field[] allFieldsInClass = objClasStudent.getDeclaredFields();
        for(Field var : allFieldsInClass) {
            System.out.println("\nName of Global Variable: [" + var.getName() + "]");

            System.out.println("  Access Modifier: " + (Modifier.isPublic(var.getModifiers()) ? "Public" : "Private"));

            System.out.println("  Type: " + var.getType().getTypeName());
        }

        Field classField = null;
        Object valueVariable = null;
        try {

            classField = student1.getClass().getDeclaredField("degree");
            classField.setAccessible(true);
            valueVariable = classField.get(student1);
            System.out.println("\nValue of field ["  + classField.getName() + "] is: " + valueVariable);

        } catch(NoSuchFieldException ex) {
            ex.printStackTrace();
            System.out.println("\nNo such field was found in class " + objClasStudent);

        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            System.out.println("\nField could not be accessed.");
        }


        // Methods
        Method method = null;
        try {
            System.out.println("Age student: " + student1.getName() + " before reflection: " + student1.getAge());
            method = objClasStudent.getMethod("setAge", int.class);
            method.invoke(student1, 99);
            System.out.println("Age student: " + student1.getName() + " after reflection: " + student1.getAge());

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
            System.out.println("No such method was found in class " + objClasStudent);
        }

        Method[] allMethodsInClass = objClasStudent.getDeclaredMethods();
        for(Method meth : allMethodsInClass) {
            System.out.println("\nMethod name: " + meth.getName());

            System.out.println("  Number of parameters:  " + meth.getParameterCount());

            System.out.println("  Access Modifier: " + (Modifier.isPublic(meth.getModifiers()) ? "Public." : "Private"));

            System.out.println("  Return type: " + meth.getReturnType().getTypeName());

            Type[] parametersType = meth.getGenericParameterTypes();
            System.out.println("  Types of parameters: ");
            for(Type type : parametersType) {
                System.out.println("    " + (meth.getParameterCount()>0 ? type.getTypeName() : " --- "));
            }

        }

        // Constructor
        Constructor classConstructor = objClasStudent.getConstructor(String.class, int.class,
                String.class,String.class, String.class, Degree.class);

        StudentZ student3 = (StudentZ) classConstructor.newInstance(
                "Anna Smith", 24, "ST0003", "Address 123", "6784532214", degree3);

        System.out.println("\nNew student: " + student3.getName());

    }
}