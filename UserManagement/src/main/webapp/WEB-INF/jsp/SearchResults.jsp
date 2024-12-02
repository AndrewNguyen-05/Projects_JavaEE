<%-- 
    Document   : SearchResult
    Created on : Dec 2, 2024, 10:08:56 AM
    Author     : gokud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.usermanagement.dto.UserDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Search Results</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 80%;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                margin-top: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            .top-bar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }
            .top-bar form {
                margin: 0;
            }
            input[type="text"] {
                padding: 10px;
                width: 300px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 10px;
            }
            button, .add-user-btn, .back-btn {
                padding: 10px 20px;
                background-color: #28a745;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-right: 10px;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
            }
            button:hover, .add-user-btn:hover, .back-btn:hover {
                background-color: #218838;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table, th, td {
                border: 1px solid #ccc;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f8f8f8;
            }
            a {
                color: #007bff;
                text-decoration: none;
            }
            a:hover {
                text-decoration: underline;
            }
            .actions button {
                padding: 8px 16px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 14px;
                margin-right: 10px;
            }
            .edit-btn {
                background-color: #007bff; /* Blue for Edit */
                color: white;
            }
            .edit-btn:hover {
                background-color: #0056b3;
            }
            .delete-btn {
                background-color: #dc3545; /* Red for Delete */
                color: white;
            }
            .delete-btn:hover {
                background-color: #c82333;
            }
        </style>
    </head>
    
    <body>
        <div class="container">
            <h1>Search Results for "<c:out value="${searchQuery}"/>"</h1>
            <div class="top-bar">
                <a href="UserManagementServlet" class="back-btn">Back to User List</a>
            </div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.country}</td>
                        <td class="actions">
                            <a href="UserManagementServlet?action=edit&id=${user.id}">
                                <button class="edit-btn">Edit</button>
                            </a>
                            <a href="UserManagementServlet?action=delete&id=${user.id}" onclick="return confirm('Are you sure you want to delete this user?');">
                                <button class="delete-btn">Delete</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
