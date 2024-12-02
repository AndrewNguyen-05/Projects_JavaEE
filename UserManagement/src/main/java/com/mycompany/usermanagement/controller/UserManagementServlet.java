package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.bo.UserBO;
import com.mycompany.usermanagement.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

/**
 *
 * @autor gokud
 */
@WebServlet(name = "UserManagementServlet", urlPatterns = {"/UserManagementServlet"})
public class UserManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserBO userBO = new UserBO();
        RequestDispatcher dispatcher;

        if ("create".equals(action)) {
            dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/CreateUser.jsp");
        } else if ("edit".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserDTO user = userBO.getUserById(userId);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/UpdateUser.jsp");
        } else if ("delete".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserDTO user = userBO.getUserById(userId);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/DeleteUser.jsp");
        } else if ("search".equals(action)) {
            String searchQuery = request.getParameter("search");
            List<UserDTO> users = userBO.findUserByName(searchQuery);
            request.setAttribute("users", users);
            request.setAttribute("searchQuery", searchQuery);
            dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/SearchResults.jsp");
        } else {
            List<UserDTO> users = userBO.getAllUsers();
            request.setAttribute("users", users);
            dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/User.jsp");
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserBO userBO = new UserBO();

        if ("create".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            UserDTO user = new UserDTO(name, email, country);
            userBO.createUser(user);
        } else if ("edit".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            UserDTO user = new UserDTO(userId, name, email, country);
            userBO.updateUser(user);
        } else if ("delete".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            userBO.deleteUser(userId);
        }

        response.sendRedirect("UserManagementServlet");
    }
}