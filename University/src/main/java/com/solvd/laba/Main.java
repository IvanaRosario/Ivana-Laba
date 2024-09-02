package com.solvd.laba;

import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.service.StudentManager;
import com.solvd.laba.service.TeacherManager;

import java.util.*;

public class Main {

    public static void main(String[] arg) throws ProfessorIsAlreadyHiredException {
        Degree degree1 = new Degree("Computer Engineering",5);
        Degree degree2 = new Degree("Bachelor on Physics", 5);


        Staff staff1 = new Staff("Lola Flores", 40,"ST0001", "Street 123", "155678934", "Library");

        // Declaración de Profesores
        ProfessorZ professor1 = new ProfessorZ("Juan Perez", 38,"PR0001", "Street 456", "123456789", "Mathematics");
        ProfessorZ professor2 = new ProfessorZ("Pepe Rodriguez", 38,"PR0002", "Street 456", "123456789", "Mathematics");

        // Declaración de Estudiantes
        StudentZ student1 = new StudentZ("Rosario Flores", 20, "ST0001", "Street 789","123543234",degree1);
        StudentZ student2 = new StudentZ("Melina Molina", 26, "ST0002", "Street 321", "123456987", degree2);


        //Declaracion de Materias
        SubjectZ subject1 = new SubjectZ("Calculus");
        SubjectZ subject2 = new SubjectZ("Algebra");

        subject1.assignTeacher(professor1);

        College facet = new College("UNT",Set.of(staff1));

        professor1.academicActivity(subject1);
        professor2.academicActivity(subject2);


        student1.academicActivity(subject1);
        student1.academicActivity(subject2);
        student2.academicActivity(subject1);
        student2.academicActivity(subject2);

        System.out.println("\n" + facet);
        professor1.assignGrade(student1,-1);
        professor1.assignGrade(student2, 100);

        subject1.showStudents();
        subject2.showStudents();
        subject1.showGrades();

        System.out.println("\n------Let's meet the members of the university------");
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

        StudentManager studentManager = College.getStudentManager();
        studentManager.saveStudent(student1, subject2);
        studentManager.saveStudent(student2, subject1);
        studentManager.saveStudent(student1, subject1);
        studentManager.saveStudent(student2, subject2);
        
        teacherManager.saveTeacherListToTXTFile("profs");
        studentManager.saveStudentsListToTXTFile("studs");
        teacherManager.removeProfessorFromCollegeStaff(professor1);

        System.out.println("\n------Entering the library book management system------");
        Library library = new Library(new Book("Calculus I", "Tom M. Apostol", "BM0001"));
        System.out.println(student1 + " has requested a book..." );
        library.lendBook(student1);
    }
}