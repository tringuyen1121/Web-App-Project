<%-- 
    Document   : searctResult
    Created on : Dec 11, 2016, 4:42:57 AM
    Author     : A
--%>

<%@page import="com.creatopia.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta content="utf-8" http-equiv="encoding">
        <title>Creatopia</title>
        <link href="css/main.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran|Quicksand|Cabin" rel="stylesheet">

        <script src="js/modernizr-2.8.3.min.js"></script>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <main>
            <section class="image-display">
                <ul id="image-grid">    
                    <!-- image-grid display here -->
                </ul>
            </section>

        </main>

        <%@ include file="footer.html" %>
        
        <% String JSONArr = (String)request.getAttribute("JSONArr"); %>
        <script type="text/javascript">
            var JSONArr = '<%= JSONArr%>' ;
        </script>
        <script type="text/javascript" src="js/displayImagesFromSearchAJAX.js"></script>

    </body>
</html>
