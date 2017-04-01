<%-- 
    Document   : SearchMovie
    Created on : May 30, 2016, 7:41:04 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Movies</title>
        <script type="text/javascript">
            function checkempty(){
                var pattern = /^[0-9A-Za-z]*$/;
                var keyword = document.getElementById("searchmovie").value;
                var keywordcategory = document.getElementsByName("search").value;
                
                if(keyword == '' || keywordcategory == ''){
                    alert("Keyword cannot be Empty");
                    return false;
                }else if(!keyword.match(pattern)){
                    alert("Only number and letter are allowed")
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <h1>Search Movies</h1>
        <form action="searchmovie.htm" onsubmit="return checkempty()" mathod="post">
            <table>
                <tr>
                    <td>Keyword</td>
                    <td><input type="text" name="searchmovie" id="searchmovie"></td>
                </tr>
            </table>
            <input type="radio" name="search" value="title"/>Search by Title<br/>
            <input type="radio" name="search" value="actor"/>Search by Actors<br/>
            <input type="radio" name="search" value="actress"/>Search by Actress<br/>
            <input type="hidden" name="action" value="searchmoive"/>
            <input type="submit" value="Search Movies" />
        </form>
    </body>
</html>
