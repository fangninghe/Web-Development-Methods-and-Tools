import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class RequestHead extends HttpServlet {
	public void init(){
		System.out.println("INIT CALLED");
	}

	public void delete(){
		System.out.println("DELETE CALLED");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Request Headers";

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0.1 Transitional//EN \">\n");
		out.println("<html>"+
			        "<head><title>"+ title + "</title></head>\n"+
			        "<body>\n" + 
 			        "<h1 align = \"center\">" + title + "</hi>\n"+
 			        "<Table border = 1 align = \"center\">\n" +
 			        "<th> Header Name <th> Header Value"  ); 

 		Enumeration headNames = request.getHeaderNames();
		while(headNames.hasMoreElements()){
			String headName = (String)headNames.nextElement();
			out.println("<tr><td>" + headName);
			out.println("    <td>" + request.getHeader(headName));
		}
		out.println("</table>\n</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


}