package com.solvd.laba.service;

import com.solvd.laba.ProfessorZ;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public interface ProfessorService {
    void createProfessor(ProfessorZ professor)throws DAOException;
    ProfessorZ getProfessorById(int id)throws DAOException;
    void updateProfessor(ProfessorZ professor)throws DAOException;
    void deleteProfessor(ProfessorZ professor)throws DAOException;
    List<ProfessorZ> getAllProfessors()throws DAOException;
}
