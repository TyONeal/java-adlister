package com.codeup.adlister.dao;

import com.codeup.adlister.models.Todo;

import java.sql.SQLException;
import java.util.List;

public interface Todos {
    List<Todo> all() throws SQLException;
    Long toggleTodo(boolean status, String name);
}
