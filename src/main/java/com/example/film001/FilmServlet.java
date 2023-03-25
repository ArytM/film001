package com.example.film001;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/index")
public class FilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FilmDao filmDao;

    public void init() {
        filmDao = new FilmDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertFilm(request, response);
                    break;
                case "/delete":
                    deleteFilm(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateFilm(request, response);
                    break;
                default:
                    listFilm(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFilm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Film> listFilm = filmDao.getAllFilm();
        request.setAttribute("listFilm", listFilm);
        RequestDispatcher dispatcher = request.getRequestDispatcher("film-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("film-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Film existingFilm = filmDao.getFilm(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("film-form.jsp");
        request.setAttribute("film", existingFilm);
        dispatcher.forward(request, response);
    }

    private void insertFilm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String rating = request.getParameter("rating");
        String comment = request.getParameter("comment");
        Film newFilm = new Film(name, year, rating, comment);
        filmDao.saveFilm(newFilm);
        response.sendRedirect("list");
    }

    private void updateFilm (HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String rating = request.getParameter("rating");
        String comment = request.getParameter("comment");

        Film film = new Film(id, name, year, rating, comment);
        filmDao.updateFilm(film);
        response.sendRedirect("list");
    }

    private void deleteFilm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        filmDao.deleteFilm(id);
        response.sendRedirect("list");
    }
}













