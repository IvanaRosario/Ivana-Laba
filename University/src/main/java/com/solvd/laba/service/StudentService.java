package com.solvd.laba.service;

import com.solvd.laba.StudentZ;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public interface StudentService {
    void createStudent(StudentZ student) throws DAOException;
    StudentZ getStudentById(int id)throws DAOException;
    void updateStudent(StudentZ student) throws DAOException;
    void deleteStudent(StudentZ student) throws DAOException;
    List<StudentZ> getAllStudents() throws DAOException;

}
