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

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/ads");
            return;
        }
        request.getRequestDispatcher("/users/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("at button press");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Users usersDao = DaoFactory.getUsersDao();
        User searchedUser = null;
        System.out.println("after getusersdao");

        try {
            searchedUser = usersDao.findByUsername(username);
            System.out.println(searchedUser);
            System.out.println("inside try-catch after findbyUser");
        } catch (SQLException e) {
            response.sendRedirect("/login");
            return;
        }
        System.out.println("after/outside of try-catch");
        if (searchedUser == null) {
            response.sendRedirect("/login");
            System.out.println("searchedUser is null");
            return;
        }

        if (searchedUser.getPassword().equals(password)) {
            request.getSession().setAttribute("user", searchedUser);
            response.sendRedirect("/ads");
            return;
        } else {
            System.out.println("pass doesn't match");
            response.sendRedirect("/login");
            return;
        }


        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database

        // TODO: store the logged in user object in the session, instead of just the username
    }
}
