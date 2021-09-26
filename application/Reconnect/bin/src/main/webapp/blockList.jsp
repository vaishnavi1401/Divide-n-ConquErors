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
             <form  action="BlockUserServlet?ac=UnBlockUser" method="post">
                        
                 <input type="text" name="user_name" placeholder="Username" required onchange="validateUserName()">
                 
                 <button type="submit" name="unblock_submit">UnBlock</button>
             </form>
</body>
</html>