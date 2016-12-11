/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import com.creatopia.dao.GetConnection;
import com.creatopia.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author A
 */
public class ImageRegister extends HttpServlet {

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

        HttpSession session = request.getSession();

        String username = ((Users) session.getAttribute("currentUser")).getUsername();
        Integer userID = ((Users) session.getAttribute("currentUser")).getUserID();

        Date currentdate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String imageName = request.getParameter("i-name");
        String imageDesc = request.getParameter("i-desc");
        String imageLocation = request.getParameter("i-location");
        String fileName = (String) session.getAttribute("fileName");
        String imageTag = request.getParameter("i-tags");

        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("INSERT INTO images VALUES(null,?,?,?,?,?,0,0,?,1,?,?)");
            ps.setString(1, imageName);
            ps.setString(2, imageDesc);
            ps.setString(3, dateFormat.format(currentdate));
            ps.setString(4, imageLocation);
            ps.setInt(5, userID);
            ps.setString(6, dateFormat.format(currentdate));
            ps.setString(7, "thumb/" + fileName);
            ps.setString(8, imageTag);

            int i = ps.executeUpdate();

            if (i > 0) {
                RequestDispatcher view = request.getRequestDispatcher("UploadResult");
                view.forward(request, response);
            }
        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
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
