<%-- 
    Document   : NotFound
    Created on : Dec 11, 2016, 3:32:22 AM
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

        <h3>404 Error: Contents not found :(</h3>
        <img src="image/notFound.png" alt="404 Not found" id="404image">
        <p id="instant">Try another search or <a href="Home"> click here to return to homepage!</a></p>


        <%@ include file="footer.html" %>
    </body>
</html>
