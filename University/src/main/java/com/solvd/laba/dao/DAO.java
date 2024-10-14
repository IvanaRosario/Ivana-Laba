package com.solvd.laba.dao;

import com.solvd.laba.exceptions.DAOException;

import java.util.List;

public interface DAO<T, K> {
    void insert(T t) throws DAOException;
    void delete(T t) throws DAOException;
    void update(T t) throws DAOException;
    List<T> getAll() throws DAOException;
    T obtain(K id) throws DAOException;
}
