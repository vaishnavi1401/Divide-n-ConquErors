<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
		<meta charset="ISO-8859-1">
		<title>BlockList</title>
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>


 
 body{
		background-color: whitesmoke;
		font-family: Arial, Helvetica, sans-serif;
		
		}
		 .main-container{

			width: 100vh;
			height: 20vh;
			margin-left: 40vh;
			margin-bottom: 5vh;
			
			
		}
		
	.unblock-body{
		margin-top: 20vh;
		position: relative;
	}		
	 .main-container .form-body{
		margin-top: 5vh;
	}
	
	

	 .icon-bar {
		 top:0;
		 left:0;
		 right:0;	
		 width: 100%; 
		 height : 11vh;
		 background-color: #181818; 
		 position: fixed;
		}
		.icon-bar a {
			 float: left; 
			 text-align: center; 
			 width:40vh;
			 padding: 2px; 
			 margin-top:2vh;
			 margin-bottom:5vh;
			 margin-left:2vh;
			  -webkit-transition: width .2s;
			 color: white; 
			 font-size: 35px;
		}			
		.icon-bar a:hover{
			      width: 35vh;
				  padding-top:1.5vh;
				  background:linear-gradient(rgb(68, 98, 197), rgb(116, 181, 235) );
				  border:1px solid white;
				  color:black;
		}
		.active {
				  margin:2vh;
				  padding:5vh;
				  border:1px solid white;
				  
				}
				
		.logo{
					margin-left: 5vh; 
					margin-bottom:3vh; 
					padding:1px;
					font-size: 35px;
					font-weight: 20px;
					font-family: sans-serif;
					cursor: pointer;
		}
		#myTable {
				  border-collapse: collapse;
				  margin-top:20vh;
				  width: 150vh;
		}
				
		#myTable th{
					
					background: black;
					color:white;
		}
				
		#myTable th, td {
				  text-align: center;
				  padding: 15px;
				 
		}
	
		#myTable tr:nth-child(even) {
					background-color: #f2f2f2;
					
		}
				
				
		.form-side{
					margin-top:20vh;
		}
		
		a .tooltip{
				  visibility: hidden;
				  width: 160px;
				  background-color: black;
				  color: #fff;
				  text-align: center;
				  font-size:20px;
				  border-radius: 6px;
				  padding: 8px 0;
				  position: absolute;
				  z-index: 1;
				  margin-top: 2vh;
				  opacity: 0.75;
			}
			
			a:hover .tooltip{
				visibility: visible;
			}
 
</style>
<script type="text/javascript">
		
		function callMultiple(){
			
			document.getElementById('forms-val').submit();
			var lTable = document.getElementById("myTable");
			lTable.style.display = (lTable.style.display == "table") ? "none" : "table";
		}
</script>

</head>

<body>
	
	<div class="main-container">
		<div class="nav-side">
			
			<div class="icon-bar"> 
				<div id="right-container">
					<a id="logo">ReConnect</a>
					<form action="BlockUserServlet?ac=showBlockUsers" method="post" id="forms-val">
              			<a class="active" onclick="callMultiple()"><i class="fa fa-list-ol" aria-hidden="true"></i>
              				<div class="tooltip" style="font-size: 15px">Check your Block List...</div>
              				<span style="font-size: 23px;font-style: italic;">BlockList</span>
              			</a>
              		</form>
				</div> 
            </div>
            <div class="unblock-body">
	            <form  action="BlockUserServlet?ac=UnBlockUser" method="post">
				     Enter Username to unblock : <input type="text" name="user_name" required">
				     <button type="submit" name="unblock_submit">UnBlock</button>
				</form>
			</div>
            <div class="form-body">
					<table id="myTable" border="1">
					  
					  <tr>
					    <th>USERNAME</th>
					    <th>FIRST NAME</th>
					    <th>LAST NAME</th>
					    <th>CITY</th>
					    <th>STATE</th>
					    <th>COUNTRY</th>
					  </tr> 
					  
						<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
						
						<jstlcore:forEach items="${data}" var="regEvent">
						
					    <tr>								
						<td><jstlcore:out value="${regEvent.username}"></jstlcore:out></td>
						<td><jstlcore:out value="${regEvent.fname}"></jstlcore:out></td>
						<td><jstlcore:out value="${regEvent.lname}"></jstlcore:out></td>
						<td><jstlcore:out value="${regEvent.city.city}"></jstlcore:out></td>
						<td><jstlcore:out value="${regEvent.city.state}"></jstlcore:out></td>
						<td><jstlcore:out value="${regEvent.city.country}"></jstlcore:out></td>
						</tr>
						
						</jstlcore:forEach>
					             
					</table>

			
            </div>
		</div>
	</div>
		
</body>
</html>

<!-- <center >
				
			</center> 
 -->