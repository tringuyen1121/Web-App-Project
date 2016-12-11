<%-- 
    Document   : Welcome
    Created on : Nov 30, 2016, 10:20:46 AM
    Author     : A
--%>

<%@page import="com.creatopia.model.*,javax.servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Creatopia</title>
        <link href="css/welcome.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran|Quicksand|Cabin" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <%--<% String username = (String) session.getAttribute("login");%>--%>

        <%
            Users user = (Users) session.getAttribute("currentUser");
            String username = user.getUsername();
            if (username == null) {
                response.sendRedirect("Login");
            }
        %>
        <h3>Welcome <%= username%> !</h3>
        <h5> Please wait... Redirecting to home page after</h5>
        <div id="countdown"><span>3</span></div>
        <p id="instant"> Can't wait, huh? <a href="Home"> Click here to get out now!</a></p>

        <script type="text/javascript">
            setInterval(function () {
                var div = document.querySelector("#countdown");
                var counter = div.textContent * 1 - 1;
                div.innerHTML = counter;
                div.textContent = counter;
                if (counter <= 0) {
                    location.href = "Home";
                }
            }, 1000);
        </script>

        <%@ include file="footer.html" %>
    </body>
</html>
