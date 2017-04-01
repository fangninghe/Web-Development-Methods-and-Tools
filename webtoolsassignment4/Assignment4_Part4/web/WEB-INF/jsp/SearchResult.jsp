<%-- 
    Document   : SearchResult
    Created on : Jun 9, 2016, 7:53:57 PM
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
        <h4>You searched for <c:out value="${requestScope.keyword}"></c:out>  </h4>
            <p><u>Here are the search results</u></p>
                <c:choose>
                    <c:when test="${sessionScope.none=='none'}">
                <h3>No result, please check your enter</h3>
            </c:when>
            <c:otherwise>
                <c:forEach var="book" items="${requestScope.searchbook}">
                    <table>
                        <tr>
                            <td>Book Title:</td>
                            <td><c:out value="${book.title}"></c:out></td>
                            </tr>
                            <tr>
                                <td>Book ISBN:</td>
                                <td><c:out value="${book.isbn}"></c:out></td>
                            </tr>
                            <tr>
                                <td>Book Authors:</td>
                                <td><c:out value="${book.authors}"></c:out></td>
                            </tr>
                            <tr>
                                <td>Book Price:</td>
                                <td><c:out value="${book.price}"></c:out></td>
                            </tr>
                        </table>
                </c:forEach>

            </c:otherwise>
        </c:choose>

        <a href="welcome.htm?action=return">Click Here to Go Back to the Main Page</a>
    </body>
</html>
