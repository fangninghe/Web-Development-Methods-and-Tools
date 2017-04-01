<%@page contentType="text/html"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.lang.String"%>
<!DOCTYPE html>
<html>
    <head>
		<title> Physician Referral Form </title>
	</head>
    
    <body>
		<%
            
		
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
		
		
        %>
	</body>
</html>