/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration.dao;

import com.mycompany.registration.service.DBConnectionService;
import java.sql.Connection;

/**
 *
 * @author gokud
 */
public class DBMapper {
    private Connection connection;
    public DBMapper() throws Exception {
        try{
            this.connection = DBConnectionService.getConnection();  
        } catch(Exception e) {
            System.out.println("Failed in constructor method in MapperDB:" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public DBMapper(Connection con) {
        this.connection = con;
    }

    public void closeConnection() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
