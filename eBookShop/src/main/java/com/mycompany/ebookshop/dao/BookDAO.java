/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebookshop.dao;

import com.mycompany.ebookshop.dto.BookDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author gokud
 */
public class BookDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/ebookshop";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "12345678";

    public ArrayList<BookDTO> searchBooks(String author) {
        ArrayList<BookDTO> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books WHERE author LIKE ? AND qty > 0")) {
            stmt.setString(1, "%" + author + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                books.add(new BookDTO(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getFloat("price"), rs.getInt("qty")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public BookDTO getBookById(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BookDTO(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getFloat("price"), rs.getInt("qty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
