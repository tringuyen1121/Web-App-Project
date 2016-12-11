<%-- 
    Document   : register
    Created on : Dec 3, 2016, 4:12:05 AM
    Author     : A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin|Josefin+Sans" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <main>
            <h3 class="title"> REGISTER </h3><br>
            <form method="post" id="register-form" action="Register.do">
                <span id="msg">
                    <% if (request.getAttribute("warning") != null) {%>
                    <%= request.getAttribute("warning")%>
                    <% }%>
                </span> <br>
                <label for="user-username">Username:</label>
                <input class="large" type="text" id="user-username" name="username" pattern="^[A-Za-z0-9._-]{6,100}$" title="Username can only contains letters, numbers, underscore, dot and hyphens" required>
                <label for="user-password">Password:</label>
                <input class="large" type="password" id="user-password" name="password" pattern="^[A-Za-z0-9]{6,50}$" title="Password can only contains letters and numbers" required>
                <label for="user-password">Retype Password:</label>
                <input class="large" type="password" id="retypePassword" name="retypePassword" pattern="^[A-Za-z0-9]{6,50}$" required>
                <label for="user-fname">First Name:</label>
                <input class="large" type="text" id="user-fname" name="fname" pattern="^[A-Za-z\s']{3,50}$" title="Invalid name" required>
                <label for="user-lname">Last Name:</label>
                <input class="large" type="text" id="user-lname" name="lname" pattern="^[A-Za-z.\s']{3,50}$" title="Invalid name" required>
                <input class="gender" type="radio" name="gender" value="male" required><span>Male</span>
                <input class="gender" type="radio" name="gender" value="female"><span>Female</span><br>
                <label for="user-email">Email:</label>
                <input class="large" type="email" id="user-email" name="email" required>
                <input type="submit" id="submit" name="submit" value="SIGN UP">
            </form>
        </main>

        <%@ include file="footer.html" %>

        <script>
            var form = document.getElementById('register-form');

            var validateForm = function (evt) {
                var rePswd = document.getElementById('retypePassword');
                var pswd = document.getElementById('user-password');
                if (rePswd.value !== pswd.value) {
                    evt.preventDefault();
                    alert("Please check that you've entered and confirmed your password!");
                    pswd.focus();
                }
            };
            form.addEventListener('submit', validateForm);
        </script>

        <script type="text/javascript" src="js/checkAvaibility.js"></script>

    </body>
</html>
