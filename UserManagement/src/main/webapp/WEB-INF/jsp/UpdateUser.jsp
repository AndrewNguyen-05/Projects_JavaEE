<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.usermanagement.dto.UserDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Update User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .update-user-container {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            background-color: #ffffff;
        }

        .update-user-container h1 {
            text-align: center;
            font-size: 28px;
            margin-bottom: 20px;
            color: #333;
        }

        .update-user-container label {
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
            color: #555;
        }

        .update-user-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

        .update-user-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .update-user-container button:hover {
            background-color: #0056b3;
        }

        .update-user-container .back-btn {
            display: block;
            text-align: center;
            margin-top: 10px;
            text-decoration: none;
            color: white;
            background-color: #6c757d;
            padding: 10px;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .update-user-container .back-btn:hover {
            background-color: #5a6268;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 15px;
            text-align: center;
        }
    </style>
  </head>
  <body>
    <div class="update-user-container">
        <h1>Update User</h1>

        <%-- Hiển thị lỗi nếu có --%>
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
        <p class="error-message"><%= error %></p>
        <% } %>

        <form action="UserManagementServlet" method="post">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="id" value="${user.id}">

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${user.name}" required />

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required />

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" value="${user.country}" required />

            <button type="submit">Save</button>
        </form>
        <a href="UserManagementServlet" class="back-btn">Back to User List</a>
    </div>
  </body>
</html>