package com.solvd.laba.dao;

public interface DAOManager {
    StudentDAO getStudentDAO();

    SubjectDAO getsubjectDAO();

    ProfessorDAO getProfessorDAO();
}
