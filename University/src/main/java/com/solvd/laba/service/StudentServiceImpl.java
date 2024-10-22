package com.solvd.laba.service;

import com.solvd.laba.StudentZ;
import com.solvd.laba.dao.StudentDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class StudentServiceImpl implements ServiceLayer<StudentZ>{
    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void create(StudentZ student) throws DAOException {
        studentDAO.insert(student);
    }

    @Override
    public StudentZ getById(int id) throws DAOException {
        return studentDAO.obtain(id);
    }

    @Override
    public void update(StudentZ student) throws DAOException {
        studentDAO.update(student);
    }

    @Override
    public void delete(StudentZ student)throws DAOException {
        studentDAO.delete(student);
    }

    @Override
    public List<StudentZ> getAll() throws DAOException {
        return studentDAO.getAll();
    }
}
