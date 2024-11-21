<%-- 
    Document   : SearchBook
    Created on : Oct 16, 2024, 10:29:53 PM
    Author     : gokud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shopping cart example</title>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Shopping cart example</h2>
        <form method="get" action="./SearchBookServlet">
            Enter an author: <input type="text" name="author" />
            <input type="submit" value="Search" />
        </form>
    </body>
</html>