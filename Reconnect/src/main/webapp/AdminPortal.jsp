<%@ page language="java" import="java.util.HashMap,com.reconnect.model.Admin" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Portal</title>
<link rel="stylesheet" href="admin_portal.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="navigate_admin.js"></script>
</head>
<script>
	
</script>
<body>
	<div class="main_page">
		<div id="navbar">
			<a href="#default" id="logo">CompanyLogo</a>
			<div id="navbar-right">
				<a class="active" href="#home" target="_self"><i
					class="fa fa-home"></i> Home</a> <a
					href="D:\code_fury_hsbc\Divide-n-ConquErors\Reconnect\src\main\webapp\statistics.html"><i
					class="fa fa-line-chart"></i> Statistics</a> <a href="#logout"><i
					class="fa fa-power-off" aria-hidden="true"></i> Logout</a>
			</div>
		</div>
		<div class="image_side">
			<img src="assets/admin_vector_side.jpg">
		</div>
		<div class="body_side">
			<div class="container_left">
				<div class="flip-card">

					<div class="flip-card-inner">

						<div class="flip-card-back">
							<% Admin ad=(Admin)request.getAttribute("ad");
						
							%>
							<h1>Personal Details</h1>
							<p><%=ad.getName() %></p>
							<p><%=ad.getUsername() %></p>
							
							
						</div>
						<div class="flip-card-front">
							<h1>Location</h1>
							<p>Pune</p>
							<p>India</p>
							<img src="assets/contacts_flip.png"><img>
						</div>
					</div>
				</div>
			</div>
			<div class="container_right">
				<div class="flip-card">

					<div class="flip-card-inner">

						<div class="flip-card-back">
						
							<h1>Email</h1>
							<p><%=ad.getEmail() %></p>
							<p></p>
						</div>
						<div class="flip-card-front">
							<h1>Contact</h1>
							<p>Phone</p>
							<p><%=ad.getPhone_number()%></p>
							<img src="assets/contacts_flip.png"><img>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
