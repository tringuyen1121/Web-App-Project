/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import java.sql.*;

/**
 *
 * @author A
 */
public class Validate {

    public static boolean checkUser(String username, String password) {
        boolean st = false;
        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE Username=? AND Password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    
    public static boolean checkUsername(String username) {
        boolean st = false;
        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE Username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
