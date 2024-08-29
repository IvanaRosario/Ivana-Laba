package main.java.com.solvd.laba.service;

import main.java.com.solvd.laba.SubjectZ;
import main.java.com.solvd.laba.exceptions.ProfessorAlreadyAssignedToSubjectException;
import main.java.com.solvd.laba.exceptions.ProfessorIsAlreadyHiredException;
import main.java.com.solvd.laba.ProfessorZ;
import main.java.com.solvd.laba.exceptions.ProfessorNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
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
        try(FileWriter fWriter = new FileWriter(fileName + ".txt")) {

            Node<ProfessorZ> current = professors.getHead(); // Acceso directo al primer nodo
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
