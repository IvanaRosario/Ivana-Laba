package com.solvd.laba.mysql;

import com.solvd.laba.StudentZ;
import com.solvd.laba.dao.StudentDAO;
import com.solvd.laba.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLStudentDAO implements StudentDAO {
    final String INSERT = "INSERT INTO student (name, age, address, phone_number, degree_id) VALUES(?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE student SET degree_id = ? WHERE student_id = ?";
    final String DELETE = "DELETE FROM student WHERE student_id = ?";
    final String GETALL = "SELECT * FROM student LIMIT 100";
    final String OBTAIN = "SELECT * FROM student WHERE student_id = ?";

    private Connection conn;

    public MySQLStudentDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(StudentZ std) throws DAOException {
        try(PreparedStatement pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, std.getName());
            pstmt.setInt(2, std.getAge());
            pstmt.setString(3, std.getAddress());
            pstmt.setString(4, std.getPhoneNumb());
            pstmt.setInt(5, std.getDegreeID());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

           try(ResultSet rset = pstmt.getGeneratedKeys()) {
               if(rset.next()) {
                   std.setPersonID(rset.getInt(1));
               } else {
                   throw new DAOException("Can't assign ID to this student");
               }
           }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void update(StudentZ std) throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {
            pstmt.setInt(1, std.getDegree().getDegreeID());
            pstmt.setInt(2, std.getPersonID());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }

        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public void delete(StudentZ std)  throws DAOException{
        try(PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, std.getPersonID());

            if(pstmt.executeUpdate() == 0) {
                throw new DAOException("Error. It may not have been saved");
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }
    }

    @Override
    public List<StudentZ> getAll() throws DAOException{
        List<StudentZ> students = new ArrayList<>();

        try(PreparedStatement pstmt = conn.prepareStatement(GETALL); ResultSet rset = pstmt.executeQuery()) {
            while(rset.next()) {
                students.add(convert(rset));
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }

        return students;
    }

    @Override
    public StudentZ obtain(Integer id)throws DAOException {

        StudentZ std = null;

        try(PreparedStatement pstmt = conn.prepareStatement(OBTAIN)) {
            pstmt.setInt(1, id);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    std = convert(rset);
                } else {
                    throw new DAOException("Record not found");
                }
            }
        } catch(SQLException e) {
            throw new DAOException("Error in SQL", e);
        }

        return std;
    }

    private StudentZ convert(ResultSet rset) throws SQLException{
        String name = rset.getString("name");
        int age = rset.getInt("age");
        String address = rset.getString("address");
        String phoneNum = rset.getString("phone_number");
        int degreID = rset.getInt("degree_id");

        StudentZ std = new StudentZ(name, age, address, phoneNum, degreID);
        return std;
    }



}



