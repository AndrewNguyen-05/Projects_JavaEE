/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ebookshop.controller;

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
@WebServlet(name = "BackToSearchServlet", urlPatterns = {"/BackToSearchServlet"})
public class BackToSearchServlet extends HttpServlet { 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        
        RequestDispatcher dispatcher
            = request.getRequestDispatcher("./WEB-INF/jsp/SearchBook.jsp"); 
        
        dispatcher.forward(request, response);
    }
}

