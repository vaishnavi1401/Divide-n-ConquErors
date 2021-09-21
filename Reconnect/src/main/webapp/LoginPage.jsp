<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LoginPage</title>
        <link rel="stylesheet" href="login_css.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="toggle_btn.js"></script>
        <script src="loginUser.js"></script>
        <script src="loginAdmin.js"></script>
    </head>
    <body>
        <div class="main_page">
            <div class="forms_view">
            <div class="form-box">

                <div class="toggle_btns">
                    <div id="btn"></div>
                    <button type="button" class="toggle_login" onclick="toggleUser_to_Admin()">User</button>
                    <button type="button" class="toggle_login" onclick="toggleAdmin_to_User()">Admin</button>
                </div>

                <div class="social_nw">
                    <img src="assets/facebook.png" id="facebook">
                    <img src="assets/twitter.png" id="twitter">
                    <img src="assets/linkedin.png" id="linkedin">
                    <img src="assets/email.png" id="mail">
                </div>
                <div class="input_group">
<<<<<<< HEAD:Reconnect/src/main/webapp/LoginPage.html
                    <form class="input_group_user" id="appUser" action="" method="" onclick="loginAsUser()">
                        <thead><b>User Login Credentials</b></thead>
                        <input type="text" class="user_input_field" id="user_name" name="user_name" placeholder="Username" required onchange="validateUserName()">
                        <div id="usr_nm_check"></div>
                        <input type="text" class="user_input_field"id="user_pwd" name="user_pwd" placeholder="Password" required onchange="validateUserPwd()">
                        <div id="usr_pwd_check"></div>
                        <button type="submit" class="user_login_btn" id="user_submit" name="user_submit">Log in</button>
=======
                    <form class="input_group_user" action="UserLoginServlet" id="appUser" method="post">
                        <thead><b>User Login Credentials</b></thead>
                        <input type="text" class="user_input_field" placeholder="Username" name="username" required>
                        <input type="text" class="user_input_field" placeholder="Password" name="password" required>
                        <button type="submit" class="user_login_btn">Log in</button>
>>>>>>> cc174a9ec9a13a67307729cb0f865a2acaa732b9:Reconnect/src/main/webapp/LoginPage.jsp
                    </form>
                    <form class="input_group_user" id="admin" action="validate" method="post">
                        <thead ><b>Administrator Login Credentials</b></thead>
                        <input type="text" class="user_input_field" id="admin_username" name="admin_username" placeholder="Admin username" required onchange="validateAdminName()">
                        <div id="admin_nm_check"></div>
                        <input type="text" class="user_input_field" id="admin_pwd" name="admin_pwd" placeholder="Password" required onchange="validateAdminPwd()">
                        <div id="admin_pwd_check"></div>
                        <button type="submit" class="user_login_btn" id="admin_submit" name="admin_submit">Log in</button>
                        <div id="editresult"></div>
                    </form>
                    
                   <center>${ message }</center> 
                </div>
            </div>    
           
        </div>
    </body>

</html>
