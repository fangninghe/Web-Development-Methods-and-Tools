/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        PreparedStatement statement = null;

        String action = request.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("addbooks")) {
                ArrayList<Integer> results = new ArrayList<>();
                Connection conn = establishConnectionJDBC();
                HttpSession session = request.getSession();
                int number = Integer.parseInt(request.getParameter("booknumber"));
                session.setAttribute("totalnumber", number);
                for (int i = 1; i <= number; i++) {

                    String authors = request.getParameter("authors" + String.valueOf(i));
                    authors = authors.replaceAll("[^A-Za-z ]", "").trim();
                    String isbn = request.getParameter("isbn" + String.valueOf(i));
                    isbn = isbn.replaceAll("[^\\dA-Za-z- ]", "").replaceAll("\\s+", "").trim();
                    float price = Float.parseFloat(request.getParameter("price" + String.valueOf(i)).replaceAll("[^\\d.]", "").replaceAll("\\s+", "").trim());

                    String title = request.getParameter("title" + String.valueOf(i));
                    title = title.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim();

                    String query = "insert into books(isbn,title,authors,price)values(?,?,?,?)";

                    statement = conn.prepareStatement(query);
                    statement.setString(1, isbn);
                    statement.setString(2, title);
                    statement.setString(3, authors);
                    statement.setFloat(4, price);

                   
                    try {
                        statement.executeUpdate();
                    } catch (Exception ex) {
                        System.out.println("duplicate");
                        session.setAttribute("yes", "yes");
                        session.setAttribute("reviewtitle", isbn);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddSuccess.jsp");
                        rd.forward(request, response);
                        continue;

                    }
                    int result = statement.executeUpdate();

                    results.add(result);

                }

                boolean flag = true;
                for (int result : results) {
                    if (result <= 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/AddSuccess.jsp");
                    rd.forward(request, response);
                }

            } else if (action.equalsIgnoreCase("return")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Welcome.jsp");
                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Welcome.jsp");
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "asdfg");
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
