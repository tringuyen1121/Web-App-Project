/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class GetImagesFromSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
        PrintWriter out = response.getWriter();

        String query = request.getParameter("search");
        String type = "";
        if (query.contains(":")) {
            type = query.substring(0, query.indexOf(':'));
            query = query.substring(query.indexOf(':') + 1);
            query = query.trim();
        }
        query = query.toLowerCase();
        type = type.toLowerCase();

        try {
            Connection connection = GetConnection.getConnection("creatopia", "tring123", "tringuyen1121");

            PreparedStatement ps = null;
            String statement = "";
            if (query.isEmpty()) {
                request.getRequestDispatcher("Error").forward(request, response);
            } else if (type.equals("image")) {
                String[] words = query.split("\\s+");
                if (words.length == 1) {
                    ps = connection.prepareStatement("SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND Image_name LIKE '%"+query+"%' ORDER BY images.Upload_date DESC");
                } else {
                    statement = "SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND (";
                    for (int i = 0; i < words.length; i++) {
                        statement += "Image_name LIKE '%" + words[i] + "%'";
                        if (i != words.length - 1) {
                            statement += " OR ";
                        }
                    }
                    statement += ") ORDER BY images.Upload_date DESC";

                    ps = connection.prepareStatement(statement);
                }
            } else if (type.equals("tag")) {
                String[] words = query.split("\\s+");
                if (words.length == 1) {
                    ps = connection.prepareStatement("SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND Tags LIKE '%"+query+"%' ORDER BY images.Upload_date DESC");
                } else {
                    statement = "SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND (";
                    for (int j = 0; j < words.length; j++) {
                        statement += "Tags LIKE '%" + words[j] + "%'";
                        if (j != words.length - 1) {
                            statement += " OR ";
                        }
                    }
                    statement += ") ORDER BY images.Upload_date DESC";

                    ps = connection.prepareStatement(statement);
                }
            } else {
                String[] words = query.split("\\s+");
                if (words.length == 1) {
                    ps = connection.prepareStatement("SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND (Tags LIKE '%"+query+"%' OR Image_name LIKE '%"+query+"%') ORDER BY images.Upload_date DESC");
                } else {
                    statement = "SELECT DISTINCT images.*, users.Username FROM images, users WHERE users.User_ID = images.User_ID AND (";
                    for (int k = 0; k < words.length; k++) {
                        statement += "Tags LIKE '%" + words[k] + "%' OR ";
                    }
                    for (int m = 0; m < words.length; m++) {
                        statement += "Image_name LIKE '%" + words[m] + "%'";
                        if (m != words.length - 1) {
                            statement += " OR ";
                        }
                    }
                    statement += ") ORDER BY images.Upload_date DESC";

                    ps = connection.prepareStatement(statement);
                }
            }

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {   
                rs.beforeFirst();
                String JSONString = GetJSONString.getJSONFromResultSet(rs, "images");
                request.setAttribute("JSONArr", JSONString);
                request.getRequestDispatcher("SearchResult").forward(request, response);
            } else {
                request.getRequestDispatcher("Error").forward(request, response);
            }

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
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
