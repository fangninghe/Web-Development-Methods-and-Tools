<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/myTagLibrary" prefix="mytag" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sale Order Record</title>
        <script type="text/javascript">
            function show() {
                var file = document.getElementById("formname").value;
                if (file == '') {
                    alert("empty!");
                }

            }
        </script>
        <style type = 'text/css'>
            #table1,th{
                border: 1px solid black;
                text-align:center;

            }
            td{
                border: 1px solid black;
                text-align:center;
                width: 40;
            }

            #head{
                height: 40px;
            }

        </style>
    </head>

    <body>
        <c:set var="task" value="${requestScope.task}"/>
        <c:choose>
            <c:when test="${task==null}">
                <h3>Please Enter the name of Profile: </h3>
                <form action="showform.htm" method="post">
                    <input type="text" name="formname" id="formname"/>
                    <input type="submit" value="submit" onclick="show()"/>
                    <input type="hidden" name="action" value="showform"/>
                </form>
            </c:when>
            <c:otherwise>
                <mytag:formTag filename="${requestScope.formname}"/>
            </c:otherwise>

        </c:choose>
    </body>
</html>
