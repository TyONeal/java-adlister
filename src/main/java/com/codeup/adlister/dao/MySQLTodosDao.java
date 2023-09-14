package com.codeup.adlister.dao;

import com.codeup.adlister.models.Todo;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTodosDao implements Todos {
    private Connection connection = null;

    public MySQLTodosDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public List<Todo> all() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM todos_db.todos");
        ResultSet rs = statement.executeQuery();
        return createTodosFromResults(rs);
    }

    @Override
    public Long toggleTodo(boolean status, String name) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE todos_db.todos SET isComplete = ? WHERE name = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setBoolean(1, status);
            stmt.setString(2, name);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
            return rs.getLong(1);
            } else return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Todo extractTodo(ResultSet rs) throws SQLException {
         return new Todo(
                rs.getString("name"),
                rs.getBoolean("isComplete")
        );
    }

    public List<Todo> createTodosFromResults(ResultSet rs) throws SQLException {
        List<Todo> todos = new ArrayList<>();
        while(rs.next()) {
            todos.add(extractTodo(rs));
        }
        return todos;
    }
}
