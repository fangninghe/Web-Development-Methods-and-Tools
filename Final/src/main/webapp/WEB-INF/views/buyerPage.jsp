<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<style type="text/css">
#table2 {
	border: 1px solid black;
	text-align: center;
}
img {
	height: 150px;
	width: 150px;
}
</style>
<script type="text/javascript">
	function check() {
		var password = document.getElementById("password").value;
		var phonenumber = document.getElementById("phonenumber").value;
		var email = document.getElementById("email").value;

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
	function valid() {
		var gender = document.getElementsByName("gender");
		var category = document.getElementsByName("category");
		
		if (!(gender[0].checked || gender[1].checked ||category[0].checked || category[1].checked)) {


			alert("Please select a search feature.");


			return false;


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
				Welcome Buyer ${buyerUser.username} <a href="getuserprofile.htm">ReviewProfile</a>
				<a href="browseseller.htm">Browsing All Sellers</a>
				<hr>
			</div>
			<div>
				<c:choose>
					<c:when test="${requestScope.showuser=='showuser'}">
						<form action="updatebuyeruser.htm" method="post"
							onsubmit="return check()">
							<table>
								<tr>
									<td>User Name:</td>
									<td>${buyerUser.username}</td>
								</tr>
								<tr>
									<td>Password :</td>
									<td><input type="text" name="password" id="password"
										value="${buyerUser.password}" /></td>
									<td><span id="passwordspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Phone Number:</td>
									<td><input type="text" name="phonenumber" id="phonenumber"
										value="${buyerUser.phoneNumber}" /></td>
									<td><span id="phonenumberspan" style="color: red"></span></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" name="email" id="email"
										value="${buyerUser.email}" /></td>
									<td><span id="emailspan" style="color: red"></span></td>
								</tr>
							</table>
							<br> <input type="submit" value="Update">
						</form>
						
						<h4>Message List</h4>
						<c:forEach var="message" items="${buyerUser.messages}">
							<table>
								<tr>
									<td>Seller:</td>
									<td><c:out value="${message.seller.name}"></c:out></td>
									<td><a
										href="buyersendmessage.htm?action=seeseller&username=${message.seller.username}">Reply</a></td>
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



					<c:when test="${requestScope.win=='win'}">
						<h3>Update Successfully!</h3>
					</c:when>



					<c:when test="${sessionScope.seller=='seller'}">
					<h3>Enjoy Your Browse</h3>
					<form action="filter.htm" method="post" onsubmit="return valid()">
					Search by Gender: <input type="radio" name="gender" value="F"/>Female &nbsp
					<input type="radio" name="gender" value="M"/>Male<br><br>
					Search by Category: <input type="radio" name="category" value="Parent"/>Parent &nbsp
					<input type="radio" name="category" value="Fellow"/>Fellow &nbsp
					<input type="submit" value="Search">
					</form>
					
					<c:choose>
						<c:when test="${requestScope.sellerF=='sellerF'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListF}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="50">
						
							<table id="table3">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerM=='sellerM'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListM}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table4">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerP=='sellerP'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListP}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table5">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerFe=='sellerFe'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListFe}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table6">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerFF=='sellerFF'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListFF}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table7">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerMP=='sellerMP'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListMP}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table8">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						<c:when test="${requestScope.sellerMF=='sellerMF'}">
					
							<c:forEach var="seller" items="${requestScope.sellerListMF}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
						
							<table id="table9">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:when>
						
						
						
						<c:otherwise>
						<c:forEach var="seller" items="${requestScope.sellerList}">
							<c:if test="${seller.checkstatus=='Appoved'}">
								<img src="${seller.photoName}" height="100" width="100">
							
							<table id="table2">
									<tr>
										<td>Name:</td>
										<td><c:out value="${seller.name}"></c:out></td>
										<td><a
											href="buyersendmessage.htm?action=seeseller&username=${seller.username}">
												Check Out Or Leave A Message</a></td>
										<td>Gender:</td>
										<td><c:out value="${seller.gender}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number:</td>
										<td><c:out value="${seller.phoneNumber}"></c:out></td>
										<td>Email:</td>
										<td><c:out value="${seller.email}"></c:out></td>
									</tr>
									<tr>
										<td>Category:</td>
										<td><c:out value="${seller.catagory}"></c:out></td>
										<td>Price:</td>
										<td>$<c:out value="${seller.price}"></c:out>/day</td>
										<td>Self Description:</td>
										<td><c:out value="${seller.aboutMe}"></c:out></td>
									</tr>
									<tr>
										<td>Available Status:</td>
										<td><c:out value="${seller.availablestatus}"></c:out></td>
									</tr>
								</table>
							</c:if>
						</c:forEach>
						</c:otherwise>
					</c:choose>	
					</c:when>

				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>