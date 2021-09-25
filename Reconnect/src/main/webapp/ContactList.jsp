<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
<%@page import="java.util.*,com.reconnect.model.*" %>
<%
    List<Contact> contactList = (List<Contact>)request.getAttribute("contactList");
    pageContext.setAttribute("contact", contactList); 
%>
<h3><a href="http://localhost:8080/CodeFury/AddContact.html" >Add Contact</a></h3>
<h2>All contacts of the user</h2>
    <table border="1" style="width:90%" bgcolor="#ccffff">
        <tr>
            <th>Contact first name</th>
            <th>Contact last name</th>
            <th>Contact emailID</th>
            <th>Contact phone number</th>
            <th>Contact city</th>
        </tr>
        <%
        for(Contact c:contactList)
        {
        %>
        <tr>
        <td><%= c.getFname() %></td>
        <td><%= c.getLname() %></td>
        <td><%= c.getEmail() %></td>
        <td><%= c.getPhone() %></td>
        <td><%= c.getCity1().getCity() %></td>
       <td><a href="http://localhost:8080/CodeFury/EditContact.jsp?email=<%= c.getEmail() %>&name=<%= c.getFname() %>">Edit Contact</a></td> 
       <td><a href="../ContactController/<%= c.getEmail() %>">Delete Contact</a></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>