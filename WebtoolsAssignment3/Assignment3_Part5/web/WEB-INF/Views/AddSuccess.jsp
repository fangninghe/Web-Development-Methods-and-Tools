<%-- 
    Document   : AddSuccess
    Created on : May 30, 2016, 11:10:58 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Successfully</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.yes=='yes'}">Book "<c:out value="${sessionScope.reviewtitle}"></c:out>" is in the database already</c:when>
            <c:otherwise>
                <h4> <c:out value="${sessionScope.totalnumber}"></c:out> books added successfully</h4>
            </c:otherwise>
        </c:choose>
        
        <a href ="welcome.htm?action=return">Click Here to Go Back the Homepage</a>
    </body>
</html>
