/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration.bo;

import com.mycompany.registration.dao.RegistrationMapper;
import com.mycompany.registration.dto.RegistrationDTO;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gokud
 */
public class RegistrationBO {
    public boolean createUser(RegistrationDTO user) {
        try {
            RegistrationMapper mapper = new RegistrationMapper();
            return mapper.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public RegistrationDTO findUserByUsername(String username) {
        RegistrationDTO user = new RegistrationDTO();
        
        RegistrationMapper mapper = null;
        try {
            mapper = new RegistrationMapper();
            user = mapper.searchUserByUsername(username);
            
        } catch (Exception ex) {
            Logger.getLogger(RegistrationMapper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (mapper != null) {
                    mapper.closeConnection();
                }
            } catch (Exception ex) {
                Logger.getLogger(RegistrationMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;
    }
}
