package com.solvd.laba.mysql;

import com.solvd.laba.ProfessorZ;
import com.solvd.laba.dao.ProfessorDAO;
import com.solvd.laba.enums.TeacherCategory;
import com.solvd.laba.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLProfessorDAO implements ProfessorDAO {
    final String INSERT = "INSERT INTO professor (name, age, address, phone_number, departament, category, subject_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE professor SET subject_id = ? WHERE professor_id = ?";
    final String DELETE = "DELETE FROM professor WHERE professor_id = ?";
    final String GETALL = "SELECT * FROM professor LIMIT 100";
    final String OBTAIN = "SELECT * FROM professor WHERE professor_id = ?";

    private Connection conn;

    public MySQLProfessorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(ProfessorZ prf) throws DAOException{

        try(PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, prf.getName());
            pstmt.setInt(2, prf.getAge());
            pstmt.setString(3, prf.getAddress());
            pstmt.setString(4, prf.getPhoneNumb());
            pstmt.setString(5, prf.getDepartment());
            pstmt.setString(6, prf.getTeacherCategory().toString());
            pstmt.setInt(5, prf.getSubject().getSubjectId());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

            try(ResultSet rset= pstmt.getGeneratedKeys()) {
                if(rset.next()) {
                    prf.setPersonID(rset.getInt(1));
                } else {
                    throw new DAOException("Can't assign ID to this Professor");
                }
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void delete(ProfessorZ prf) throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, prf.getPersonID());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void update(ProfessorZ prf) throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, prf.getSubject().getSubjectId());
            pstmt.setInt(2, prf.getPersonID());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<ProfessorZ> getAll() throws DAOException {
        List<ProfessorZ> professors = new ArrayList<>();

        try(PreparedStatement pstmt = conn.prepareStatement(GETALL); ResultSet rset = pstmt.executeQuery()) {

            while(rset.next()) {
                professors.add(convert(rset));
            }

        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }

        return professors;
    }

    @Override
    public ProfessorZ obtain(Integer id) throws DAOException{
        ProfessorZ prf = null;

        try(PreparedStatement pstmt = conn.prepareStatement(OBTAIN)) {
            pstmt.setInt(1, id);

            try(ResultSet rset = pstmt.executeQuery()) {
                if(rset.next()) {
                    prf = convert(rset);
                } else {
                    throw new DAOException("Record not found");
                }
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
        return prf;
    }

    private ProfessorZ convert(ResultSet rset) throws SQLException{
        String name = rset.getString("name");
        int age = rset.getInt("age");
        String address = rset.getString("address");
        String phoneNum = rset.getString("phone_number");
        String department = rset.getString("departament");
        String category = rset.getString("category");
        TeacherCategory categ = TeacherCategory.valueOf(category);

        ProfessorZ prf = new ProfessorZ(name, age, address, phoneNum, department, categ);
        return prf;
    }
}
