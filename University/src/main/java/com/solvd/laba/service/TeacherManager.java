package com.solvd.laba.service;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.exceptions.ProfessorAlreadyAssignedToSubjectException;
import com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import com.solvd.laba.ProfessorZ;
import com.solvd.laba.exceptions.ProfessorNotFoundException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TeacherManager {
    private static final Logger LOGGER = LogManager.getLogger(TeacherManager.class);
    private CustomLinkedList<ProfessorZ> professors = new CustomLinkedList<>();

    public CustomLinkedList<ProfessorZ> getProfessors() {
        return professors;
    }

    public void hireTeacherWithException(ProfessorZ teacher) throws ProfessorIsAlreadyHiredException {
        if (professors.contains(teacher)){
            throw new ProfessorIsAlreadyHiredException("Professor " + teacher.getName() + " is already part of the College staff");
        }
            professors.add(teacher);
            LOGGER.info("Professor {} was hired successfully", teacher.getName());
    }

    public void hireTeacher(ProfessorZ teacher) {
        try {
            hireTeacherWithException(teacher);
        } catch (ProfessorIsAlreadyHiredException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void assignTeacherToSubject(ProfessorZ professor, SubjectZ subject){
        try{
            if (professor.getSubject().equals(subject)){
                throw new ProfessorAlreadyAssignedToSubjectException("Professor " + professor.getName() + "is already assigned to the " + subject.getSubjectName() + " subject");
            }
        } catch(ProfessorAlreadyAssignedToSubjectException e){
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("The teacher has been correctly assigned to the subject {}", subject.getSubjectName());
    }

    public void removeProfessorFromCollegeStaff(ProfessorZ professor){
        try {
            if (!professors.contains(professor)){
                throw new ProfessorNotFoundException("Professor " + professor.getName() + " is not part of the College's Academic Staff");
            }
        } catch (ProfessorNotFoundException e){
            LOGGER.error(e.getMessage());
        }
        professors.remove(professor);
        LOGGER.info("Professor {} was removed from the College's Academic Staff successfully", professor.getName());
    }

    public void saveTeacherListToTXTFile(String fileName) {
        File file = new File(fileName + ".txt");

        try(FileWriter fWriter = new FileWriter(file)) {
            Node<ProfessorZ> current = professors.getHead();
            while (current != null) {
                fWriter.write(current.data.toString() + '\n');
                current = current.next;
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
