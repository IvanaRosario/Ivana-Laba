package com.solvd.laba.service;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.dao.SubjectDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class SubjectServiceImpl implements SubjectService{
    private final SubjectDAO subjectDAO;

    public SubjectServiceImpl(SubjectDAO subjectDAO) throws DAOException {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public void createSubject(SubjectZ subject) throws DAOException {
        subjectDAO.insert(subject);
    }

    @Override
    public SubjectZ getSubjectById(int id) throws DAOException {
        return subjectDAO.obtain(id);
    }

    @Override
    public void updateSubject(SubjectZ subject) throws DAOException {
        subjectDAO.update(subject);
    }

    @Override
    public void deleteSubject(SubjectZ subject) throws DAOException {
        subjectDAO.delete(subject);
    }

    @Override
    public List<SubjectZ> getAllSubjects() throws DAOException {
        return subjectDAO.getAll();
    }
}

