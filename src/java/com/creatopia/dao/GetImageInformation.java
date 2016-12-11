/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import com.creatopia.model.Images;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A
 */
public class GetImageInformation extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String image_ID = (String) request.getParameter("image");
        int ID = Integer.parseInt(image_ID);
        Images currentImage = new Images();

        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM images WHERE Image_ID=?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                currentImage.setImageID(rs.getInt("Image_ID"));
                currentImage.setImagename(rs.getString("Image_name"));
                currentImage.setImagedesc(rs.getString("Image_desc"));
                currentImage.setUploaddate(rs.getDate("Upload_date"));
                currentImage.setImageloca(rs.getString("Image_loca"));
                currentImage.setUserID(rs.getInt("User_ID"));
                currentImage.setNumView(rs.getInt("Num_View"));
                currentImage.setNumLike(rs.getInt("Num_Like"));
                currentImage.setLastEdit(rs.getDate("Last_Edit"));
                currentImage.setPath(rs.getString("Path"));
                currentImage.setTags(rs.getString("Tags"));
            }

            request.setAttribute("currentImage", currentImage);
            request.getRequestDispatcher("SingleImage").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        doGet(request, response);
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
