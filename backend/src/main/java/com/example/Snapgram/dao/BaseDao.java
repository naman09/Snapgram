package com.example.Snapgram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private final String jdbcUrl = "jdbc:h2:file:./database/store/db1";
    private final String username = "sa";
    private final String password = "password";

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
