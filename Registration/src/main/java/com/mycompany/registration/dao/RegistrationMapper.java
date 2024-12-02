/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration.dao;

import com.mycompany.registration.dto.RegistrationDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gokud
 */
public class RegistrationMapper extends DBMapper {
    
    public RegistrationMapper() throws Exception {
        super();
    }
    
    public boolean createUser(RegistrationDTO user) {
        
        String sql = "INSERT INTO member (username, password, email, phone) VALUES (?, ?, ?, ?)";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, user.getUsername());
                    statement.setString(2, user.getPassword());
                    statement.setString(3, user.getEmail());
                    statement.setString(4, user.getPhone());

                    System.out.println("User Info: " + user.getUsername() + ", " + user.getPassword() +
                   ", " + user.getEmail() + ", " + user.getPhone());

                    int rowsAffected = statement.executeUpdate();
                    return rowsAffected > 0;
                }
            } else {
                throw new SQLException("Connection is closed or null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public RegistrationDTO searchUserByUsername(String username) {
        RegistrationDTO user = null;
        
        String sql = "SELECT username, password, email, phone FROM member WHERE username = ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, username);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // Tạo đối tượng RegistrationDTO từ kết quả truy vấn
                            user = new RegistrationDTO(
                                    resultSet.getString("username"), 
                                    resultSet.getString("password"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"));
                        }
                   }
                }
            } else {
                throw new SQLException("Connection is closed or null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}