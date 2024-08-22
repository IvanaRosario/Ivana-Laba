package main.java.com.solvd.laba;

import java.util.*;

public class Main {
    public static void main(String[] arg) {
        Degree degree1 = new Degree("Computer Engineering",5);
        Degree degree2 = new Degree("Bachelor on Physics", 5);

        Staff staff1 = new Staff("Lola Flores", 40,"ST0001", "Street 123", "155678934", "Library");
        ProfessorZ professor1 = new ProfessorZ("Juan Perez", 38,"PR0001", "Street 456", "123456789", "Mathematics");
        StudentZ student1 = new StudentZ("Rosario Flores", 20, "ST0001", "Street 789","123543234",degree1);
        StudentZ student2 = new StudentZ("Melina Molina", 26, "ST0002", "Street 321", "123456987", degree1);
        SubjectZ subject1 = new SubjectZ("Calculus", professor1);

        College facet = new College("UNT",Set.of(degree1, degree2),
                Set.of(professor1), Set.of(student1,student2),Set.of(staff1));

        professor1.academicActivity(subject1);
        student1.academicActivity(subject1);
        student2.academicActivity(subject1);

        System.out.println("\n" + facet);
        professor1.assignGrade(student1,9); // que coneccion tiene con el otro de la clase subject
        professor1.assignGrade(student2, 10);
        subject1.showStudents();
        subject1.showGrades();

        System.out.println("\n------Let's meet the members of the university------");
        System.out.println("STUDENTS");
        student1.getInformation();
        System.out.println("PROFESSORS");
        professor1.getInformation();
        System.out.println("NON-TEACHING STAFF");
        staff1.getInformation();


        System.out.println("\n------Entering the library book management system------");
        Library library = new Library(new Book("Calculus I", "Tom M. Apostol", "BM0001"));
        System.out.println(student1 + " has requested a book..." );
        library.lendBook(student1);
    }
}