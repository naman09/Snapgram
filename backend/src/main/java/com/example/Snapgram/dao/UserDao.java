package com.example.Snapgram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.Snapgram.exceptions.DatabaseException;
import com.example.Snapgram.models.User;

@Repository
public class UserDao extends BaseDao{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public User creatUser(User user) {
        logger.info("Create user in DB");
        return user;
    }
    private String getNextUserId() throws SQLException {
        String getAutoIdSql = "SELECT COALESCE(MAX(ID), 0) + 1 AS NEXT_ID FROM USERS";
        try(Connection conn = getConnection(); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getAutoIdSql)) {
            
            if (rs.next()) {
                return rs.getString("NEXT_ID");
            }
            throw new DatabaseException("failed to find next id"); 
        }
        
    }
    public User createUser(User user) throws SQLException{
        String nextUserId = getNextUserId();
        user.setId((nextUserId));
        String sql = "INSERT INTO USERS (ID, USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
        try(Connection conn = getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();   
        }
        return user;
    }
    public User getUserById(String userId) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try(Connection conn = getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        }
        return null;
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getString("ID"));
        user.setUsername(rs.getString("USERNAME"));
        user.setEmail(rs.getString("EMAIL"));
        return user;
    }

}
