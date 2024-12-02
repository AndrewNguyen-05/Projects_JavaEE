/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermanagement.bo;

import java.util.*;
import com.mycompany.usermanagement.dto.UserDTO;
import com.mycompany.usermanagement.dao.UserMapper;


/**
 *
 * @author gokud
 */
public class UserBO {
    public boolean createUser(UserDTO user) {
        try {
            UserMapper mapper = new UserMapper();
            return mapper.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<UserDTO> findUserByName(String name) {
        try {
            UserMapper mapper = new UserMapper();
            return mapper.searchUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserDTO updateUser(UserDTO user) {
        try {
            UserMapper mapper = new UserMapper();
            return mapper.updateUserById(user.getId(), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteUser(int userId) {
        try {
            UserMapper mapper = new UserMapper();
            mapper.deleteUserById(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserDTO getUserById(int userId) {
        try {
            UserMapper mapper = new UserMapper();
            return mapper.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        try {
            UserMapper mapper = new UserMapper();
            return mapper.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
