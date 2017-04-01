<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Home</title>
</head>
<style type="text/css">
#table2 {
	border: 1px solid black;
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {

		var password = document.getElementById("password").value;
		var phonenumber = document.getElementById("phonenumber").value;
		var email = document.getElementById("email").value;
		var address = document.getElementById("address").value;
		var aboutme = document.getElementById("aboutme").value;
		var price = document.getElementById("price").value;

		if (password == '') {
			document.getElementById("passwordspan").innerHTML = "Please Enter Password";
			return false;
		} else {
			document.getElementById("passwordspan").innerHTML = "";
		}
		if (phonenumber == '') {
			document.getElementById("phonenumberspan").innerHTML = "Please Enter Phone Number";
			return false;
		} else {
			document.getElementById("phonenumberspan").innerHTML = "";
		}
		if (email == '') {
			document.getElementById("emailspan").innerHTML = "Please Enter Email";
			return false;
		} else {
			document.getElementById("emailspan").innerHTML = "";
		}
		if (address == '') {
			document.getElementById("addressspan").innerHTML = "Please Enter Address";
			return false;
		} else {
			document.getElementById("addressspan").innerHTML = "";
		}
		if (aboutme == '') {
			document.getElementById("aboutmespan").innerHTML = "Please Enter Self Description";
			return false;
		} else {
			document.getElementById("aboutmespan").innerHTML = "";
		}

		if (price == '') {
			document.getElementById("pricespan").innerHTML = "Please Enter Price";
			return false;
		} else {
			document.getElementById("pricespan").innerHTML = "";
		}
		return true;
	}

	function check1() {
		var message = document.getElementById("message").value;
		if (message == '') {
			alert("Meseage Cannot Be Empty!")
			return false;
		}
		return true;
	}
	function checkphoto() {
		var photo = document.getElementById("photo").value;
		var photoname = document.getElementById("name").value;
		
		if (photo == '') {
			document.getElementById("photospan").innerHTML = "Please Choose a Photo";
			return false;
		} else {
			document.getElementById("photospan").innerHTML = "";
		}
		if (photoname == '') {
			document.getElementById("namespan").innerHTML = "Please Enter Photo Name";
			return false;
		} else {
			document.getElementById("namespan").innerHTML = "";
		}
		return true;
	}
</script>
<body>
	<c:choose>
		<c:when test="${requestScope.none=='none'}">
			<h3>User does not exist, please check your username, password
				and role</h3>
		</c:when>
		<c:otherwise>
			<div>
				Welcome Seller ${sellerUser.username} <a
					href="getselleruserprofile.htm">Review Profile</a> <a
					href="browsemessages.htm">Browsing Messages</a>
				<hr>
			</div>
			<div>
				<c:choose>
					<c:when test="${requestScope.win=='win'}">
						<h3>Update Successfully!</h3>
					</c:when>

					<c:when test="${requestScope.success=='success'}">
						<h3>Send Successfully!</h3>
					</c:when>

					<c:when test="${requestScope.fail=='fail'}">
						<h3>Fail</h3>
					</c:when>

					<c:when test="${requestScope.upload=='upload'}">
						<h3>Upload Successfully!</h3>
					</c:when>


					<c:when test="${requestScope.showuser=='showuser'}">
						<form action="updateselleruser.htm" method="post"
							onsubmit="return check()">
							
							<img src="${sellerUser.photoName}">
							<table>
								<tr>
									<td>User Name:</td>
									<td>${sellerUser.username}</td>
								</tr>
								<tr>
									<td>Check Status:</td>
									<td>${sellerUser.checkstatus}</td>
								</tr>
								<tr>
									<td>Available Status:</td>
									<td>${sellerUser.availablestatus}</td>
									<td><a href="availablestatusupdate.htm">Update</a>
								</tr>
								<tr>
									<td>Password :</td>
									<td><input type="text" name="password" id="password"
										value="${sellerUser.password}" /></td>
									<td><span id="passwordspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Name:</td>
									<td>${sellerUser.name}</td>
								</tr>

								<tr>
									<td>Gender:</td>
									<td>${sellerUser.gender}</td>
								</tr>
								<tr>
									<td>SSN:</td>
									<td>${sellerUser.ssn}</td>
								</tr>
								<tr>
									<td>Category:</td>
									<td>${sellerUser.catagory}</td>
								</tr>
								<tr>
									<td>Price:</td>
									<td>$<input type="text" name="price" id="price"
										value="${sellerUser.price}" />/day</td>
									<td><span id="pricespan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Total:</td>
									<td>\$${sellerUser.total}</td>
								</tr>
								<tr>
									<td>Phone Number:</td>
									<td><input type="text" name="phonenumber" id="phonenumber"
										value="${sellerUser.phoneNumber}" /></td>
									<td><span id="phonenumberspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" name="email" id="email"
										value="${sellerUser.email}" /></td>
									<td><span id="emailspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Address:</td>
									<td><input type="text" name="address" id="address"
										value="${sellerUser.address}" /></td>
									<td><span id="addressspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Self Description:</td>
									<td><input type="text" name="aboutme" id="aboutme"
										value="${sellerUser.aboutMe}" /></td>
									<td><span id="aboutmespan" style="color: red"></span></td>
								</tr>
							</table>
							 <input type="submit" value="Update"><br><br>
						</form>

						<form action="uploadfile.htm" method="post"
							enctype="multipart/form-data" onsubmit="return checkphoto()">
							Choose a Photo(Clear, Max Size: 5MB): <input name="photo" type="file" id="photo" />
							<span id="photospan" style="color: red"></span><br> 
								Name: <input type="text" name="name" id="name"> 
								<span id="namespan" style="color: red"></span><br>
								<input type="submit" value="Upload">
						</form>
						
					</c:when>


					<c:when test="${requestScope.showmessage=='showmessage'}">
						<h4>Message List</h4>
						<c:forEach var="message" items="${sellerUser.messages}">
							<table id="table2">
								<tr>
									<td>Buyer:</td>
									<td><c:out value="${message.buyer.username}"></c:out></td>
									<td><a
										href="selleruserreply.htm?action=reply&username=${message.buyer.username}">Reply</a></td>
								</tr>
								<tr>
									<td>Message:</td>
									<td><c:out value="${message.message}"></c:out></td>
								</tr>
								<tr>
									<td>Time:</td>
									<td><c:out value="${message.time}"></c:out></td>
								</tr>
							</table>
						</c:forEach>
					</c:when>


					<c:when test="${requestScope.leavemessage=='leavemessage'}">
						<h4>Send Message To ${requestScope.buyerUser.username}</h4>
						<form action="selleruserreply.htm" method="get"
							onsubmit="return check1()">
							<textarea rows="5" cols="10" name="message" id="message"></textarea>
							<input type="hidden" name="action" value="leave"> <input
								type="hidden" name="username"
								value="${requestScope.buyerUser.username}" /> <input
								type="submit" value="Send">
						</form>
					</c:when>



				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>