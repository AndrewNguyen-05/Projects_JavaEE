/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebookshop.bo;

import java.util.*;

import com.mycompany.ebookshop.dto.BookDTO;
import com.mycompany.ebookshop.dto.CartDTO;
import com.mycompany.ebookshop.dao.BookMapper;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author gokud
 */
public class ShoppingCartBO {
    public ArrayList<CartDTO> updateShoppingCart (ArrayList<CartDTO> shoppingCart, int currentBookID) {
        BookMapper bookMapper = null;
        ArrayList<BookDTO> arrBooks = new ArrayList<BookDTO>();
        try {
            bookMapper = new BookMapper();
            BookDTO book = bookMapper.getBook(currentBookID);
            //store product infomantion to session
            if (shoppingCart == null) {
                shoppingCart = new ArrayList<CartDTO>();
                //if not exist session cart, add new book to cart
                CartDTO cartDTO = new CartDTO();
                cartDTO.setId(book.getId());
                cartDTO.setTitle(book.getTitle());
                cartDTO.setAuthor(book.getAuthor());
                cartDTO.setPrice(book.getPrice());
                cartDTO.setOrderQuantity(1);
                shoppingCart.add(cartDTO);
            } else {
                //if ID is exist, increase quantity
                boolean checkID = false;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    CartDTO cart = shoppingCart.get(i);
                    if (cart.getId() == currentBookID) {
                        cart.setOrderQuantity(cart.getOrderQuantity() + 1);
                        checkID = true;
                        break;
                    }
                }
                //if ID isn't exist
                if (checkID == false) {
                    CartDTO cart = new CartDTO();
                    cart.setId(book.getId());
                    cart.setTitle(book.getTitle());
                    cart.setAuthor(book.getAuthor());
                    cart.setPrice(book.getPrice());
                    cart.setOrderQuantity(1);
                    shoppingCart.add(cart);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (bookMapper != null) try {
                bookMapper.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(ShoppingCartBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return shoppingCart;
    }
}
