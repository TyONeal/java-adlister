package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import config.Config;


import java.sql.*;

public class MySQLUsersDao implements Users{

    private Connection connection = null;
    public MySQLUsersDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to Database!", e);
        }
    }
    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = " + username;
        PreparedStatement stmt = null;
        try{
             stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to find user!", e);
        }
    }

    @Override
    public Long insert(User user) {
        String sql = createInsertQuery(user);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new User", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
        rs.getLong("id"),
        rs.getString("username"),
        rs.getString("email"),
        rs.getString("password")
        );
    }

    private String createInsertQuery(User user) {
        return "INSERT INTO users(username, email, password) VALUES ("
                + user.getUsername() +", "
                + user.getEmail() +", "
                + user.getPassword() + ")";
    }
}
