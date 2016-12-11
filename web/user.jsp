<%-- 
    Document   : user
    Created on : Dec 10, 2016, 11:25:58 PM
    Author     : A
--%>

<%@page import="com.creatopia.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Users</title>
        <link href="css/users/user-main.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran|Quicksand|Cabin" rel="stylesheet">
    </head>

    <body>
        <%
            Users user = (Users) request.getAttribute("user");
            boolean isConnected = false;
            if (session.getAttribute("connected") != null) {
                String connected = (String) session.getAttribute("connected");
                isConnected = connected.equals("true");
            }
        %>
        <jsp:include page="header.jsp" />

        <main>
            <section class="profile-banner" >
                <img class="avatar" src="
                     <% if (user.getAvatar() != null) {%>
                     <%= user.getAvatar()%>
                     <% } else { %>
                     upload/avatar/user.jpg
                     <%}%>
                     " alt="Profile Picture">
                <h2 id="username"><%= user.getUsername()%></h2>
            </section>
            <section class="image-display">
                <ul id="image-grid">    
                    <!-- image-grid display here -->
                </ul>
            </section>
        </main>

        <%@ include file="footer.html" %>

        <script type="text/javascript">
            document.title = "<%= user.getUsername()%>";
        </script>
        <script type="text/javascript">
            var imagesOf = "<%= user.getUsername()%>";
        </script>
        <script type="text/javascript" src="js/displayImagesAJAX.js"></script>
    </body>
</html>
