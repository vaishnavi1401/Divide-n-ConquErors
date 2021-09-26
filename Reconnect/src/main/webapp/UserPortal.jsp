
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            User Portal
        </title>
        <link rel="stylesheet" href="user_portal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

   		
   		<script type="text/javascript">
   		
   		</script>
   
    </head>
    <body>
    	<input type="text" id="info" value="<%= session.getAttribute("message") %>">
        <div class="main_container">
            <div class="icon-bar">
                <a id="logo">ReConnect</a>
                <a href="FriendsPortal.jsp"><i class="fa fa-users" aria-hidden="true"></i></a>
                <a href="index.html"><i class="fa fa-address-book" aria-hidden="true"></i></a>
                <a href="blockList.jsp"><i class="fa fa-ban" aria-hidden="true"></i></a>
                <a href="LandingPage.jsp" target="_blank" onchange="navigate_to_login()"><i class="fa fa-power-off"></i></a>
            </div>
         </div>
         
   
    </body>
</html>
