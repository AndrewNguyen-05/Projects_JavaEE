<%-- Document : Login Created on : Dec 1, 2024, 2:33:12 PM Author : gokud --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login Page</title>
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
      .login-container {
        width: 100%;
        max-width: 400px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        background-color: #ffffff;
      }
      .login-container input {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
      }
      .login-container h1 {
        text-align: center;
        font-size: 28px;
        margin-bottom: 20px;
        color: #333;
      }
      .login-container label {
        font-size: 14px;
        font-weight: bold;
        margin-bottom: 5px;
        display: block;
        color: #555;
      }
      .login-container button {
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
      .login-container button:hover {
        background-color: #0056b3;
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
    <div class="login-container">
      <h1>Login Page</h1>
      <%-- Hiển thị lỗi nếu có --%> <% String error = (String)
      request.getAttribute("error"); %> <% if (error != null) { %>
      <p class="error-message"><%= error %></p>
      <% } %>

      <form action="LoginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <button type="submit">Login</button>
      </form>
    </div>
  </body>
</html>
