
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
		<style type="text/css">
		
			a .tooltip{
				  visibility: hidden;
				  width: 150px;
				  background-color: black;
				  color: #fff;
				  text-align: center;
				  font-size:20px;
				  border-radius: 6px;
				  padding: 5px 0;
				  position: absolute;
				  z-index: 1;
				  margin-top: 2vh;
				  opacity: 0.75;
			}
			
			a:hover .tooltip{
				visibility: visible;
			}
			
		.option-block{
			width:150vh;
			height:60vh;
			margin-top: 15vh;
		}
		
		.option-block-one{
			width:70vh;
			height:70vh;
			background-color: white;
			position: fixed;
			margin-left:80vh;
			position: relative;
		}
		img{
			margin-left: 18vh;
		}
		button{
			border:1px solid black;
		}
		</style>
   
    </head>
    <body>
    	<input type="text" id="info" value="<%= session.getAttribute("message") %>">
        <div class="main_container">
            <div class="icon-bar">
                <a id="logo">ReConnect</a>
                <a href="FriendsPortal.jsp"><i class="fa fa-users" aria-hidden="true"></i><div class="tooltip">Friends</div></a>
                <a href="redirectContact.jsp"><i class="fa fa-address-book" aria-hidden="true"></i><div class="tooltip">Contacts</div></a>
                <a href="blockList.jsp"><i class="fa fa-ban" aria-hidden="true"></i><div class="tooltip">Blocked Users</div></a>
                <a href="LandingPage.jsp" target="_blank" onchange="navigate_to_login()"><i class="fa fa-power-off"></i><div class="tooltip">Logout</div></a>
            </div>
         </div>
         <div class="option-block">
			
			<div class="option-block-one">
					<img src="assets/profile.jpg" onclick="window.location.href='DisplayUserDetailServlet';">
					<div class="user-details">
													
							<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>      
								<center>
								<h3>Click Profile Image to View Your Details</h3><br>
									<table>
									<tr><td><jstlcore:out value="${mydata.username}"></jstlcore:out></td>
									<tr><td>First Name  :<jstlcore:out value="${mydata.fname}"></jstlcore:out></td></tr>
									<tr><td>Last Name  :<jstlcore:out value="${mydata.lname}"></jstlcore:out></td></tr>
									<tr><td>City  :<jstlcore:out value="${mydata.city.city}"></jstlcore:out></td></tr>
									<tr><td>State  :<jstlcore:out value="${mydata.city.state}"></jstlcore:out></td></tr>
									<tr><td>Country  :<jstlcore:out value="${mydata.city.country}"></jstlcore:out></td></tr>
							    </table>
								</center>
								
						</div>
			</div>
			<div class="option-block-two"></div>
		</div>
   
    </body>
</html>
