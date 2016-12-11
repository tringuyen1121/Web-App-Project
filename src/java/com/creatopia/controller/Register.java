/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.GetConnection;
import com.creatopia.dao.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.creatopia.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A
 */
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

        if (Validate.checkUsername(username)) {
            String warning = "Username is already taken!";
            request.setAttribute("warning", warning);
            RequestDispatcher rs = request.getRequestDispatcher("RegisterUser");
            rs.forward(request, response);
        } else {

            try {
                Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

                PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(null,?,?,?,?,?,?,?,null,null)");
                ps.setString(1, username);
                ps.setString(2, fname);
                ps.setString(3, lname);
                if (gender.equals("male")) {
                    ps.setInt(4, 1);
                } else {
                    ps.setInt(4, 2);
                }
                ps.setString(5, email);
                ps.setString(6, password);
                ps.setString(7, "USER_ROLE");

                int i = ps.executeUpdate();

                if (i > 0) {
                    RequestDispatcher view = request.getRequestDispatcher("Login.do");
                    view.forward(request, response);
                }
            } catch (Exception ex) {
                out.println("Error ->" + ex.getMessage());
            } finally {
                out.close();
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
