/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import com.creatopia.model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author A
 */
public class GetUserFromID {

    public static Users getUser(int userID) {
        Users user = new Users();
        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE User_ID=?");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setUsername(rs.getString("Username"));
                user.setUserID(rs.getInt("User_ID"));
                user.setFname(rs.getString("Fname"));
                user.setLname(rs.getString("Lname"));
                user.setGender(rs.getShort("Gender"));
                user.setEmail(rs.getString("Email"));
                user.setUserrole(rs.getString("User_role"));
                user.setBio(rs.getString("Bio"));
                user.setAvatar(rs.getString("Avatar"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
