package main.java.com.solvd.laba.service;

import main.java.com.solvd.laba.SubjectZ;
import main.java.com.solvd.laba.exceptions.StudentAlreadyEnrolledException;
import main.java.com.solvd.laba.StudentZ;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentManager {
    private static final Logger LOGGER = LogManager.getLogger(StudentManager.class);
    private List<StudentZ> students = new ArrayList<>();

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
            for(StudentZ std : students) {
                fWriter.write(std.toString() +'\n');
            }
        }
        catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

}
