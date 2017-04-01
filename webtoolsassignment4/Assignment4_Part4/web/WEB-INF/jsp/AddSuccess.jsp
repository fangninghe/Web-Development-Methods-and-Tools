<%-- 
    Document   : AddSuccess
    Created on : Jun 9, 2016, 2:56:42 PM
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
        <h4> <c:out value="${sessionScope.totalnumber}"></c:out> books added successfully</h4>
        <a href ="welcome.htm?action=return">Click Here to Go Back the Homepage</a>
    </body>
</html>
