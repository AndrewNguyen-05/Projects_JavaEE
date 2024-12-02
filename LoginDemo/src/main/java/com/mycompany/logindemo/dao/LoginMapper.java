/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logindemo.dao;

import com.mycompany.logindemo.dto.LoginDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gokud
 */
public class LoginMapper extends DBMapper {
    
    public LoginMapper() throws Exception {
        super();
    }
    
    public LoginDTO searchUserByUsername(String username) {
        LoginDTO user = null;
        
        String sql = "SELECT username, password FROM login WHERE username = ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, username);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // Tạo đối tượng LoginDTO từ kết quả truy vấn
                            user = new LoginDTO(resultSet.getString("username"), resultSet.getString("password"));
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
