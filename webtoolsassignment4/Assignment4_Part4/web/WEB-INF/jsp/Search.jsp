<%-- 
    Document   : Search
    Created on : Jun 9, 2016, 6:49:59 PM
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
                var keyword = document.getElementById("searchbook").value;
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
        <h1>Search Books</h1>
        <form action="searchresult.htm" onsubmit="return checkempty()" mathod="post">
            <table>
                <tr>
                    <td>Keyword</td>
                    <td><input type="text" name="searchbook" id="searchbook"></td>
                </tr>
            </table>
            <input type="radio" name="search" value="isbn"/>Search by ISBN<br/>
            <input type="radio" name="search" value="title"/>Search by Title<br/>
            <input type="radio" name="search" value="authors"/>Search by Authors<br/>
            <input type="hidden" name="action" value="searchresult"/>
            <input type="submit" value="Search Books" />
        </form>
    </body>
</html>
