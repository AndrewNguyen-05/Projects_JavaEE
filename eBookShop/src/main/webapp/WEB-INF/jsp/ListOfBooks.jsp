
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.ebookshop.dto.BookDTO" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List products</title>
    </head>
    <body>
        <h1>Select thing to buy</h1>
        <table border="1">
            <thead>
            <tr><th>ID</th><th>Title</th><th>Price</th><th>Action</th></tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book" >
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>
                        <a href="AddToCartServlet?id=${book.id}">
                        <input type="submit" value="Add To Card" /></a> 
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    <p><a href="./ViewShoppingCartServlet">View Shopping Cart</a></p>
    </body>
</html>