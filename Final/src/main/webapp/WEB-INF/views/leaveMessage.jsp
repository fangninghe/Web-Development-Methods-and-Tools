<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function check1() {
		var message = document.getElementById("message").value;
		if (message == '') {
			alert("Meseage Cannot Be Empty!")
			return false;
		}
		return true;
	}
	function valid() {
		var day = document.getElementById("day").value;
		if (day == '') {
			alert("Day Cannot Be Empty!")
			return false;
		}
		return true;
	}
</script>
<body>
<h1><a href="buyersendmessage.htm?action=gobackhome&username=${requestScope.sellerUser.username}">Go Back</a></h1>
	<c:choose>
		<c:when test="${requestScope.leavemessage=='leavemessage'}">
			<h3>Check out And Leave a Message</h3>
			<h4>Send Message To ${requestScope.sellerUser.name}</h4>
			<form action="buyersendmessage.htm" method="get"
				onsubmit="return check1()">
				<textarea rows="5" cols="10" name="message" id="message"></textarea>
				<input type="hidden" name="action" value="leave"> <input
					type="hidden" name="username"
					value="${requestScope.sellerUser.username}" /> <input
					type="submit" value="Send">
			</form>
			<br>
			<br>

			<form action="buyersendmessage.htm" method="get" onsubmit="return valid()">
				<input type="text" name="day" id="day" />day <input type="hidden"
					name="action" value="checkout"> <input type="hidden"
					name="username" value="${requestScope.sellerUser.username}" /> <input
					type="submit" value="Check Out">
			</form>
		</c:when>

		<c:when test="${requestScope.success=='success'}">
			<h3>Send Successfully!</h3><a href="buyersendmessage.htm?action=goback&username=${requestScope.sellerUser.username}">Go Back</a>
		</c:when>

		<c:when test="${requestScope.checkoutyes=='checkoutyes'}">
			<h3>Check Out Successfully!</h3><a href="buyersendmessage.htm?action=gobackhome&username=${requestScope.sellerUser.username}"">Go Back</a>
		</c:when>
	</c:choose>

</body>
</html>