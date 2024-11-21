/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebookshop.dao;

import java.sql.*;
import java.util.*;
import com.mycompany.ebookshop.dto.BookDTO;

/**
 *
 * @author gokud
 */
public class BookMapper extends DBMapper{
    public BookMapper() throws Exception {
        super();
    }
    
    public ArrayList<BookDTO> searchBook (String authorName) { 
        ArrayList<BookDTO> books = new ArrayList<>();
        String sqlStr = "SELECT * FROM books WHERE author LIKE ? AND qty > 0 ORDER BY author ASC, title ASC";

        // Ensure the connection is open
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement stmt = getConnection().prepareStatement(sqlStr)) {
                    stmt.setString(1, "%" + authorName + "%");
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            BookDTO book = new BookDTO();
                            book.setId(rs.getInt("id"));
                            book.setTitle(rs.getString("title"));
                            book.setAuthor(rs.getString("author"));
                            book.setPrice(rs.getFloat("price"));
                            book.setQty(rs.getInt("qty"));
                            books.add(book);
                        }
                    }
                }
            } else {
                throw new SQLException("Connection is closed or null");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // or use a logger to log the error
        }
        return books;
    }

    public BookDTO getBook(int id) throws Exception {
        BookDTO book = null;
        String query = "SELECT * FROM books WHERE id = ?";

        // Ensure the connection is open
        if (getConnection() != null && !getConnection().isClosed()) {
            try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
                stmt.setInt(1, id); // Set the book ID in the prepared statement
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    book = new BookDTO(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getFloat("price"),
                        rs.getInt("qty")
                    );
                }
            } catch (SQLException e) {
                throw new Exception("Error fetching book by ID: " + e.getMessage());
            }
        } else {
            throw new SQLException("Connection is closed or null");
        }

        return book;
    }
}
