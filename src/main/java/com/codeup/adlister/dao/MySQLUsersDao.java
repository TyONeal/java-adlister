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
    public User findByUsername(String username) throws SQLException {
            String sql = "SELECT * FROM users WHERE username = ?";

            PreparedStatement stmt = null;
             stmt = connection.prepareStatement(sql);
             stmt.setString(1, username);
             ResultSet rs = stmt.executeQuery();
             rs.next();

             return extractUser(rs);

    }

    public User findById(long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = null;
        stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return extractUser(rs);
    }

    @Override
    public User insert(User user) throws SQLException {
        String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return findById(rs.getLong(1));

    }

    private User extractUser(ResultSet rs) throws SQLException {
        System.out.println("Inside extractUser");
        System.out.println(rs.getLong("id"));
        return new User(
        rs.getLong("id"),
        rs.getString("username"),
        rs.getString("email"),
        rs.getString("password")
        );
    }
}
