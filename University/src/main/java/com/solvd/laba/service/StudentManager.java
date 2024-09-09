package com.solvd.laba.service;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.exceptions.StudentAlreadyEnrolledException;
import com.solvd.laba.StudentZ;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentManager {
    private static final Logger LOGGER = LogManager.getLogger(StudentManager.class);
    private CustomLinkedList<StudentZ> students = new CustomLinkedList<>();

    private void saveStudentWithException(StudentZ student, SubjectZ subject) throws StudentAlreadyEnrolledException {

        if (student.getSubjects().contains(subject)) {
            throw new StudentAlreadyEnrolledException("The student " + student.getName() +
                    " is already enrolled in the " + subject.getSubjectName() + " subject");
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

    public CustomLinkedList<StudentZ> getStudents() {
        return students;
    }

    public void setStudents(StudentZ students) {
        this.students.add(students);
    }

    public void saveStudentsListToTXTFile(String fileName) {
        File file = new File(fileName + ".txt");

        try(FileWriter fWriter = new FileWriter(file)) {
            Node<StudentZ> current = students.getHead(); // Acceso directo al primer nodo
            while (current != null) {
                fWriter.write(current.data.toString() + '\n');
                current = current.next; // Avanzar al siguiente nodo
            }
        }
        catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            countUniqueWordsInFile(file);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


    public void countUniqueWordsInFile(File file) throws IOException {
        Set<String> uniqueWords = new TreeSet<>();

        List<String> lines = FileUtils.readLines(file, "UTF-8");
        for (String line : lines) {
            String[] words = StringUtils.split(line, " \t\n\r\f.,;:!?");
            for (String word : words) {
                if (StringUtils.isNotBlank(word)) {
                    uniqueWords.add(word.toLowerCase());
                }
            }
        }
        FileUtils.writeLines(file, "UTF-8", List.of("\n--- Unique Words ---"), true);
        FileUtils.writeLines(file, "UTF-8", uniqueWords, true);
    }
}
