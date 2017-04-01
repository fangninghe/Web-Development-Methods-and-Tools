<%-- 
    Document   : home.jsp
    Created on : May 28, 2016, 2:35:38 PM
    Author     : Alex
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="me.neu.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to AAA</title>
        <script language="javascript">
        </script>
    </head>
    <body>
        <div>
            <div id="right"  style=" float:right; width:90%">
                <%
                    String taskValue = (String) request.getAttribute("task");
                    if (taskValue != null) {
                        double sum = 0;
                        if (taskValue.equalsIgnoreCase("showBooks")) {
                            ArrayList<Product> outputBooks = (ArrayList<Product>) request.getAttribute("outputBooks");

                            out.println("<form method='post' action='addProduct.htm'>");
                            out.println("<h2> All the Books </h2>");
                           
                            out.println("<hr />");
                            for (Product book : outputBooks) {
                                String bookname = book.getName();
                                String price = String.valueOf(book.getPrice());

                                out.println("<input type='checkbox' name='product' value='" + bookname + "'/>" + bookname + "[$" + price + "]<br />");
                            }
                            out.println("<input type='hidden' name='action' value='addProduct'/>");
                            out.println("<input type='submit' value='Add Selected Product'/>");
                            out.println("<input type='submit' value='view product'/>");
                            out.println("</form>");
                        } else if (taskValue.equalsIgnoreCase("showMusic")) {
                            ArrayList<Product> outputMusic = (ArrayList<Product>) request.getAttribute("outputMusic");

                            out.println("<form method='post' action='addProduct.htm'>");
                            out.println("<h2> All the Music </h2>");
                            out.println("<hr />");
                            for (Product music : outputMusic) {
                                String musicname = music.getName();
                                String price = String.valueOf(music.getPrice());

                                out.println("<input type='checkbox' name='product' value='" + musicname + "'/>" + musicname + "[$" + price + "]<br />");
                            }
                            out.println("<input type='hidden' name='action' value='addProduct'/>");
                            out.println("<input type='submit' value='Add Selected Product'/>");
                            out.println("<input type='submit' value='view product'/>");
                            out.println("</form>");
                        } else if (taskValue.equalsIgnoreCase("showComputer")) {
                            ArrayList<Product> outputMusic = (ArrayList<Product>) request.getAttribute("outputComputers");

                            out.println("<form method='post' action='addProduct.htm'>");
                            out.println("<h2> All the Computer </h2>");
                            out.println("<hr />");
                            for (Product computer : outputMusic) {
                                String computername = computer.getName();
                                String price = String.valueOf(computer.getPrice());

                                out.println("<input type='checkbox' name='product' value='" + computername + "'/>" + computername + "[$" + price + "]<br />");
                            }
                            out.println("<input type='hidden' name='action' value='addProduct'/>");
                            out.println("<input type='submit' value='Add Selected Product'/>");
                            out.println("<input type='submit' value='view product'/>");
                            out.println("</form>");
                        } else if (taskValue.equalsIgnoreCase("myProduct")) {
                            ArrayList<Product> outputProduct = (ArrayList<Product>) session.getAttribute("outputProduct");
                            
                            out.println("<h3>Your shopping Cart:</h3>");
                            out.println("<hr />");
                            if (outputProduct.isEmpty()) {
                                out.println("No Product");
                            } else {
                                int i = 1; 
                                
                                for (Product product : outputProduct) {
                                    
                                    String name = product.getName();
                                    String price = String.valueOf(product.getPrice());
                                    sum += product.getPrice();
                                    out.println("<h3>" + i + "." + name + "  :   " + "$" + price + "</h3>" + "["+"<a href='addProduct.htm?removename="+name+"&action=remove'> Remove this from cart</a>" + "]");
                                    i++;
                                }
                            }
                            out.println("<hr />");
                            out.print("<h2>Total" + "$" + sum + "</h2>");
                        }
                    }
                %>

            </div>
            <div id="left" style=" width: 10%">
                <a href="showBooks.htm?action=showBooks">Books</a><br/>
                <a href="showMusic.htm?action=showMusic">Music</a><br/>
                <a href="showComputer.htm?action=showComputer">Computers</a><br/>


            </div>
        </div
    </body>
</html>
