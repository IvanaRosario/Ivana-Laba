package com.solvd.laba.mysql;

import com.solvd.laba.dao.DAOManager;
import com.solvd.laba.dao.ProfessorDAO;
import com.solvd.laba.dao.StudentDAO;
import com.solvd.laba.dao.SubjectDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOManager implements DAOManager {
    private Connection conn;

    private StudentDAO student = null;
    private SubjectDAO subject = null;
    private ProfessorDAO professor = null;


    public MySQLDAOManager(String username, String password, String database) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
    }

    @Override
    public StudentDAO getStudentDAO() {
        if(student == null) {
            student = new MySQLStudentDAO(conn);
        }
        return student;
    }

    @Override
    public SubjectDAO getsubjectDAO() {
        if(subject == null) {
            subject = new MySQLSubjectDAO(conn);
        }
        return subject;
    }

    @Override
    public ProfessorDAO getProfessorDAO() {
        if(professor == null) {
            professor = new MySQLProfessorDAO(conn);
        }
        return professor;
    }
}
