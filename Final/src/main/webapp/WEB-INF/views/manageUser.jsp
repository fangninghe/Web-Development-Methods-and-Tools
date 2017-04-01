<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Administration</title>
</head>
<style type="text/css">
table {
	border: 1px solid black;
	text-align: center;
}

table,td {
	border: none;
	text-align: center;
	width: 100px;
}
img{
	height: 100px;
	width: 100px;
}
</style>
<body>
	<div>
		<a href="manageselleruser.htm">Manage Seller</a>&nbsp <a
			href="managebuyeruser.htm">Manage Buyer</a><br /> <br />
		<hr />
	</div>
	<c:choose>
		<c:when test="${requestScope.buyer=='buyer'}">
			<h3>Buyers`s Profile</h3>
			<table>
				<c:forEach var="buyer" items="${requestScope.buyerList}">
					<tr>
						<td>User Name:</td>
						<td><c:out value="${buyer.username}"></c:out></td>
						<td>ID:</td>
						<td><c:out value="${buyer.id}"></c:out></td>
						<td>Phone Number:</td>
						<td><c:out value="${buyer.phoneNumber}"></c:out></td>
						<td>Email:</td>
						<td><c:out value="${buyer.email}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		
		<c:when test="${requestScope.seller=='seller'}">
		<h3>Seller`s Profile</h3>
		
			<table>
				<c:forEach var="seller" items="${requestScope.sellerList}">
				
					<tr>
						<td><img src="${seller.photoName}"></td>
					</tr>
					<tr>
						<td>User Name: </td>
						<td><c:out value="${seller.username}"></c:out></td>
						<td>ID: </td>
						<td><c:out value="${seller.id}"></c:out></td>
					</tr>
					<tr>
						<td>Name: </td>
						<td><c:out value="${seller.name}"></c:out></td>
						<td>Gender: </td>
						<td><c:out value="${seller.gender}"></c:out></td>
						<td>SSN: </td>
						<td><c:out value="${seller.ssn}"></c:out></td>
					</tr>
					<tr>
						<td>Phone Number: </td>
						<td><c:out value="${seller.phoneNumber}"></c:out></td>
						<td>Email: </td>
						<td><c:out value="${seller.email}"></c:out></td>
						
					</tr>
					<tr>
						<td>Category: </td>
						<td><c:out value="${seller.catagory}"></c:out></td>
						<td>Price: </td>
						<td><c:out value="${seller.price}"></c:out></td>
						<td>Total: </td>
						<td><c:out value="${seller.total}"></c:out></td>
						
					</tr>
					<tr>
						<td>Self Description:</td>
						<td colspan="5"><c:out value="${seller.aboutMe}"></c:out></td>
						
					</tr>
						<td>Address:</td>
						<td colspan="5"><c:out value="${seller.address}"></c:out></td>
					<tr>
					</tr>
					<tr>
						<td>Check Status: </td>
						<td><c:out value="${seller.checkstatus}"></c:out></td>
						<td><a href="sellercheckstatus.htm?username=${seller.username}">Update</a></td>
					</tr>
					<tr>
						<td>Available Status: </td>
						<td><c:out value="${seller.availablestatus}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
			</c:when>
			
			<c:when test="${requestScope.win=='win'}">
				<h3>Update Successfully</h3>
			</c:when>
		
	</c:choose>
	<div></div>
</body>
</html>