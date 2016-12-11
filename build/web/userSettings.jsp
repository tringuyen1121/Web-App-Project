<%-- 
    Document   : userSettings
    Created on : Dec 11, 2016, 1:12:10 AM
    Author     : A
--%>

<%@page import="com.creatopia.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Settings</title>
        <link href="css/userSetting.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin|Josefin+Sans" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <%
            Users currentUser = (Users) session.getAttribute("currentUser");
        %>
        <main>
            <h3 class="title"> SETTINGS </h3><br>
            <form method="post" id="setting-form" action="ChangeUserSettings" enctype="multipart/form-data">
                <input class="large hidden" type="text" id="user-userID" name="userID" value="<%= currentUser.getUserID()%>">
                <label for="user-password">Change Password:</label>
                <input class="large" type="password" id="user-password" name="password" pattern="^[A-Za-z0-9]{6,50}$" title="Password can only contains letters and numbers" required>
                <label for="user-password">Retype Password:</label>
                <input class="large" type="password" id="retypePassword" name="retypePassword" pattern="^[A-Za-z0-9]{6,50}$" required>
                <label for="user-fname">Change First Name:</label>
                <input class="large" type="text" id="user-fname" name="fname" pattern="^[A-Za-z\s']{3,50}$" title="Invalid name" required>
                <label for="user-lname">Change Last Name:</label>
                <input class="large" type="text" id="user-lname" name="lname" pattern="^[A-Za-z.\s']{3,50}$" title="Invalid name" required>
                <input class="gender" type="radio" name="gender" value="male" required><span>Male</span>
                <input class="gender" type="radio" name="gender" value="female"><span>Female</span><br>
                <label for="user-email">Change Email:</label>
                <input class="large" type="email" id="user-email" name="email" required>
                <label for="user-avatar">Change Avatar:</label>
                <input id="browse-avatar" class="button" type="button" value="Browse"/>
                <input class="large hidden" type="file" id="user-avatar" name="avatar">
                <label for="user-bio">Change Bio:</label>
		<textarea class="large" rows="4" id="user-bio" name="bio" placeholder="Write something about you..."></textarea>
                <input type="submit" id="submit" name="submit" value="SUBMIT">
            </form>
        </main>

        <%@ include file="footer.html" %>

        <script>
            var form = document.getElementById('setting-form');

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
        <script>
		document.getElementById('browse-avatar').addEventListener('click',function(){
			document.getElementById('user-avatar').click();
		});
	</script>

    </body>
</html>
