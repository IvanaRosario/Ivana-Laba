package com.solvd.laba.service;

import com.solvd.laba.StudentZ;
import com.solvd.laba.dao.StudentDAO;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private final StudentDAO studentDAO;

    // Constructor para inyectar el DAO
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void createStudent(StudentZ student) throws DAOException {
        studentDAO.insert(student);
    }

    @Override
    public StudentZ getStudentById(int id) throws DAOException {
        return studentDAO.obtain(id);
    }

    @Override
    public void updateStudent(StudentZ student) throws DAOException {
        studentDAO.update(student);
    }

    @Override
    public void deleteStudent(StudentZ student)throws DAOException {
        studentDAO.delete(student);
    }

    @Override
    public List<StudentZ> getAllStudents() throws DAOException {
        return studentDAO.getAll();
    }
}
