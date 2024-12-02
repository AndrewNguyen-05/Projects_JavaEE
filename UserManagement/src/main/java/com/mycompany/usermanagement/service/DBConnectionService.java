/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionService {
    // No need for loadJDBCDriver() anymore in JavaEE 10
    public static Connection getConnection() throws Exception {
        Connection connection = null;
        if(connection == null){
            try {
                // Connect to the database using the URL
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/userdb?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "12345678"
                );
                if (connection != null && !connection.isClosed()) {
                    System.out.println("Successfully connected to the database.");
                } else {
                    System.out.println("Failed to connect to the database.");
                }
            } catch (java.sql.SQLException e) {
                throw new Exception("Cannot access the Database Server: " + e.getMessage());
            } 
        }
                       
        return connection;
    }
}

