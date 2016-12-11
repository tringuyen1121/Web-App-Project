<%-- 
    Document   : image
    Created on : Dec 10, 2016, 5:47:54 PM
    Author     : A
--%>

<%@page import="com.creatopia.model.*, com.creatopia.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link href="css/image.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Catamaran" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin|Josefin+Sans" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="header.jsp" />	
        <%
            Images currentImage = (Images) request.getAttribute("currentImage");
            Users author = GetUserFromID.getUser(currentImage.getUserID());
            Users currentUser = (Users) session.getAttribute("currentUser");
            boolean isConnected = false;
            if (session.getAttribute("connected") != null) {
                String connected = (String) session.getAttribute("connected");
                isConnected = connected.equals("true");
            }
        %>
        <main>
            <div id="img-container">
                <div id="user-n-img">
                    <div id="user">
                        <img width="60px" height="60px" src="
                             <% if (author.getAvatar() != null) {%>
                             <%= author.getAvatar()%>
                             <% } else { %>
                             upload/avatar/user.jpg
                             <%}%>
                             " >
                        <div id="username">
                            <a href="User?search=<%= author.getUsername()%>"><h3><%= author.getUsername()%></h3></a>
                        </div>
                    </div>
                    <div id="img-wrapper">
                        <img src=<%= currentImage.getPath()%>>
                    </div>
                </div>

                <div id="img-info">
                    <div id="hidden-bar"></div>
                    <div id="img-name">
                        <h3><%= currentImage.getImagename()%></h3>
                    </div>
                    <div id="img-desc">
                        <p><%= currentImage.getImagedesc()%></p>
                    </div>
                    <div id="img-stats">
                        <div id="like-wrapper">
                            <div id="like-icon">
                                <img src="image/icons/like.gif" width="35px">
                            </div>
                            <span id="num-like"><%= currentImage.getNumLike()%></span>
                        </div>
                        <div id="comment-wrapper">
                            <%if (isConnected) {%> 
                            <div id="form-wrapper">
                                <form method="post" action="PostComment.do">
                                    <textarea name="comment" rows="4" class="form-control status-box" placeholder="Enter your comment here..."></textarea>
                                    <input type="text" class="hidden" name="imageID" value="<%= currentImage.getImageID()%>">
                                    <input type="text" class="hidden" name="userID" value="<%= currentUser.getUserID()%>">
                                    <input type="submit" id="submit" name="submit" class="submit" value="POST">                                    
                                </form>
                            </div>
                            <% }%>
                            <div id="comment-list-wrapper">
                                <ul id="comment-list">
                                    <!--                                    <li class="comment">
                                                                            <a href="#">username1</a>
                                                                            <p> Proin vestibulum sed leo ac euismod. </p>
                                                                        </li>
                                                                        <li class="comment">
                                                                            <a href="#">username2</a>
                                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras et ex eget purus pellentesque gravida. Praesent risus nisl, fermentum eu tortor elementum, malesuada tempus elit.</p>
                                                                        </li>-->
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.html" %>

        <script type="text/javascript">
            document.title = "<%= currentImage.getImagename()%>";
        </script>
        <script type="text/javascript">
            var imageID = "<%= currentImage.getImageID()%>";
        </script>
        <script src="js/displayCommentsAJAX.js" type="text/javascript"></script>  
    </body>
</html>

