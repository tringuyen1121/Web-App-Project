<%-- 
    Document   : SettingsSaved
    Created on : Dec 11, 2016, 2:14:15 AM
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

        <h3>Settings have been saved successfully</h3>
        <p id="instant"><a href="Home"> Click here to return to homepage!</a></p>


        <%@ include file="footer.html" %>
    </body>
</html>
