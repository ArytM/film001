package com.example.film001.user;

import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class UserLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();


        if (loginDao.validate(email, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            session.setAttribute("name", email);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
















