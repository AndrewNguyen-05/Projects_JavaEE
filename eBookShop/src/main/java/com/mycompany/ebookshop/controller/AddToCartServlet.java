package com.mycompany.ebookshop.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mycompany.ebookshop.bo.ShoppingCartBO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.ebookshop.dto.CartDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author gokud
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet" }) 
public class AddToCartServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
    
        int currentBookID = new Integer(request.getParameter("id")); 
        HttpSession session = request.getSession();
        ArrayList<CartDTO> shoppingCart = (ArrayList)session.getAttribute("shoppingCart");
        
        ShoppingCartBO cartBO = new ShoppingCartBO();
        shoppingCart = cartBO.updateShoppingCart (shoppingCart, currentBookID); 
        
        //set session
        session.setAttribute("shoppingCart", shoppingCart);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ShoppingCart.jsp");
        dispatcher.forward (request, response);
    }
}