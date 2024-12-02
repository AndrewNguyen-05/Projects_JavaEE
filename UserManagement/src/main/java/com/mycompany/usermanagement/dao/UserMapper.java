/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermanagement.dao;

import com.mycompany.usermanagement.dto.UserDTO;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gokud
 */
public class UserMapper extends DBMapper {
    public UserMapper() throws Exception {
        super();
    }
    
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        UserDTO user = new UserDTO(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("country")
                        );
                        users.add(user);
                    }
                }
            } else {
                throw new SQLException("Connection is closed or null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public List<UserDTO> searchUserByName(String name) {
        List<UserDTO> users = new ArrayList<>();
        
        String sql = "SELECT * FROM users WHERE name LIKE ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, "%" + name + "%");

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            // Tạo đối tượng UserDTO từ mỗi dòng kết quả
                            UserDTO user = new UserDTO(
                                    resultSet.getInt("id"),         // Lấy cột id
                                    resultSet.getString("name"),    // Lấy cột name
                                    resultSet.getString("email"),   // Lấy cột email
                                    resultSet.getString("country")  // Lấy cột country
                            );
                            // Thêm đối tượng vào danh sách
                            users.add(user);
                        }
                   }
                }
            } else {
                throw new SQLException("Connection is closed or null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean createUser(UserDTO user) {
        System.out.println("Inside createUser");
        String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, user.getName());
                    statement.setString(2, user.getEmail());
                    statement.setString(3, user.getCountry());

                    System.out.println("User Info: " + user.getName() + ", " + user.getEmail() +
                   ", " + user.getCountry());

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
    
    public UserDTO getUserById(int id) throws Exception {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setInt(1, id);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            return new UserDTO(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("email"),
                                    resultSet.getString("country")
                            );
                        } else {
                            throw new Exception("User with ID " + id + " not found.");
                        }
                    }
                }
            } else {
                throw new SQLException("Connection is closed or null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Rethrow exception to caller
        }
    }

    
    public UserDTO updateUserById(int id, UserDTO updatedUser) throws Exception {
        // Kiểm tra xem người dùng có tồn tại hay không
        UserDTO existingUser = getUserById(id);

        String sql = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setString(1, updatedUser.getName());
                    statement.setString(2, updatedUser.getEmail());
                    statement.setString(3, updatedUser.getCountry());
                    statement.setInt(4, id);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        return new UserDTO(id, updatedUser.getName(), updatedUser.getEmail(), updatedUser.getCountry());
                    } else {
                        throw new Exception("Failed to update user with ID " + id);
                    }
                }
            } else {
                throw new SQLException("Connection is closed or null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Rethrow exception to caller
        }
    }
    
    public void deleteUserById(int id) throws Exception {
        // Kiểm tra xem người dùng có tồn tại hay không
        getUserById(id);

        String sql = "DELETE FROM users WHERE id = ?";
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
                    statement.setInt(1, id);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected == 0) {
                        throw new Exception("Failed to delete user with ID " + id);
                    }
                }
            } else {
                throw new SQLException("Connection is closed or null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Rethrow exception to caller
        }
    }


}
