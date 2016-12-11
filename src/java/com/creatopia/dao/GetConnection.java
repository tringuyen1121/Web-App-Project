/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author A
 */
public class GetConnection {

    public static Connection getConnection(String database, String user, String password) {
        
        Connection connection = null;
        
        try {
            String connectionURL = "jdbc:mysql://10.114.32.20:3306/"+database;           
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
