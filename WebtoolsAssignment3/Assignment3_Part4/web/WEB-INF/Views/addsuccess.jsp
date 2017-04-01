<%-- 
    Document   : addsuccess
    Created on : May 30, 2016, 5:06:54 PM
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
            <c:when test="${sessionScope.yes=='yes'}">Movie "<c:out value="${sessionScope.reviewtitle}"></c:out>" is in the database already</c:when>
            <c:otherwise>
                <h1>1 Movie Added Successfully</h1>
            </c:otherwise>
        </c:choose>
        
        <a href="welcomeview.htm?action=return">Click Here to Go Back to the Main Page</a>
    </body>
</html>
