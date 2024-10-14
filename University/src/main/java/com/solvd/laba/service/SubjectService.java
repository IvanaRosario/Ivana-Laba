package com.solvd.laba.service;


import com.solvd.laba.SubjectZ;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public interface SubjectService {
    void createSubject(SubjectZ subject)throws DAOException ;
    SubjectZ getSubjectById(int id)throws DAOException ;
    void updateSubject(SubjectZ subject)throws DAOException ;
    void deleteSubject(SubjectZ subject)throws DAOException ;
    List<SubjectZ> getAllSubjects() throws DAOException;
}
