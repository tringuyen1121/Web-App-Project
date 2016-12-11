/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.GetConnection;
import java.io.*;
import java.sql.*;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class checkUsername extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            String uname = request.getParameter("username");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE Username=?");
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                out.println("available");
            } else {
                out.println("existed");
            }
        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
