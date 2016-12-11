/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.Validate;
import com.creatopia.model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author A
 */
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (Validate.checkUser(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("connected", "true");
            session.setAttribute("login", username);

            RequestDispatcher getUser = request.getRequestDispatcher("GetUser.do");
            getUser.include(request, response);

//            Cookie loginCookie = new Cookie("user",username);
//            response.addCookie(loginCookie);
            response.sendRedirect("Welcome");
        } else {
            String warning = "The username and/or password are incorrect!";
            request.setAttribute("warning", warning);
            RequestDispatcher rs = request.getRequestDispatcher("Login");
            rs.forward(request, response);
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
