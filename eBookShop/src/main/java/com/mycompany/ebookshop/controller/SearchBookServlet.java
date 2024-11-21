package com.mycompany.ebookshop.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.ebookshop.bo.BookBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.mycompany.ebookshop.dto.BookDTO;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author gokud
 */

@WebServlet(urlPatterns = {"/SearchBookServlet"})
public class SearchBookServlet extends HttpServlet { 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        response.setContentType("text/html"); 
            
        PrintWriter out = response.getWriter(); 

        BookBO bookBO = new BookBO(); 

        ArrayList<BookDTO> books = bookBO.searchBook(request.getParameter("author")); 
        request.setAttribute("books", books);

        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/ListOfBooks.jsp"); 
        dispatcher.forward(request, response);
    }
}