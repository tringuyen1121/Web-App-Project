<%-- 
    Document   : header
    Created on : Dec 1, 2016, 9:57:11 PM
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="javax.servlet.*,java.util.*, com.creatopia.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="css/header.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran|Quicksand|Cabin" rel="stylesheet">
    </head>

    <body>
        <% boolean isConnected = false;
            if (session.getAttribute("connected") != null) {
                String connected = (String) session.getAttribute("connected");
                isConnected = connected.equals("true");
            } %>
        <header>
            <div class="wrapper">
                <div class="left logo">
                    <a href="Home"><img src="image/logo.gif" alt="Creatopia"/></a>
                </div>
                <div class="center">
                    <form method="GET" id="search-form" action="Search">
                        <input class="search-box" type="text" name="search" placeholder="Search..." />
                    </form>
                </div>
                <%if (!isConnected) { %>
                <div class="right">
                    <a class="sign-in" href="Login">SIGN IN</a>
                </div>
                <% } else if (isConnected) { %>
                <ul class ="right">
                    <li id="user-profile">
                        <img src=<% Users user = (Users) session.getAttribute("currentUser");%>
                             <% if (user.getAvatar() != null) {%>
                             <%= user.getAvatar()%>
                             <% } else { %>
                             "upload/avatar/user.jpg"
                             <% } %> />
                        <ul>
                            <li>Upload</li>
                            <li><a href="User?search=<%= user.getUsername()%>">My Profile</a></li>
                            <li><a href="userSettings.jsp">Settings</a></li>
                            <li><a href="Logout.do">Log Out</a></li>
                        </ul>
                    </li>
                </ul> 
                <%@ include file="upload.html" %>
                <script type="text/javascript">
                    var userProfile = document.getElementById("user-profile");
                    var upload = userProfile.children[1].children[0];
                    upload.style.cursor = 'pointer';
                    upload.addEventListener('click', function () {
                        document.getElementById('upload-box').style.display = 'block';
                        document.querySelector('body').style.backgroundColor = 'rgba(50,50,50,0.5)';
                    });
                </script>
                <% }%>
            </div>
        </header>

        <script type="text/javascript" src="js/upload.js"></script> 
    </body>
</html>

