<%-- 
    Document   : Welcome
    Created on : May 30, 2016, 10:54:03 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <script type="text/javascript">
            function number() {
                var pattern = /^[0-9]*$/;
                var book = document.getElementById("booknumber").value;
                if (book != '') {
                    if (book.match(pattern)) {
                        var number = parseInt(book);

                        var inner = "<input type='hidden' name='booknumber' value='" + number + "'><br/>";
                        for (var i = 1; i <= number; i++) {
                            var childrenname = "<tr id='body'><td><input type = 'text' id='isbn" +i+"' name ='isbn" + i + "'><input type = 'text' id='title" +i+"' name ='title" + i + "'><input type = 'text' id='authors" +i+"' name ='authors" + i + "'><input type = 'text' id='price" +i+"' name ='price" + i + "'><td/></tr><br>";
                            
                            inner += childrenname;
                        }

                        var div = document.getElementById("table2");

                        div.innerHTML = inner;

                        document.getElementById("question").style.display = "none";
                        document.getElementById("form").style.display = "block";

                    } else {
                        alert("The number is invalid!");
                    }
                } else {
                    alert("Empty!");
                }
            }

            function clean() {
               
                var pattern = /^[0-9A-Za-z]*$/;
                var pattern1 = /^[0-9.]*$/;
                var pattern2 = /^[0-9A-Za-z\-]*$/;
                var book = document.getElementById("booknumber").value;
                var number = parseInt(book);
                for (var i = 1; i <= number; i++) {
                    var isbn = document.getElementById("isbn" + i).value;
                    var authors = document.getElementById("authors" + i).value;
                    var title = document.getElementById("title" + i).value;
                    var price = document.getElementById("price" + i).value;

                    if (isbn == '' || authors == '' || title == '' || price == '') {
                        alert("Input cannot be empty");
                        return false;
                    }
                    if(!isbn.match(pattern2) || !authors.match(pattern) || !title.match(pattern) || !price.match(pattern1)){
                        alert("Correct Format Needed!");
                        return false;
                    }
                }
                return true;
            }

        </script>
        <style type = 'text/css'>
            #table1,th, td{
                border: 1px solid black;
                text-align:center;
            }
         
            #head{
                height: 40px;
            }
            #body{
                height: 30px;
            }
            #isbn,#title,#authors,#price{
                width: 160px; 
            }
           

        </style>
    </head>
    <body>
        <form id="form" action="addbooks.htm" method="post" style = "display : none" onsubmit="return clean()">
            <table id="table1">
                <tr id="head">
                    <td id="isbn"><b>ISBN</b></td>
                    <td id="title"><b>Book Title</b></td>
                    <td id="authors"><b>Authors</b></td>
                    <td id="price"><b>Price</b></td>
                </tr>
            </table>
            <table id="table2"></table>
            <input type = "submit" name = "submit" value = "Add Books" id = "submit">
            <input type="hidden" name="action" value="addbooks">
        </form>
        <div id="question" name = "question" style = "display : block">
            <h1>How many books do you want to add? </h1>
            <input type = "text" name = "book"  id = "booknumber" value = "" style = "height:23px; width:200px; border-color: black;"><br/><br/>
            <button  onclick = "number()">Submit</button>
        </div>
    </body>
</html>
