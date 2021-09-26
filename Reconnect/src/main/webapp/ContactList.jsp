<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>
            User Portal
        </title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

		<style>
	
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
				
				
		.form-side{
					margin-top:20vh;
		}
	
			
		</style>
		
		<script>
			function viewTable() {
			    var lTable = document.getElementById("contactsTable");
			    lTable.style.display = (lTable.style.display == "table") ? "none" : "table";
			    document.getElementById("add-contact-form").style.display="none";
			}
			
			function newContactForm(){
				 var lTable = document.getElementById("add-contact-form");
				 lTable.style.display = (lTable.style.display == "block") ? "none" : "block";
				 document.getElementById("contactsTable").style.display="none";
			}
		</script>
		
	</head>
<body>
<%@page import="java.util.*,com.reconnect.model.*" %>
<%
    List<Contact> contactList = (List<Contact>)request.getAttribute("contactList");
    pageContext.setAttribute("contact", contactList); 
%>

	<div class="main-container">
		<div class="nav-side">
			
			<div class="icon-bar"> 
				<div id="right-container">
					<a id="logo">ReConnect</a>
					<a onclick="newContactForm()"><i class="fa fa-plus"></i></a>
              		<a onclick="viewTable()"><i class="fa fa-eye" aria-hidden="true"></i></a>
				</div> 
            </div>
		</div>
		
		<div id="form-block">
			<form action="ContactController/addContact" id="add-contact-form" hidden="true" >
				        <div id="checkform"></div>
						<div class="form-body">
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="firstname" class="label-title">First Name *</label>
			                    <input type="text" id="contactEditFname" name="contactEditFname" class="form-input" placeholder="Enter your first name" required="required" />
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
			                <input type="email" id="contactEditEamil" name="contactEditEamil" class="form-input" placeholder="Enter your email" required="required">
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
	
		<div class="table-side">
			<form action="ContactController/viewContactMain" method="get">
			<table id="contactsTable" border="1" hidden="true" style="overflow-x: auto; overflow-y: auto;">
				        <tr>
				            <th>First name</th>
				            <th>Last name</th>
				            <th>Email</th>
				            <th>Phone</th>
				            <th>City</th>
				            <th>Options</th>
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
				       <td>
				       		<a href="http://localhost:8080/Reconnect/EditContact.jsp?email=<%= c.getEmail() %>&name=<%= c.getFname() %>">Edit Contact</a><br>
				       		<a href="../ContactController/<%= c.getFname() %>/<%= c.getLname() %>/<%= c.getEmail() %>/<%= c.getPhone() %>">Delete Contact</a>
				       	</td>
				        </tr>
				        <%
				        }
				        %>
	   		</table>
	   		</form>
		
		</div>
			
	</div>
    
</body>
</html>



<!-- <table id="addNew" hidden="true">
				<tr> 
					<td>
						<input type="text" name="contactFname" id="contactFname" placeholder="First Name" required/>  
					</td>
					<td>		
						<input type="text" name="contactLname" id="contactLname" placeholder="Last Name" required/>  
					</td>
				</tr>	
                <tr>	 
					<td>
						<input type="email" id="contactEamil" name="contactEamil" placeholder="Email" required/>   
					</td>
				</tr>
				<tr>	 
					<td>
						<select type="text" id="contactGender" name="contactGender" placeholder="Gender" required>   
						<option value="Female">Female</option>
						<option value="Male">Male</option>
						<option value="Others">Others</option>
						</select>
					</td>
				</tr>
				<tr> 
					<td>
						<input type="text" name="contactPhone" id="contactPhone" placeholder="Phone Number" required/>  
					</td> 
				</tr>
                <tr> 
					<td>
						<input type="date" name="contactDob" id="contactDob" placeholder="Date of Birth" required/>  
					</td> 
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactAddress" name="contactAddress" placeholder="Address" required/>   
					</td>
                    <td>
						<input type="text" id="contactCity" name="contactCity" placeholder="City" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactState" name="contactState" placeholder="State" required/>   
					</td>
                    <td>
						<input type="text" id="contactCountry" name="contactCountry" placeholder="Country" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactCompany" name="contactCompany" placeholder="Company Name" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="file" id="profilePic" name="profilePic"  required/>   
					</td>
				</tr>
				<tr>
					<td>
						<input id = "submit" type="submit" value="Submit" class="submit" />  
					</td>
				</tr>
			</table> -->