/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.neu.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.neu.model.Product;

/**
 *
 * @author Alex
 */
public class ProductController extends HttpServlet {

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
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if (action != null) {
            List<Product> productList = ProductDB.getAvailableProduct();
            if (action.equalsIgnoreCase("showBooks")) {
                List<Product> bookList = new ArrayList<>();
                for (Product p : productList) {
                    if ("book".equals(p.getCategory())) {
                        bookList.add(p);

                    }
                }

                request.setAttribute("outputBooks", bookList);
                request.setAttribute("task", "showBooks");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("showMusic")) {
                List<Product> musicList = new ArrayList<>();
                for (Product p : productList) {
                    if ("music".equals(p.getCategory())) {
                        musicList.add(p);
                    }
                }
                request.setAttribute("outputMusic", musicList);
                request.setAttribute("task", "showMusic");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("showComputer")) {
                List<Product> computerList = new ArrayList<>();
                for (Product p : productList) {
                    if ("computer".equals(p.getCategory())) {
                        computerList.add(p);
                    }
                }
                request.setAttribute("outputComputers", computerList);
                request.setAttribute("task", "showComputer");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("addProduct")) {
                HttpSession session = request.getSession();
                ArrayList<Product> myProduct;
                if (null != session.getAttribute("outputProduct")) {
                    myProduct = (ArrayList<Product>) session.getAttribute("outputProduct");

                } else {
                    myProduct = new ArrayList<Product>();
                }

                String[] selectedProduct = request.getParameterValues("product");
                if (selectedProduct != null) {
                    for (int i = 0; i < selectedProduct.length; i++) {
                        for (Product product : productList) {
                            if (product.getName().equals(selectedProduct[i])) {
                                if (!myProduct.contains(product)) {
                                    myProduct.add(product);
                                }

                            }
                        }
                    }
                }
                session.setAttribute("outputProduct", myProduct);
                request.setAttribute("task", "myProduct");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("remove")) {
                HttpSession session = request.getSession();
                List<Product> newproductList = (List<Product>) session.getAttribute("outputProduct");
                try {
                    for (Product p : newproductList) {
                        if (p.getName().equals(request.getParameter("removename"))) {
                            newproductList.remove(p);
                        }
                    }
                }catch(Exception ex){
                    
                }

                session.setAttribute("outputProduct", newproductList);
                request.setAttribute("task", "myProduct");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
                rd.forward(request, response);
            }else if(action.equalsIgnoreCase("viewProduct")){
                
            }

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
            rd.forward(request, response);
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
