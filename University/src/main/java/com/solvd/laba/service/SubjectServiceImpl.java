package com.solvd.laba.service;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.dao.SubjectDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class SubjectServiceImpl implements ServiceLayer<SubjectZ>{
    private final SubjectDAO subjectDAO;

    public SubjectServiceImpl(SubjectDAO subjectDAO) throws DAOException {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public void create(SubjectZ subject) throws DAOException {
        subjectDAO.insert(subject);
    }

    @Override
    public SubjectZ getById(int id) throws DAOException {
        return subjectDAO.obtain(id);
    }

    @Override
    public void update(SubjectZ subject) throws DAOException {
        subjectDAO.update(subject);
    }

    @Override
    public void delete(SubjectZ subject) throws DAOException {
        subjectDAO.delete(subject);
    }

    @Override
    public List<SubjectZ> getAll() throws DAOException {
        return subjectDAO.getAll();
    }
}

