<%-- 
    Document   : AddMovie
    Created on : May 30, 2016, 4:11:55 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movies</title>
        <script type="text/javascript">
            function check(){
                var pattern = /^[0-9A-Za-z\s]*$/;
               
                var pattern1 =  /^[0-9]*$/;
                var title = document.getElementById("title").value;
                var actor = document.getElementById("actor").value;
                var actress = document.getElementById("actress").value;
                var genre = document.getElementById("genre").value;
                var year = document.getElementById("year").value;
                if(title == '' || actor == '' || actress == '' || genre =='' || year ==''){
                    alert("Input cannot be empty");
                    return false;
                }
                if(!year.match(pattern1)|| !title.match(pattern) || !actor.match(pattern) || !actress.match(pattern)
                        || !genre.match(pattern)){
                    alert("Correct Format Needed!");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <h2>Please Enter the Details Below:</h2>
        <form action="addmovie.htm" method="post" onsubmit="return check()">
            <table>
                <tr>
                    <td>Movie Title</td>
                    <td><input type="text" name="title" id="title"></td>
                </tr>
                <tr>
                    <td>Lead Actor</td>
                    <td><input type="text" name="actor" id="actor"></td>
                </tr>
                <tr>
                    <td>Lead Actress</td>
                    <td><input type="text" name="actress" id="actress"></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" name="genre" id="genre"></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="text" name="year" id="year"></td>
                </tr>
                
            </table>
            <input type="hidden" name="action" value="addsuccess">
            <input type="submit" value="Add Moives">
        </form>
    </body>
</html>
