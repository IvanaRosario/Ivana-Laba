package com.solvd.laba.service;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public interface ServiceLayer<T> {
    void create(T t)throws DAOException;
    T getById(int id)throws DAOException ;
    void update(T t)throws DAOException ;
    void delete(T t)throws DAOException ;
    List<T> getAll() throws DAOException;
}
