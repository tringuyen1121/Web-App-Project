/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.GetConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class PostComment extends HttpServlet {

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
        
        String comment = request.getParameter("comment");
        int imageID = Integer.parseInt(request.getParameter("imageID")); 
        int userID = Integer.parseInt(request.getParameter("userID"));
        
        Date currentdate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO comments VALUES(null,?,?,?,?,1)");
            
            ps.setString(1,comment);
            ps.setInt(2,userID);
            ps.setString(3,dateFormat.format(currentdate));
            ps.setInt(4,imageID);           

            int i = ps.executeUpdate();

            if (i > 0) {           
                response.sendRedirect("Image?image="+imageID);
            }
        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
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
