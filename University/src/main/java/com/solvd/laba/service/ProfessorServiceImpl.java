package com.solvd.laba.service;

import com.solvd.laba.ProfessorZ;
import com.solvd.laba.dao.ProfessorDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class ProfessorServiceImpl implements ProfessorService{
    private final ProfessorDAO professorDAO;

    public ProfessorServiceImpl(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    @Override
    public void createProfessor(ProfessorZ professor) throws DAOException {
        professorDAO.insert(professor);
    }

    @Override
    public ProfessorZ getProfessorById(int id) throws DAOException {
        return professorDAO.obtain(id);
    }

    @Override
    public void updateProfessor(ProfessorZ professor) throws DAOException {
        professorDAO.update(professor);
    }

    @Override
    public void deleteProfessor(ProfessorZ professor) throws DAOException {
        professorDAO.delete(professor);
    }

    @Override
    public List<ProfessorZ> getAllProfessors() throws DAOException {
        return professorDAO.getAll();
    }
}
