<%@page contentType="text/html"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.lang.String"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.ServletException"%>



<!DOCTYPE html>
<html>
    <head>
		<title> Physician Referral Form </title>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <style type = 'text/css'>
        h1{
            color:#900000;
        }
        p{
            font-family: Arial, Helvetica, sans-serif;
            padding: 0px;
        }

        #p1{
            font-size: 170% ; 
        }
        #p2,#p3,#p12{
            font-size: 75%;
        }
        #p4,#p6,#p9{
            color:#900000;
            font-size:125%;
        }
        #p11{
            font-size:125%;
        }

        #submit{
            font-family: Courier, "Lucida Console", monospace;
            border:#900000 1px solid;
            width:200px;
            height:50px;
            font-size: 200%
        }

    </style>
	
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    
    <script>
      $(document).ready(function() {
	  
        $( "#birth" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
    });
    </script>
	</head>
    
    <body>
	<%
	String action = request.getParameter("action");
	if(action == null){
		out.println("<form action='osu.jsp' method='post'>");
   
        out.println("<div class='head' style='border:0px;height:30px; background: #900000'>");
		out.println("</div>");

        out.println("<h1>");
		out.println("<lable style='float: left; width: 900px;'>" +"Physician Referral Form"); 
		out.println("</lable>");
		out.println("<img src='osulogo.jpg' style='width:250px; height:55px; '>");
		out.println("</h1>");

        out.println("<p id = 'p1'>");
            out.println("<lable style='float: left; width: 300px;'>"+ "Is this referral urgent?" + "</lable>");
            out.println("<lable style='float: left; width: 100px;'>" );
			out.println("Yes" + "<input id ='yes' type ='Radio' name ='langs1' value ='yes'>") ;
			out.println("</lable>");
			out.println("No" + "<input type ='Radio' name ='langs1' value ='no'>");
        out.println("</p>");

        out.println("<p id = 'p2'>" + "If urgent appointment is needed, please call 614-293-5123 to speak with a scheduling representative.");
            
        out.println("</p>");

        out.println("<hr style='height:3px;border:none;border-top:2px ridge #900000;' />");

        out.println("<p id ='p3'>" + "Please fill out this form completely, include any clinical documentation relevant to this referral, and fax all documents to 614-293-1456. Missing information (including clinical documentation) may result in a processing delay.");
            
			out.println("<br />");
            out.println("<input type = 'Radio' name = 'langs' value = 'Clinical' >");
			out.println("<b>" +"Clinical Documentation included"+"</b>");
            out.println("(Examples include: insurance cards, imaging, lab work, office procedures, office notes, etc.)");
        out.println("</p>");

        out.println("<p id = 'p4'>" + "Patient Information:" + "</p>");
            

        out.println("<hr style='height:3px; border:none; border-top:2px ridge #900000;' />");

        out.println("<p id='p5'>");
            out.println("<label style='float: left; width: 450px;'>"+"First Name:"+"</label>");
            out.println("<label style='float: left; width: 450px;'>" + "Middle Name:" + "</label>");
            out.println("<label>" + "Last Name:"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'first' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'middle' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'last' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 225px;'>"+"Gender:" +"</label>");
            out.println("<label style='float: left; width: 400px;'>" +"Marital Status:"+"</label>");
            out.println("<label style='float: left; width: 275px;'>" + "Last 4 digits of SSN:"+"</label>");
            out.println("<label>"+"Date of Birth (mm/dd/yyyy):"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 225px;'>");
			out.println("<input type = 'text' name = 'gender' style = 'height:23px; width:100px; border-color: black; '>"+"</lable>");
            out.println("<lable style='float: left; width: 400px;'>");
			out.println("<input type = 'text' name = 'marital' style = 'height:23px; width:300px; border-color: black; '>"+"</lable>");
            out.println("<lable style='float: left; width: 275px;'>");
			out.println("<input type = 'text' name = 'ssn' style = 'height:23px; width:100px; border-color: black; '>"+"</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'birth' id = 'birth' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 450px;'>"+"Primary Phone:"+"</label>");
            out.println("<label>"+"Street Address:"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 450px;'>"+"<input type = 'text' name = 'phone' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'address' style = 'height:23px; width:650px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 225px;'>"+"City:"+ "</label>");
            out.println("<label style='float: left; width: 400px;'>" + "State:" +"</label>");
            out.println("<label style='float: left; width: 275px;'>" + "Zip:"+"</label>");
            out.println("<label>" + "Country:" + "</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 225px;'>");
			out.println("<input type = 'text' name = 'city' style = 'height:23px; width:100px; border-color: black; '>"+"</lable>");
            out.println("<lable style='float: left; width: 400px;'>");
			out.println("<input type = 'text' name = 'state' style = 'height:23px; width:300px; border-color: black; '>"+"</lable>");
            out.println("<lable style='float: left; width: 275px;'>"+"<input type = 'text' name = 'zip' style = 'height:23px; width:100px; border-color: black; '>"+"</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'country' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");
        out.println("</p>");

        out.println("<p id='p6'>" + "Details:" + "</p>");
		
        out.println("<hr style='height:3px; border:none; border-top:2px ridge #900000;' />");

        out.println("<div class='part1' style='border:0px;height:170px'>");
            out.println("<div class='left1' style='float:right;width:50%;border:1px'>");
                out.println("<p id='p7'>");
                    out.println("<label>" +"Preferred Physician or Provider Name if Applicable:"+"</label>");
					out.println("<br />");
                    out.println("<lable >"+"<input type = 'text' name = 'physician' style = 'height:23px; width:470px; border-color: black; '>"+"</lable>");
					out.println("<br/>");
					out.println("<br/>");
                    out.println("<label>" +"Department or Specialty Area:"+"</label>");
					out.println("<br />");
                    out.println("<lable >"+"<input type = 'text' name = 'area' style = 'height:23px; width:470px; border-color: black; '>"+"</lable>");
					out.println("<br/>");

                out.println("</p>");
            out.println("</div>");
            out.println("<div class='right1' style='width:50%;border:1px'>");
                out.println("<p id='p8'>");
                    out.println("<label>" +"Reasons for Referral:"+"</label>");
					out.println("<br />");
                    out.println("<textarea name = 'reason' rows = 5 cols = 90 style='border-color:black;'>");
					out.println("</textarea>");
					out.println("<br/>");
					out.println("<br/>");
                    out.println("<lable style='float: left; width: 225px;'>");
					out.println("<input type='Radio' name='langs2' value = 'Consult or Second Opinion'>"+"Consult or Second Opinion"+"</lable>");
                    out.println("<lable style='float: left; width: 225px;'>"+"<input type='Radio' name='langs2' value = 'Transfer of Care'>"+"Transfer of Care" +"</lable>");
					out.println("<br/>");
                out.println("</p>");

            out.println("</div>");
        out.println("</div>");

        out.println("<p id='p9'>" + "Referring Provider Information:" + "</p>");
            
   

        out.println("<hr style='height:3px; border:none; border-top:2px ridge #900000;' />");

        out.println("<p id='p10'>");
            out.println("<label style='float: left; width: 450px;'>" +"Provider First Name:"+"</label>");
            out.println("<label>"+"Provider Last Name:"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'pfirst' style = 'height:23px; width:250px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'plast' style = 'height:23px; width:250px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 450px;'>"+"Provider Title:"+"</label>");
            out.println("<label>" +"NPI Number:" +"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'title' style = 'height:23px; width:250px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable >"+ "<input type = 'text' name = 'npi' style = 'height:23px; width:250px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 450px;'>"+"Street Address:"+"</label>");
            out.println("<label style='float: left; width: 450px;'>"+"City:"+"</label>");
            out.println("<label>"+"State:"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'paddress' style = 'height:23px; width:400px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable style='float: left; width: 450px;'>");
			out.println("<input type = 'text' name = 'pcity' style = 'height:23px; width:250px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'pstate' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");

            out.println("<label style='float: left; width: 225px;'>"+"Zip:" +"</label>");
            out.println("<label style='float: left; width: 400px;'>"+"Phone:"+"</label>");
            out.println("<label style='float: left; width: 275px;'>"+"Extension:"+"</label>");
            out.println("<label>"+"Fax:"+"</label>");
			out.println("<br />");

            out.println("<lable style='float: left; width: 225px;'>");
			out.println("<input type = 'text' name = 'pzip' style = 'height:23px; width:100px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable style='float: left; width: 400px;'>"+"<input type = 'text' name = 'pphone' style = 'height:23px; width:300px; border-color: black; '>");
            out.println("</lable>");
            out.println("<lable style='float: left; width: 275px;'>"+"<input type = 'text' name = 'pextension' style = 'height:23px; width:100px; border-color: black; '>"+"</lable>");
            out.println("<lable >"+"<input type = 'text' name = 'fax' style = 'height:23px; width:200px; border-color: black; '>"+"</lable>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<br/>");


            out.println("<div class='part2' style='border:0px;height:50px'>");
                out.println("<div class='left2' style='float:right;width:80%;border:0px'>");
                    out.println("<br/>");
                    out.println("<hr style='height:3px; border:none; border-top:2px ridge black;' />");
                out.println("</div>");

                out.println("<div class='right2' style='width:20%;border:0px'>");
                    out.println("<p id='p11'>");
					out.println("<b>" + "Physician Signature:"+"</b>"+"</p>");
                out.println("</div>");
            out.println("</div>");

            out.println("<div class='part3' style='border:0px;height:50px'>");
                out.println("<div class='left3' style='float:right;width:20%;border:0px'>");
                    out.println("<input type='submit' name='submit' value='submit' id = 'submit'>");
					out.println("<input type='hidden' name='action' value='exist' id = 'action'>");
                out.println("</div>");

                out.println("<div class='right3' style='width:70%;border:0px'>");
                    out.println("<p id='p12'>" + "Please print out this form and include any relevant clinical documentation. Fax all documents to 614-293-1456. A scheduling representative will work with your patient to coordinate the appointment. Your o ce will receive notification via fax once the appointment has been scheduled. To contact via telephone, please call 614-293-5123 to speak with a scheduling representative.");
                        
                    out.println("</p>");
                out.println("</div>");
            out.println("</div>");
        out.println("</p>");
    
out.println("</form>");
	}else{
		String [] langs = request.getParameterValues("langs1");
		String document = request.getParameter("langs");
		String first = request.getParameter("first");
		first = first.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String middle = request.getParameter("middle");
		middle = middle.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String last = request.getParameter("last");
		last = last.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String gender = request.getParameter("gender");
		gender = gender.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String marital = request.getParameter("marital");
		marital = marital.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String ssn = request.getParameter("ssn");
		ssn = ssn.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String birth = request.getParameter("birth");
		birth = birth.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String phone = request.getParameter("phone");
		phone = phone.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String address = request.getParameter("address");
		address = address.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String city = request.getParameter("city");
		city = city.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String state = request.getParameter("state");
		state = state.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String zip = request.getParameter("zip");
		zip = zip.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String country = request.getParameter("country");
		country = country.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String reasonofreferal = request.getParameter("reason");
		reasonofreferal = reasonofreferal.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String[] reasonchoose = request.getParameterValues("langs2");
		String physician = request.getParameter("physician");
		physician = physician.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String area = request.getParameter("area");
		area = area.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String pfirst = request.getParameter("pfirst");
		pfirst = pfirst.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String plast = request.getParameter("plast");
		plast = plast.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String title = request.getParameter("title");
		title = title.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String npi = request.getParameter("npi");
		npi = npi.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String paddress = request.getParameter("paddress");
		paddress = paddress.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String pcity = request.getParameter("pcity");
		pcity = pcity.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String pstate = request.getParameter("pstate");
		pstate = pstate.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		String pzip = request.getParameter("pzip");
		pzip = pzip.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String pphone = request.getParameter("pphone");
		pphone = pphone.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String pextension = request.getParameter("pextension");
		pextension = pextension.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		String fax = request.getParameter("fax");
		fax = fax.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		
		
		
		
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h4>" + "Patient Information:" + "</h4>");
		out.println("<hr />");
		
		if(langs != null ){
			for(int i = 0 ; i < langs.length; i++){
				out.println("<h3>" + "referral or not:" + langs[i] + "</h3>");
			}
		}
		
		if(document != null){
			out.println("Documentation included: Yes" + "<br />" );
		}else{
			out.println("Documentation included: No" + "<br />" );
		}
		
		out.println("First Name: " + first+ "<br />" );
		out.println("Middle Name: " + middle+ "<br />" );
		out.println("Last Name: " + last + "<br />");
		
		out.println("Gender: " + gender+ "<br />");
		out.println("Marital Status: " + marital+ "<br />");
		out.println("SSN: " + ssn+ "<br />");
		out.println("Date of Birth: " + birth + "<br />");
		
		out.println("Primary Phone: " + phone+ "<br />");
		out.println("Street Address:" + address + "<br />");
		
		out.println("City: " + city + "<br />");
		out.println("State: " + state+ "<br />");
		out.println("Zip: " + zip+ "<br />");
		out.println("Country: " + country + "<br />");
		
		out.println("<h4>" + "Details:" + "</h4>");
		out.println("<hr />");
		out.println("Reasons for Referral: " + reasonofreferal + "<br />");
		
		if(reasonchoose != null ){
			for(int i = 0 ; i < reasonchoose.length; i++){
				out.println("Consult or Second Opinion or Transfer of Care:" + reasonchoose[i]+ "<br />");
			}
		}
		out.println("Preferred Physician or Provider Name if Applicable: " + physician+ "<br />" );
		out.println("Department or Specialty Area: " + area + "<br />");
		
		out.println("<h4>" + "Referring Provider Information:" + "</h4>");
		out.println("<hr />");
		out.println("Provider First Name: " + pfirst+ "<br />");
		out.println("Provider Last Name:" + plast + "<br />");
		
		out.println("Provider Title: " + title+ "<br />");
		out.println("NPI Number:" + npi + "<br />");
		
		out.println("Provider Address: " + paddress+ "<br />");
		out.println("Provider City: " + pcity+ "<br />");
		out.println("Proivder State " + pstate + "<br />");
		
		out.println("Provider Phone: " + pphone+ "<br />");
		out.println("Provider Zip: " + pzip+ "<br />");
		out.println("Proivder Extension: " + pextension+ "<br />");
		out.println("Provider Fax: " + fax);
		
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	%>
		
	</body>
</html>