/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.registration.controller;

import com.mycompany.registration.bo.RegistrationBO;
import com.mycompany.registration.dto.RegistrationDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author gokud
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/CreateUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        RegistrationBO bo = new RegistrationBO();
        RegistrationDTO user = new RegistrationDTO(username, password, email, phone);
        
        System.out.println("Username: " + username);
        RegistrationDTO checkUser = bo.findUserByUsername(username);
        
        if (checkUser != null) {
            // Tài khoản đã tồn tại
            request.setAttribute("error", "This account already exist!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/CreateUser.jsp");
            dispatcher.forward(request, response);
        }else {
            boolean isCreated = bo.createUser(user);
            if (isCreated) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/Success.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", "Failed to create user!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/CreateUser.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
