/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.GetConnection;
import com.creatopia.dao.GetUserFromID;
import com.creatopia.model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author A
 */
@WebServlet(name = "ChangeUserSettings", urlPatterns = {"/ChangeUserSettings"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 50, // 50 MB
        location = "/home/glassfish/glassfish4/glassfish/domains/domain1/applications/upload/avatar"
)
public class ChangeUserSettings extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        final Part filePart = request.getPart("avatar");
        final String fileName = getFileName(filePart);
        
        int userID = Integer.parseInt(request.getParameter("userID"));
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String bio = request.getParameter("bio");

        filePart.write(fileName);
        

        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("UPDATE users SET Fname=?, Lname=?, Gender=?, Email=?, Password=?, Bio=?, Avatar =? WHERE User_ID=? ");
            ps.setString(1, fname);
            ps.setString(2, lname);
            if (gender.equals("male")) {
                ps.setInt(3, 1);
            } else {
                ps.setInt(3, 2);
            }
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, bio);
            ps.setString(7, "avatar/"+fileName);
            
            ps.setInt(8, userID);

            int i = ps.executeUpdate();

            if (i > 0) {
                HttpSession session = request.getSession();
                Users currentUser = GetUserFromID.getUser(userID);
                session.setAttribute("currentUser",currentUser);
                request.getRequestDispatcher("SettingsSaved").forward(request, response);
            }
        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    private static String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
