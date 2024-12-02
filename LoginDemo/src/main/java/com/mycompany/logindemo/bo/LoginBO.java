/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logindemo.bo;

import com.mycompany.logindemo.dao.LoginMapper;
import com.mycompany.logindemo.dto.LoginDTO;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gokud
 */
public class LoginBO {
    public LoginDTO findUserByUsername(String username) {
        LoginDTO user = new LoginDTO();
        
        LoginMapper mapper = null;
        try {
            mapper = new LoginMapper();
            user = mapper.searchUserByUsername(username);
            
            if (user == null) {
                Logger.getLogger(LoginBO.class.getName()).log(Level.WARNING, "User not found for username: {0}", username);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(LoginBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (mapper != null) {
                    mapper.closeConnection();
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;
    }
    
    public boolean checkPasswordByUsername(String username, String password) {
        boolean isPasswordValid = false;
        LoginMapper mapper = null;

        try {
            mapper = new LoginMapper();
            LoginDTO user = mapper.searchUserByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                isPasswordValid = true;
            } else {
                Logger.getLogger(LoginBO.class.getName())
                      .log(Level.WARNING, "Invalid password for username: {0}", username);
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (mapper != null) {
                    mapper.closeConnection();
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginBO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return isPasswordValid;
    }

}
