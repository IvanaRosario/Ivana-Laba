package com.solvd.laba.service;

import com.solvd.laba.ProfessorZ;
import com.solvd.laba.SubjectZ;
import com.solvd.laba.exceptions.StudentAlreadyEnrolledException;
import com.solvd.laba.StudentZ;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentManager {
    private static final Logger LOGGER = LogManager.getLogger(StudentManager.class);
    private CustomLinkedList<StudentZ> students = new CustomLinkedList<>();

    private void saveStudentWithException(StudentZ student, SubjectZ subject) throws StudentAlreadyEnrolledException {

        if (student.getSubjects().contains(subject)) {
            throw new StudentAlreadyEnrolledException("The student " + student.getName() + " is already enrolled in the " + subject.getSubjectName() + " subject");
        }
        students.add(student);
        LOGGER.info("Student {} was enrolled successfully", student.getName());
    }
    
    public void saveStudent(StudentZ student, SubjectZ subject) {
        try {
           saveStudentWithException(student, subject);
        } catch (StudentAlreadyEnrolledException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void saveStudentsListToTXTFile(String fileName) {
        try(FileWriter fWriter = new FileWriter(fileName + ".txt")) {

            Node<StudentZ> current = students.getHead(); // Acceso directo al primer nodo
            while (current != null) {
                fWriter.write(current.data.toString() + '\n');
                current = current.next; // Avanzar al siguiente nodo
            }
        }
        catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

}
