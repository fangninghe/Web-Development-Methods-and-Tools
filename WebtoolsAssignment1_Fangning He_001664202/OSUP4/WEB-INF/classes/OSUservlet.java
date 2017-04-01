import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

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
		
		Map map = request.getParameterMap();
		Set dataSet=map.entrySet();
		for(Iterator iterator = dataSet.iterator();iterator.hasNext();){
			
			Map.Entry me=(Map.Entry)iterator.next();
			Object key=me.getKey();
			Object value=me.getValue();
			String[] thevalue=new String[1];
			if(value instanceof String[]){
				thevalue=(String[])value;
			}else{
				thevalue[0]=value.toString();
			}

        for(int k=0;k<thevalue.length;k++){
            out.println(key+":"+thevalue[k].replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").trim() + "<br />");
        }
      }
		
		
		
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}