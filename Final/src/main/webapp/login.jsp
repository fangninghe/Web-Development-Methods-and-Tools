<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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