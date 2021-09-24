<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<%@page import="java.util.*,com.reconnect.model.*" %>
<%
    List<Contact> contactList = (List<Contact>)request.getAttribute("contactList");
    pageContext.setAttribute("contact", contactList); 
%>
<h3><a href="http://localhost:8080/CodeFury/AddContact.html" >Add Contact</a></h3>
<h2>All contacts of the user</h2>
    <table border="1">
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
       <td><a href="../ContactController/<%= c.getFname() %>/<%= c.getLname() %>/<%= c.getEmail() %>/<%= c.getPhone() %>">Delete Contact</a></td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>