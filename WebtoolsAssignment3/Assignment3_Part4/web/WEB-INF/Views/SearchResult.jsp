<%-- 
    Document   : SearchResult
    Created on : May 30, 2016, 8:03:58 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
    </head>
    <body>
        <h4>You searched for <c:out value="${sessionScope.keyword}"></c:out>  </h4>
            <p><u>Here are the search results</u></p>
                <c:choose>
                    <c:when test="${sessionScope.none=='none'}">
                <h3>No result, please check your enter</h3>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <td>Movie Title:</td>
                        <td><c:out value="${movie.name}"></c:out></td>
                        </tr>
                        <tr>
                            <td>Lead Actor:</td>
                            <td><c:out value="${movie.actor}"></c:out></td>
                        </tr>
                        <tr>
                            <td>Lead Actress:</td>
                            <td><c:out value="${movie.actress}"></c:out></td>
                        </tr>
                        <tr>
                            <td>Genre:</td>
                            <td><c:out value="${movie.genre}"></c:out></td>
                        </tr>
                        <tr>
                            <td>Year:</td>
                            <td><c:out value="${movie.year}"></c:out></td>
                        </tr>
                    </table>

            </c:otherwise>
        </c:choose>

        <a href="welcomeview.htm?action=return">Click Here to Go Back to the Main Page</a>
    </body>
</html>
