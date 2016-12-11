<%-- 
    Document   : imageForm
    Created on : Dec 5, 2016, 12:06:43 AM
    Author     : A
--%>

<%@page import="java.io.OutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>imageForm</title>
        <link href="css/imageForm.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Cabin|Josefin+Sans" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <main>
            <div id="main-container">
                <div id="image-container">
                    <div id="image-wrapper">
                        <img src="
                             <% String fileName = (String) session.getAttribute("fileName");%>
                             thumb/<%= fileName%>"
                    </div>
                </div>
                <div id="form-container">
                    <div id="form-wrapper">
                        <h4 class="title">Give us the details of your image, too:</h4>
                        <form method="post" action="ImageRegister.do">
                            <label for="i-name">Title:</label>
                            <input type="text" name="i-name" id="i-name" required>
                            <label for="i-location">Location:</label>
                            <input type="text" name="i-location" id="i-location">
                            <label for="i-tags">Category:</label>
                            <input type="text" name="i-tags" id="i-tags" placeholder="Tags are seperated by commas">
                            <label for="i-desc">Description:</label>
                            <textarea rows="4" cols="50" name="i-desc" id="i-desc"></textarea>
                            <input type="submit" name="submit" id="submit" value="SUBMIT">
                            <a href="Home" id="cancel-btn-wrapper"><button type="button" id="cancel-btn">CANCEL</button></a>
                        </form>
                    </div>
                </div>
            </div>	
        </main>	

        <%@ include file="footer.html" %>
    </body>
</html>
