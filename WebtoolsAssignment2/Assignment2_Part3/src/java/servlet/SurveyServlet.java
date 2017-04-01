/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class SurveyServlet extends HttpServlet {

    public void init() {
        System.out.println("INIT CALLED");
    }

    public void destroy() {
        System.out.println("DESTROY CALLED");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Family Survey</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        out.println("<script  type = \"text/javascript\">  function number(){ "
                + "var pattern = /^[0-9]*$/;"
                + "var children = document.getElementById(\"children\").value;"
                + "if(children.match(pattern)){"
                + " var number = parseInt(children);"
                + " var inner = \"<input type='hidden' name='name' value='\" + number + \"'><br/>\";"
                + " for (var i = 1; i <= number; i++) {"
                + " var childrenname = \"Please Enter the name of your children \" + i + \"<br/>\";"
                + "var childrenid = \"<input type = 'text' name ='child\" + i + \"'><br/>\";"
                + "inner += childrenname + childrenid;}"
                + "var div = document.getElementById(\"name\");"
                + "div.innerHTML = inner;"
                + " document.getElementById(\"question\").style.display = \"none\";"
                + " document.getElementById(\"form\").style.display = \"block\";}"
                + "else{alert(\"The number is invalid!\");}}"
                + "function test(){var children = document.getElementById(\"children\").value;"
                + "var number = parseInt(children); var pattern = /^[A-Za-z]*$/;"
                + "var check = true;for(var i=1; i <= number; i++){var n = document.getElementById(\"child\" + i).value;"
                + "if( n == \" \" || n == null){alert(\"empty\");check = false;}else if(!n.match(pattern)){"
                + "alert(\"invalid\");check = false;}}return check;}"
                + " </script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form  id = \"form\" action = \"survey.htm\" method = \"post\" style = \"display : none\" > "
                + "<div id = \"name\" name = \"name\" > </div > "
                + "<input  type = \"submit\" name =\"submit\" value = \"Submit Query\" id = \"submit\" onclick = \"return test();\" > </form > "
                + "<div  id = \"question\" name = \"question\" style = \"display : block\" > "
                + "How many children do you  have ?"
                + "<input  type = \"text\" name =\"children\"  id = \"children\" value = \"\" style = \"height:23px; width:200px; border-color: black;\" > <br/> <br/>"
                + " <button  name = \"children\" onclick = \"number()\" > Submit Query</button > </div> ");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        int number = Integer.parseInt(request.getParameter("name"));
        

        out.println("<html>");
        out.println("<body>");
        out.println("<p>Your Children`s names are:<br/><p3>");
        for(int i = 1 ; i<= number; i++){
            String child = request.getParameter("child" +String.valueOf(i));
            out.println(child + "<br/>");
        }
       
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
