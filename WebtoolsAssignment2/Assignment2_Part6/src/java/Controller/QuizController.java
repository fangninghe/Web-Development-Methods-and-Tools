/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class QuizController extends HttpServlet {

    String Option1;
    String Option2;
    String Option3;
    String Option4;
    String Option5;
    String Option6;
    String Option7;
    String Option8;
    String Option9;
    String Option10;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        sendPage1(response,request); 
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
        String page = request.getParameter("page");
        
        if (page == null){
            sendPage1(response,request);
            return; 
        }
        if (page.equals("1")){
            sendPage2(response,request);
        }else if (page.equals("2")){
            sendPage3(response,request);
        }else if (page.equals("3")){
            sendPage4(response,request);
        }else if (page.equals("4")){
            sendPage5(response,request);
        }else if (page.equals("5")){
            sendPage6(response,request);
        }else if (page.equals("6")){
            sendPage7(response,request);
        }else if (page.equals("7")){
            sendPage8(response,request);
        }else if (page.equals("8")){
            sendPage9(response,request);
        }else if (page.equals("9")){
            sendPage10(response,request);
        }else if(page.equals("10")){
            displayValues(response,request);
        }
        
    }
    void sendPage1(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 1</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 1</H2>");
        out.println("Question1: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q1' value='AAAA' />AAAA</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q1' value='BBBB' />BBBB</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q1' value='CCCC' />CCCC</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q1' value='DDDD' />DDDD</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=1>"); 
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }    
    void sendPage2(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option1 = request.getParameter("q1");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 2</H2>");
        out.println("Question2:<BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q2' value='aaaa' />aaaa</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q2' value='bbbb' />bbbb</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q2' value='cccc' />cccc</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q2' value='dddd' />dddd</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=2>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage3(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option2 = request.getParameter("q2");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 3</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 3</H2>");
        out.println("Question3:<BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q3' value='aaaa' />aaaa</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q3' value='cccc' />cccc</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q3' value='ssss' />ssss</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q3' value='ffff' />ffff</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=3>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    void sendPage4(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option3 = request.getParameter("q3");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 4</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 4</H2>");
        out.println("Question4: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q4' value='asdf' />asdf</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q4' value='qwer' />qwer</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q4' value='aaaa' />aaaa</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q4' value='cccc' />cccc</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=4>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
    void sendPage5(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option4 = request.getParameter("q4");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 5</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 5</H2>");
        out.println("Question5:<BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q5' value='ssss' />ssss</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q5' value='cccc' />cccc</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q5' value='vvvv' />vvvv</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q5' value='ffff' />ffff</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=5>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage6(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option5 = request.getParameter("q5");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 6</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 6</H2>");
        out.println("Question6: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q6' value='ssss' />ssss</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q6' value='cccc' />cccc</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q6' value='ffff' />ffff</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q6' value='eeee' />eeee</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=6>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage7(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option6 = request.getParameter("q6");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 7</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 7</H2>");
        out.println("Question7: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q7' value='eeee' />eeee</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q7' value='vvvv' />vvvv</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q7' value='dddd' />dddd</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q7' value='qqqq' />qqqq</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=7>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage8(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option7 = request.getParameter("q7");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 8</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 8</H2>");
        out.println("Question8: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q8' value='ffff' />ffff</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q8' value='vvvv' />vvvv</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q8' value='bbbb' />bbbb</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q8' value='nnnn' />nnnn</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=8>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage9(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option8 = request.getParameter("q8");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 9</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 9</H2>");
        out.println("Question9: <BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q9' value='eeee' />eeee</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q9' value='vvvv' />vvvv</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q9' value='qqqq' />qqqq</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q9' value='wwww' />wwww</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=9>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void sendPage10(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option9 = request.getParameter("q9");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Page 10</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Page 10</H2>");
        out.println("Question10:<BR><BR>"); 
        out.println("<FORM METHOD=POST>");
        out.println("<TABLE>");
        out.println("<TR><TD>A.</TD><TD><input type='radio' name='q10' value='ffff' />ffff</TD></TR>");
        out.println("<TR><TD>B.</TD><TD><input type='radio' name='q10' value='wwww' />wwww</TD></TR>");
        out.println("<TR><TD>C.</TD><TD><input type='radio' name='q10' value='vvvv' />vvvv</TD></TR>");
        out.println("<TR><TD>D.</TD><TD><input type='radio' name='q10' value='bbbb' />bbbb</TD></TR>");
        out.println("<TR><TD><INPUT TYPE=SUBMIT VALUE=Submit></TD></TR>");
        out.println("</TABLE>");
        out.println("<INPUT TYPE=HIDDEN NAME=page value=10>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");
    } 
    void displayValues(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Option10 = request.getParameter("q10");
        out.println("<HTML>"); 
        out.println("<HEAD><TITLE>Result</TITLE></HEAD>"); 
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Result (Finish)</H2>");
        out.println("Here are the values you have entered.<BR><BR>"); 
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>Q1: &nbsp;</TD>");
        out.println("<TD>" + Option1 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q2: &nbsp;</TD>");
        out.println("<TD>" + Option2 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q3: &nbsp;</TD>");
        out.println("<TD>" + Option3 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q4: &nbsp;</TD>");
        out.println("<TD>" + Option4 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q5: &nbsp;</TD>");
        out.println("<TD>" + Option5 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q6: &nbsp;</TD>");
        out.println("<TD>" + Option6 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q7: &nbsp;</TD>");
        out.println("<TD>" + Option7 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q8: &nbsp;</TD>");
        out.println("<TD>" + Option8 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q9: &nbsp;</TD>");
        out.println("<TD>" + Option9 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>Q10: &nbsp;</TD>");
        out.println("<TD>" + Option10 + "</TD>");
        out.println("</TR>");
        out.println("</TR></TABLE></CENTER>"); 
        out.println("</BODY></HTML>");
    } 

}