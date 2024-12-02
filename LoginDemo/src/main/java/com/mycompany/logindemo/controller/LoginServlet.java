/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.logindemo.controller;

import com.mycompany.logindemo.dto.LoginDTO;
import com.mycompany.logindemo.bo.LoginBO;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gokud
 */

@WebServlet(name = "LoginServlet", urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến Login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/Login.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        LoginBO loginBO = new LoginBO();
        LoginDTO user = loginBO.findUserByUsername(username);

        if (user == null) {
            // Tài khoản không tồn tại
            request.setAttribute("error", "Account does not exist");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/Login.jsp");
            dispatcher.forward(request, response);
        } else if (!loginBO.checkPasswordByUsername(username, password)) {
            // Sai mật khẩu
            request.setAttribute("error", "Invalid password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsp/Login.jsp");
            dispatcher.forward(request, response);
        } else {
            // Đăng nhập thành công
            request.getSession().setAttribute("loggedInUser", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Admin.jsp");
            dispatcher.forward(request, response);
        }
    }
}

