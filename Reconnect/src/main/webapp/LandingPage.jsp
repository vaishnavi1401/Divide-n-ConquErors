<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" >
    <link rel="stylesheet" href="mainpage.css">
    <title>Document</title>
</head>
<body>
        <div id="body_conatiner_tag">
            <div class=" heading_mainpage">
                <h1 id="heading_text">ReConnect </h1>
            </div>
                
            <div class="body_container">
                <div class="left_container">       
                    <div class="info_div_tag">   
                    	<p id="info_mainpage">Register.<br>Recognize.<br>Reconnect.</p>
   					
              
                    </div>           
                </div>
                <div class="right_container">
                    <div class="tab_container">  
                        <img src="assets/main_page.jpg" alt="" id="right_container_img">
                        <div  id="user_login_tab">
                            <button class="btn" value="Login" onclick="window.location.href='LoginPage.jsp'">Login</button>
                        </div>
                        <div  id="register_login_tab">
                            <button class="btn" onclick="window.location.href='RegistrationPage.jsp'">Register</button>
                        </div>
                    </div>   
                </div>
            </div>
        </div>
    </body>
</html>