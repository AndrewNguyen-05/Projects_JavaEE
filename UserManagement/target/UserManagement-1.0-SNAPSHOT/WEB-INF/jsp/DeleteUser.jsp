<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.usermanagement.bo.UserBO" %>
<%@ page import="com.mycompany.usermanagement.dto.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delete User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .delete-user-container {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            background-color: #ffffff;
            text-align: center;
        }

        .delete-user-container h1 {
            font-size: 28px;
            margin-bottom: 20px;
            color: #333;
        }

        .delete-user-container p {
            font-size: 16px;
            margin-bottom: 20px;
            color: #555;
        }

        .delete-user-container button {
            padding: 10px 20px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .delete-user-container button:hover {
            background-color: #c82333;
        }

        .delete-user-container .cancel-btn {
            display: inline-block;
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

        .delete-user-container .cancel-btn:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="delete-user-container">
        <h1>Are you sure you want to delete this user?</h1>
        <form action="UserManagementServlet" method="post">
            <% 
                int userId = Integer.parseInt(request.getParameter("id"));
                UserBO userBO = new UserBO();
                UserDTO user = userBO.getUserById(userId);
            %>

            <p>Name: <%= user.getName() %></p>
            <p>Email: <%= user.getEmail() %></p>
            <p>Country: <%= user.getCountry() %></p>

            <input type="hidden" name="id" value="<%= userId %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
            <a href="UserManagementServlet" class="cancel-btn">Cancel</a>
        </form>
    </div>
</body>
</html>