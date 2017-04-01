import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

public class OSUservlet extends HttpServlet{

	public void init(){
		System.out.println("INIT CALLED");
	}

	public void destroy(){
		System.out.println("DESTROY CALLED");
	}

	public void doGet(HttpServletRequest request,  HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()){
			String parameterName=(String)names.nextElement();
			out.println(parameterName+": "+ request.getParameter(parameterName).replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim() + "<br />");
		}
		
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}