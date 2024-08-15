package main.java.com.solvd.laba;

import java.util.*;

public class Main {
    public static void main(String[] arg) {
        Degree degree1 = new Degree("Computer Engineering",5);
        Degree degree2 = new Degree("Bachelor on Physics", 5);

        Staff staff1 = new Staff("Lola Flores", 40,"ST0001", "Street 123", "155678934", "Library");
        Professor_Z professor1 = new Professor_Z("Juan Perez", 38,"PR0001", "Street 456", "123456789", "Mathematics");
        Student_Z student1 = new Student_Z("Rosario Flores", 20, "ST0001", "Street 789","123543234",degree1);
        Student_Z student2 = new Student_Z("Melina Molina", 26, "ST0002", "Street 321", "123456987", degree1);
        Subject_Z subject1 = new Subject_Z("Calculus", professor1);

        College facet = new College("UNT",Set.of(degree1, degree2),
                Set.of(professor1), Set.of(student1,student2),Set.of(staff1));

        professor1.academicActivity(subject1);
        student1.academicActivity(subject1);
        student2.academicActivity(subject1);

        System.out.println("\n" + facet);
        professor1.gradeStudentExam(student1,9); // que coneccion tiene con el otro de la clase subject
        professor1.gradeStudentExam(student2, 10);
        subject1.showStudents();
        subject1.showGrades();

        Library library = new Library(new Book("Calculus I", "Tom M. Apostol", "BM0001"));
        System.out.println(student1 + " has requested a book..." );
        library.lendBook(student1);
    }
}