<%-- 
    Document   : login
    Created on : Dec 3, 2016, 4:10:09 AM
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin|Josefin+Sans" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <main>
            <div class="user-login">
                <h4 class="title"> LOGIN </h4>
                <span id="msg">
                    <% if (request.getAttribute("warning") != null) {%>
                    <%= request.getAttribute("warning")%>
                    <% }%>
                </span>
                <form method="post" action="Login.do" id="user_login" accept-charset="UTF-8">
                    <label for="user-username">Username:</label>
                    <input class="large" type="text" id="user-username" name="username" pattern="^[A-Za-z0-9._-]{6,100}$" title="Username can only contains letters, numbers, underscore, dot and hyphens" required>
                    <label for="user-password">Password:</label>
                    <input class="large" type="password" id="user-password" name="password" pattern="^[A-Za-z0-9]{6,50}$" title="Password can only contains letters and numbers" required>
                    <input type="submit" id="submit" name="submit" value="SIGN IN">
                </form>
            </div>
            <div class="user-register">
                <h4 class="title">REGISTER</h4>
                <a href="register.jsp" class="create-btn">CREATE ACCOUNT</a>
            </div>
        </main>

        <%@ include file="footer.html" %>
    </body>
</html>
