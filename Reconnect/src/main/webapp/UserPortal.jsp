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
    </head>
    <body>
        <div class="icon-bar left-container">
                <!-- <a class="active" href="#"><i class="fa fa-home"></i></a>
                <a href="#" ><i class="fa fa-search"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/ViewContacts.html" target="_blank"><i class="fa fa-address-book" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-users"></i></a>
                <a href="#"><i class="fa fa-ban" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-power-off"></i></a> -->
                <a class="active" href="http://127.0.0.1:5500/JS/HTML/CSS/UserPortal.html" target="_blank"><i class="fa fa-home"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/SearchContact.html" target="_blank"><i class="fa fa-search"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/ViewContacts.html" target="_blank"><i class="fa fa-address-book" aria-hidden="true"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/Friends.html" target="_blank"><i class="fa fa-users"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/BlockedUser.html" target="_blank"><i class="fa fa-ban" aria-hidden="true"></i></a>
                <a href="http://127.0.0.1:5500/JS/HTML/CSS/LoginPage.html" ><i class="fa fa-power-off"></i></a>
        </div>
        <div class="middle-container">
            <div class="search-box-container">
                <input type="search" class = "search-bar"> 
                <a href="#"><i class="fa fa-search"></i></a>
            </div>
        </div>
        </div>
        <div class="right-container">
        </div>
        
<div>
<form action="DisplayUserDetailServlet" method="post">
<button type="submit" name="block_user">Show My Details</button>
</form>

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<table>
	<tr><td><img src="F:/HSBCTraining/${mydata.username}" alt="My Photo"></td></tr>							
	<tr><td><jstlcore:out value="${mydata.username}"></jstlcore:out></td></tr>
	<tr><td><jstlcore:out value="${mydata.fname}"></jstlcore:out></td></tr>
	<tr><td><jstlcore:out value="${mydata.lname}"></jstlcore:out></td></tr>
	<tr><td><jstlcore:out value="${mydata.city.city}"></jstlcore:out></td></tr>
	<tr><td><jstlcore:out value="${mydata.city.state}"></jstlcore:out></td></tr>
	<tr><td><jstlcore:out value="${mydata.city.country}"></jstlcore:out></td></tr>
	       
    </table>
</div>

</body>
</html>