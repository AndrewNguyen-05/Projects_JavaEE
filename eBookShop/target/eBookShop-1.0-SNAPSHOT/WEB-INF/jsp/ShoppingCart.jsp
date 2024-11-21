<%-- 
    Document   : ShoppingCart
    Created on : Oct 16, 2024, 11:09:51 PM
    Author     : gokud
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycompany.ebookshop.dto.CartDTO" %> 
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your Shopping Cart</h1>
        <form action="" method="POST">
        <table border="0">
            <thead>
                <tr>
                    <th>Book Title</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <% 
                float totalOrder = 0;
                HttpSession currentSession = request.getSession();
                if(currentSession.getAttribute("shoppingCart") != null) {
                    ArrayList<CartDTO> arrC = (ArrayList<CartDTO>) 
                    currentSession.getAttribute("shoppingCart");
                    for (int i = 0; i < arrC.size(); i++) {
                        totalOrder += (float) (arrC.get(i).getOrderQuantity() * arrC.get(i).getPrice());
            %>  
                <tr>
                    <td><%= arrC.get(i).getTitle()%></td>
                    <td><%= arrC.get(i).getOrderQuantity()%></td>
                    <td><%= arrC.get(i).getPrice()%></td>
                </tr>         
            <%      }
                } else {
            %>
                <h1>YOU DONT BUY ANYTHING</h1>
            <%
                }
            %>
            </tbody>
        </table>
        <p>Total: <%= totalOrder%></p>
        <p><input type="button" value ="confirm" onclick=""/></p>
        </form>
        <p><a href="./BackToSearchServlet">Back to search</a></p>
    </body>
</html>