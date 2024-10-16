package com.solvd.laba.mysql;

import com.solvd.laba.SubjectZ;
import com.solvd.laba.dao.SubjectDAO;
import com.solvd.laba.enums.SubjectPeriod;
import com.solvd.laba.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSubjectDAO implements SubjectDAO {
    final String INSERT = "INSERT INTO subject (name, period) VALUES(?, ?)";
    final String UPDATE = "UPDATE subject SET period = ? WHERE subject_id = ?";
    final String DELETE = "DELETE FROM subject WHERE subject_id = ?";
    final String GETALL = "SELECT * FROM subject LIMIT 70";
    final String OBTAIN = "SELECT * FROM subject WHERE subject_id = ?";

    private Connection conn;

    public MySQLSubjectDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(SubjectZ sbj) throws DAOException{

        try(PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
            pstmt.setString(1, sbj.getSubjectName());
            pstmt.setString(2, sbj.getSubjectPeriod().toString());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

            try(ResultSet rset = pstmt.getGeneratedKeys()) {
                if(rset.next()) {
                    sbj.setSubjectId((rset.getInt(1)));
                } else {
                    throw new DAOException("Can't assign ID to this student");
                }
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void delete(SubjectZ sbj) throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, sbj.getSubjectId());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void update(SubjectZ sbj) throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setString(1, sbj.getSubjectPeriod().toString());
            pstmt.setInt(2, sbj.getSubjectId());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<SubjectZ> getAll() throws DAOException{
        List<SubjectZ> subjects = new ArrayList<>();

        try(PreparedStatement pstmt = conn.prepareStatement(GETALL); ResultSet rset = pstmt.executeQuery()) {

            while(rset.next()) {
                subjects.add(convert(rset));
            }

        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }

        return subjects;
    }

    @Override
    public SubjectZ obtain(Integer id) throws DAOException{
        SubjectZ sbj = null;

        try(PreparedStatement pstmt = conn.prepareStatement(OBTAIN);  ResultSet rset = pstmt.executeQuery()) {
            pstmt.setInt(1, id);
            if(rset.next()) {
                sbj = convert(rset);
            } else {
                throw new DAOException("Record not found");
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }

        return sbj;
    }

    private SubjectZ convert(ResultSet rset) throws SQLException{
        String name = rset.getString("name");
        String period = rset.getString("period");
        SubjectPeriod subPeriod = SubjectPeriod.valueOf(period);

        SubjectZ sbj = new SubjectZ(name, subPeriod);
        return sbj;
    }
}
