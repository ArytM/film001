package com.example.film001.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("userEmail");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;

        if (firstName == null || firstName.equals("")) {
            dispatcher = request.getRequestDispatcher("error-registration-user.jsp");
            dispatcher.forward(request, response);

        }

        if (lastName == null || lastName.equals("")) {
            dispatcher = request.getRequestDispatcher("error-registration-user.jsp");
            dispatcher.forward(request, response);

        }
        if (email == null || email.equals("")) {
            dispatcher = request.getRequestDispatcher("error-registration-user.jsp");
            dispatcher.forward(request, response);

        }
        if (password == null || password.equals("")) {
            dispatcher = request.getRequestDispatcher("error-registration-user.jsp");
            dispatcher.forward(request, response);

        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userDao.saveUser(user);

        dispatcher = request.getRequestDispatcher("registration-success.jsp");
        dispatcher.forward(request, response);

    }


}