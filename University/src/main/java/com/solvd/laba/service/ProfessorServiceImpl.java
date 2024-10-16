package com.solvd.laba.service;

import com.solvd.laba.ProfessorZ;
import com.solvd.laba.dao.ProfessorDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class ProfessorServiceImpl implements ServiceLayer<ProfessorZ>{
    private final ProfessorDAO professorDAO;

    public ProfessorServiceImpl(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    @Override
    public void create(ProfessorZ professor) throws DAOException {
        professorDAO.insert(professor);
    }

    @Override
    public ProfessorZ getById(int id) throws DAOException {
        return professorDAO.obtain(id);
    }

    @Override
    public void update(ProfessorZ professor) throws DAOException {
        professorDAO.update(professor);
    }

    @Override
    public void delete(ProfessorZ professor) throws DAOException {
        professorDAO.delete(professor);
    }

    @Override
    public List<ProfessorZ> getAll() throws DAOException {
        return professorDAO.getAll();
    }
}
