<%-- 
    Document   : index
    Created on : Dec 1, 2016, 10:21:02 PM
    Author     : A
--%>

<%@page import="com.creatopia.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Creatopia</title>
        <link href="css/main.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran|Quicksand|Cabin" rel="stylesheet">

        <script src="js/modernizr-2.8.3.min.js"></script>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <main>
            <section class="banner" >
                <img class="logo" src="image/logo.gif" alt="Creatopia">
                <h3>It's fun showing off your works</h3>
            </section>
            <section class="image-display">
                <ul id="image-grid">    
                    <!-- image-grid display here -->
                </ul>
            </section>

        </main>

        <%@ include file="footer.html" %>
         <script type="text/javascript">
            var imagesOf = "all";
        </script>
        <script type="text/javascript" src="js/displayImagesAJAX.js"></script>

    </body>
</html>
