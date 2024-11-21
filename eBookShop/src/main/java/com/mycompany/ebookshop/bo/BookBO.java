/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebookshop.bo;

import com.mycompany.ebookshop.dao.BookMapper;
import com.mycompany.ebookshop.dto.BookDTO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gokud
 */
public class BookBO {
    public ArrayList<BookDTO> searchBook(String authorName) {
        authorName = authorName == null ? "" : authorName;
        ArrayList<BookDTO> books = new ArrayList<>();
        BookMapper mapper = null;
        try {
            mapper = new BookMapper();
            books = mapper.searchBook(authorName);
        } catch (Exception ex) {
            Logger.getLogger(BookBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (mapper != null) {
                    mapper.closeConnection();
                }
            } catch (Exception ex) {
                Logger.getLogger(BookBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return books;
    }

    public BookDTO getBook(int id) {
        BookDTO book = null;
        BookMapper mapper = null;
        try {
            mapper = new BookMapper();
            book = mapper.getBook(id);
        } catch (Exception ex) {
            Logger.getLogger(BookBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (mapper != null) {
                    mapper.closeConnection();
                }
            } catch (Exception ex) {
                Logger.getLogger(BookBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return book;
    }
}
