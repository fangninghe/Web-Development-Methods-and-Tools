<%-- 
    Document   : login
    Created on : Jun 11, 2016, 7:30:19 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Login Page</title>
    </head>

    <body>
        <h1>Welcome to Login our System!</h1>
        <form action="j_security_check" method="post">
            <table>
                <tr><td>User name: <input type="text" name="j_username">
                <tr><td>Password: <input type="password" name="j_password">
                <tr><th><input type="submit" value="Log In">
            </table>
        </form>
    </body>
</html>
