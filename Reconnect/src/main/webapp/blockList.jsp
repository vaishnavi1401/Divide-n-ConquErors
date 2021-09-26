<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
		<meta charset="ISO-8859-1">
		<title>BlockList</title>
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

/* input[type=text]:focus {
  border: 3px solid #555;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}

table {
  border-collapse: collapse;
}
body {
  background-color: lightblue;
}
th, td {
  border-bottom: 1px solid #ddd;
  padding: 10px;
  text-align: center;
}
th{
background-color: #00cccc;
}
tr:hover {background-color: #D6EEEE;}

button {
  background-color: #008CBA;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

 */
 
 body{
		background-color: whitesmoke;
		font-family: Arial, Helvetica, sans-serif;
		
		}
		 .main-container{

			width: 100vh;
			height: 50vh;
			margin-top:20vh;
			margin-left: 50vh
			
			
		}		
		.add-ontact-form {
		top:0;
		margin-top:120vh;
	    font-family: sans-serif;
	    width:670px;	    
	   
	    border-radius: 10px;
	    background-color:whitesmoke;
	  }
	  
	  .form-header  {
	    background:linear-gradient(to right, #28b4df, rgb(57, 97, 206));
	    border-top-left-radius: 10px;
	    border-top-right-radius: 10px;
	  }
	  
	  .form-header h1 {
	    font-size: 30px;
	    text-align:center;
	    color:rgb(18, 19, 19);
	    padding:20px 0;
	    border-bottom:1px solid #b0b7df;
	  }
	
	  .form-body {
	    padding:10px 40px;
	    color:#666;
	  }
	  
	  .form-group{
	    margin-bottom:20px;
	  }
	  
	  .form-body .label-title {
	    color:#3f3d3d;
	    font-size: 17px;
	    font-weight: bold;
	    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;  
	  }
	  
	  .form-body .form-input {
	      font-size: 17px;
	      box-sizing: border-box;
	      width: 100%;
	      height: 34px;
	      padding-left: 10px;
	      padding-right: 10px;
	      color: #333333;
	      text-align: left;
	      border: 1px solid #888585;
	      border-radius: 11px;
	      background: white;
	      outline: none;
	  }
	
	  .horizontal-group .left{
	    float:left;
	    width:49%;
	  }
	  
	  .horizontal-group .right{
	    float:right;
	    width:49%;
	  }
	  
	  input[type="file"] {
	    margin-top: 5px;
	   outline: none;
	   cursor:pointer;
	   font-size: 17px;
	  }
	  
	  #range-label {
	   width:15%;
	   padding:5px;
	   background-color: #1BBA93;
	   color:white;
	   border-radius: 5px;
	   font-size: 17px;
	   position: relative;
	   top:-8px;
	  }
	  
	  ::-webkit-input-placeholder {
	   color:#d9d9d9;
	  }
	  
	 .form-footer {
	   clear:both;
	  }
	
	  .signup-form .form-footer  {
	    background-color: #EFF0F1;
	    border-bottom-left-radius: 10px;
	    border-bottom-right-radius: 10px;
	    padding:10px 40px;
	    text-align: right;
	    border-top: 1px solid #cccccc;
	  }
	  
	  .form-footer span {
	    float:left;
	    margin-top: 10px;
	    color:#999;  
	    font-style: italic;
	    font-weight: thin;
	  }
	  
	  .btn {
	     display:inline-block;
	     padding:10px 20px;
	     background:linear-gradient(to left,hsl(197, 80%, 48%), rgb(108, 76, 221));
	     font-size:17px;
	     border:none;
	     border-radius:5px;
	     color:#bcf5e7;
	     cursor:pointer;
	  }
	  
	  .btn:hover {
	    background:linear-gradient(to right, hsl(308, 80%, 48%), rgb(108, 76, 221));
	    color:white;
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
			 width:30vh;
			 padding: 2px; 
			 margin-top:2vh;
			 margin-bottom:5vh;
			 margin-left:2vh;
			 transition: all 0.3s ease; 
			 color: white; 
			 font-size: 35px;
		}			
		.icon-bar a:hover{
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
				  width: 100%;
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

 
</style>
<script type="text/javascript">
		function showTable(){
			
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
					<a onclick="newContactForm()"><i class="fa fa-user-times" aria-hidden="true"></i></a>
              		<a href="BlockUserServlet?ac=showBlockUsers"><i class="fa fa-list-ol" aria-hidden="true"></i></a>
				</div> 
            </div>
            <div>
            	<!-- <form action="BlockUserServlet?ac=showBlockUsers" method="post">
					<button type="submit" name="block_user">Show Blocked Users</button>
		         </form>
			   -->
			<br> 
			 
			<table id="myTable">
			  
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

			<form  action="BlockUserServlet?ac=UnBlockUser" method="post">
			     Enter Username to unblock : <input type="text" name="user_name" required">
			     <button type="submit" name="unblock_submit">UnBlock</button>
			</form>
            </div>
		</div>
	</div>
		
</body>
</html>

<!-- <center >
				
			</center> 
 -->