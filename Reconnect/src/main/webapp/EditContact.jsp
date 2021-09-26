<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<title>
            User Portal
        </title>
        <link rel="stylesheet" href="register_css.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

   		
		<style>
			.icon-bar {
			  top:0;
			  left:0;
			  right:0;	
			  width: 100%; 
			  height : 11vh;
			  background-color: #101010; 
			  position: fixed;
			}
			
			.icon-bar a {
			  float: left; 
			  text-align: center; 
			  width: 20%; 
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
			  background-color: whitesmoke;
			  border:1px solid white;
			  color:black;
			}
		
			.active {
			  margin:2vh;
			  padding:5vh;
			  border:1px solid white; /* Add an active/current color */
			}
			
			.logo{
				margin-left: 5vh; 
				margin-bottom:3vh; 
				padding:1px;
				font-size: 35px;
				font-weight: bold;
				font-family: sans-serif;
				pointer-events: none;
			}
			#contactsTable {
			  border-collapse: collapse;
			  margin-top:20vh;
			  width: 100%;
			}
			
			#contactsTable th{
				
				background: black;
				color:white;
			}
			
			#contactsTable th, td {
			  text-align: center;
			  padding: 15px;
			 
			}

			#contactsTable tr:nth-child(even) {
				background-color: #f2f2f2;
				
			}
			
			.center-container{
			
				margin-top:20vh;
			}	  
		</style>
		
		<script>
			function viewTable() {
			    var lTable = document.getElementById("contactsTable");
			    lTable.style.display = (lTable.style.display == "table") ? "none" : "table";
			    document.getElementById("addNew").style.display="none";
			}
			
			function newContactForm(){
				 var lTable = document.getElementById("addNew");
				 lTable.style.display = (lTable.style.display == "table") ? "none" : "table";
				 document.getElementById("contactsTable").style.display="none";
			}
		</script>
		
	</head>

	<body>
			<% String val = request.getParameter("email"); %>
			<% String name = request.getParameter("name"); %>
			<%session.setAttribute("emailEdit", val);%>
			
			<div class="main-container">
				<div class="nav-side">
					<div class="icon-bar"> 
						<div id="right-container">
							<a id="logo">ReConnect</a>
							<a onclick="newContactForm()"><i class="fa fa-plus"></i></a>
		              		<a onclick="viewTable()"><i class="fa fa-eye" aria-hidden="true"></i></a>
							<a href="blockList.jsp"><i class="fa fa-ban" aria-hidden="true"></i></a>
		              	
						</div> 
	            	</div>
				</div>
			</div>
			<div class="center-container">
					<form class="register-form" id="register-form" action="ContactController/editContact">  
				        <div id="checkform"></div>
						<div class="form-body">
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="firstname" class="label-title">First Name *</label>
			                    <input type="text" id="contactEditFname" value="<%=name%>" name="contactEditFname" class="form-input" placeholder="Enter your first name" required="required" />
			                </div>
			                <div class="form-group right">
			                    <label for="lastname" class="label-title">Last Name *</label>
			                    <input type="text" id="contactEditLname" name="contactEditLname" class="form-input" placeholder="Enter your last name" />
			                </div>
			            </div>
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label class="label-title">Gender *</label>
			                    <div class="input-group">
			                    	<select type="text" id="contactEditGender" name="contactEditGender" placeholder="Gender" required>   
										<option value="Female">Female</option>
										<option value="Male">Male</option>
										<option value="Others">Others</option>
									</select>
			                    </div>
			                </div>
			            
			                <div class="form-group right">
			                    <label for="birthday" class="label-title">Date Of Birth *</label>
			                    <input type="date" class="form-input" id="contactEditDob" name="contactEditDob" required="required" onchange="validateBirthday()">
			                    <div id="birthday_check"></div>
			                </div>
			            </div>  
			
			            <div class="form-group right">
			                <label for="address" class="label-title">Address *</label>
			               <input type="text" class="form-input" id="contactEditAddress" name="contactEditAddress" placeholder="Enter your address" required="required">
			           </div>  
			
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="city" class="label-title">City *</label>
			                    <input type="text" id="contactEditCity" name="contactEditCity" class="form-input" placeholder="Enter city name" required="required">
			                </div>
			            
			                <div class="form-group right">
			                    <label for="state" class="label-title">State *</label>
			                    <input type="text" class="form-input" id="contactEditState" name="contactEditState" placeholder="Enter state" required="required">
			                </div> 
			            </div>
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="country" class="label-title">Country *</label>
			                    <input type="text" class="form-input" id="contactEditCountry" name="contactEditCountry" placeholder="Enter country" required="required">
			                </div>  
			                <div class="form-group right">
			                    <label for="phone" class="label-title">Phone *</label>
			                    <input type="number" id="contactEditPhone" name="contactEditPhone" class="form-input" placeholder="Enter your phone number" required="required" onchange="validatePhone()">
			                    <div id="phone_check"></div>
			                </div>
			            
			            </div>
			            <div class="form-group">
			                <label for="email" class="label-title">Email *</label>
			                <input type="email"  value="<%=val%>" id="contactEditEamil" name="contactEditEamil" class="form-input" placeholder="Enter your email" required="required" disabled>
			                <div id="email_check"></div>
			            </div>
			            
			            <div class="horizontal-group">
			                <div class="form-group left" >
			                    <label for="company" class="label-title">Company *</label>
			                    <input type="text" class="form-input" id="contactEditCompany" name="contactEditCompany" placeholder="Enter Company Name" required="required">
			                </div>
			                <div class="form-group right" >
			                      <label for="choose-file" class="label-title">Upload Profile Picture *</label>
			                      <input type="file" id="profileEditPic" name="profileEditPic" size="20" required="required" accept="image/gif, image/jpeg, image/png">
			                </div>
			                    
			            </div>
			       
			        </div>
			         <div class="form-footer">
			            <input id = "submit" type="submit" value="Submit" class="submit" style="margin-left: 40vh; margin-bottom: 2vh"/>
			        </div>	
		    	</form>
			</div>		

</body>
</html>