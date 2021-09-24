<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlockList</title>
</head>
<body>
			<form action="BlockUserServlet?ac=showBlockUsers" method="post">
         
                 
                 <button type="submit" name="block_user">Show Blocked Users</button>
             </form>
             
             <br>
             <br>
             <br>
             <form  action="BlockUserServlet?ac=UnBlockUser" method="post" ">
                        
                 <input type="text" name="user_name" placeholder="Username" required onchange="validateUserName()">
                 
                 <button type="submit" name="unblock_submit">UnBlock</button>
             </form>
=======
+<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>BlockList</title>

<style>
input[type=text]:focus {
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


</style>

</head>

<body>


<center >
			<form action="BlockUserServlet?ac=showBlockUsers" method="post">
			    		<button type="submit" name="block_user">Show Blocked Users</button>
             </form>
        
      
<br> 
 
<table style="width:90%" bgcolor="#ccffff">
  
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
             
             +</table>
            
<br>
<br>
<br>
   
<form  action="BlockUserServlet?ac=UnBlockUser" method="post">
     Enter Username to unblock : <input type="text" name="user_name" required">
     <button type="submit" name="unblock_submit">UnBlock</button>
</form>
</center> 

>>>>>>> e1585f11a1ada8c9d4b773e935447e0819f20cba
</body>
</html>