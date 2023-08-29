package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/users/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password")
        );

        Users usersDao = DaoFactory.getUsersDao();
        System.out.println("before try-catch in servlet");
        try {
            User userCreated = usersDao.insert(user);
            System.out.printf("User created: %s%n", userCreated.getUsername());
            response.sendRedirect("/login");
            return;
        } catch (SQLException e) {
            response.sendRedirect("/register");
            return;
        }

        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to the login page
    }
}
