/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.controller;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author A
 */
@WebServlet(name = "Upload", urlPatterns = {"/Upload.do"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 50, // 50 MB
        location = "/home/glassfish/glassfish4/glassfish/domains/domain1/applications/upload/thumb"
)
public class Upload extends HttpServlet {

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

        Part filePart = request.getPart("...");
        String fileName = getFileName(filePart);
        
        fileName = fileName.replaceAll("\\s+","");

        filePart.write(fileName);

        HttpSession session = request.getSession();

        session.setAttribute("fileName", fileName);
        request.getRequestDispatcher("imageForm").forward(request, response);

//    InputStream filecontent = null;
//    
//    String path = "/home/glassfish/glassfish4/glassfish/domains/domain1/applications/upload/thumb";
//    OutputStream out = new FileOutputStream(new File(path + File.separator
//                + fileName));
//
//    filecontent = filePart.getInputStream();
//
//    int read = 0;
//    final byte[] bytes = new byte[1024];
//
//    while ((read = filecontent.read(bytes)) != -1) {
//        out.write(bytes, 0, read);
//    }
//        
//        //response.sendRedirect("Welcome");
//        request.setAttribute("image", out);
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
