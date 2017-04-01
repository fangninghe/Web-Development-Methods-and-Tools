<%-- 
    Document   : WelcomeView
    Created on : May 30, 2016, 3:11:34 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fancy Movie</title>
    </head>
    <body>
        <h1>Welcome to Our Movie Store</h1>
        <h3>Please make your selection below</h3>
        <form action="addmovie.htm" method="post" >
            <select name="action">
                <option value="browsemovies">Browse Movies</option>
                <option value="addmovie">Add new Movies to DataBase</option>
            </select> 
            <input type="submit" id="submit"  value="Send">
        </form>

    </body>
</html>
