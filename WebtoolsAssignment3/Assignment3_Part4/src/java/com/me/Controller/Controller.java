/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;

import com.me.bean.MovieBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        Statement statement = null;
        ResultSet resultSet = null;
        String action = request.getParameter("action");
        if (action != null) {
            HttpSession session = request.getSession();
            if (action.equalsIgnoreCase("addmovie")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddMovie.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("return")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/WelcomeView.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("addsuccess")) {
                Connection conn = establishConnectionJDBC();
                String title = request.getParameter("title");
                title = title.replaceAll("[^\\dA-Za-z ]", "").trim();
                String actor = request.getParameter("actor");
                actor = actor.replaceAll("[^\\dA-Za-z ]", "").trim();
                String actress = request.getParameter("actress");
                actress = actress.replaceAll("[^\\dA-Za-z ]", "").trim();
                String genre = request.getParameter("genre");
                genre = genre.replaceAll("[^\\dA-Za-z ]", "").trim();
                int year = Integer.parseInt(request.getParameter("year").replaceAll("[^\\d]", "").replaceAll("\\s+", "").trim());

                String query = "insert into movies values('"
                        + title + "','" + actor + "','" + actress + "','" + genre + "','" + year + "')";
                statement = conn.createStatement();
                
                try {
                        statement.executeUpdate(query);
                    } catch (Exception ex) {
                        System.out.println("duplicate");
                        session.setAttribute("yes", "yes");
                        session.setAttribute("reviewtitle", title);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/addsuccess.jsp");
                        rd.forward(request, response);
                        return;
                        

                    }
                int result = statement.executeUpdate(query);
                if (result > 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/addsuccess.jsp");
                    rd.forward(request, response);
                }
            } else if (action.equalsIgnoreCase("browsemovies")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/SearchMovie.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("searchmoive")) {
                
                String keyword = request.getParameter("searchmovie");
                keyword = keyword.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();
                String keywordcategory = request.getParameter("search");
                request.setAttribute("key", "key:" + keyword);
                MovieBean movie = new MovieBean();

                if (keywordcategory.equalsIgnoreCase("title")) {
                    Connection conn = establishConnectionJDBC();
                    String queryLogin = "select * from movies where title=?";
                    PreparedStatement searchStmt = conn.prepareStatement(queryLogin);
                    searchStmt.setString(1, keyword);
                    resultSet = searchStmt.executeQuery();
                    
                    if (resultSet.next()) {
                        movie.setActor(resultSet.getString("actor"));
                        movie.setActress(resultSet.getString("actress"));
                        movie.setGenre(resultSet.getString("genre"));
                        movie.setName(resultSet.getString("title"));
                        movie.setYear(Integer.parseInt(resultSet.getString("year")));
                    }else{
                        session.setAttribute("none", "none");
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/SearchResult.jsp");
                        rd.forward(request, response);
                        return; 
                    }
                } else if (keywordcategory.equalsIgnoreCase("actor")) {
                    Connection conn = establishConnectionJDBC();
                    String queryLogin = "select * from movies where actor=?";
                    PreparedStatement searchStmt = conn.prepareStatement(queryLogin);
                    searchStmt.setString(1, keyword);
                    resultSet = searchStmt.executeQuery();
                    if (resultSet.next()) {
                        movie.setActor(resultSet.getString("actor"));
                        movie.setActress(resultSet.getString("actress"));
                        movie.setGenre(resultSet.getString("genre"));
                        movie.setName(resultSet.getString("title"));
                        movie.setYear(Integer.parseInt(resultSet.getString("year")));
                    }else{
                        session.setAttribute("none", "none");
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/SearchResult.jsp");
                        rd.forward(request, response);
                        return; 
                    }
                } else if (keywordcategory.equalsIgnoreCase("actress")) {
                    Connection conn = establishConnectionJDBC();
                    String queryLogin = "select * from movies where actress=?";
                    PreparedStatement searchStmt = conn.prepareStatement(queryLogin);
                    searchStmt.setString(1, keyword);
                    resultSet = searchStmt.executeQuery();
                    if (resultSet.next()) {
                        movie.setActor(resultSet.getString("actor"));
                        movie.setActress(resultSet.getString("actress"));
                        movie.setGenre(resultSet.getString("genre"));
                        movie.setName(resultSet.getString("title"));
                        movie.setYear(Integer.parseInt(resultSet.getString("year")));
                    }else{
                        session.setAttribute("none", "none");
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/SearchResult.jsp");
                        rd.forward(request, response);
                        return; 
                    }
                }

                session.setAttribute("keyword", keyword);
                session.setAttribute("movie", movie);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/SearchResult.jsp");
                rd.forward(request, response);
            }

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/WelcomeView.jsp");
            rd.forward(request, response);
        }

    }

    protected Connection establishConnectionJDBC()
            throws IOException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "asdfg");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        }
        return connection;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
