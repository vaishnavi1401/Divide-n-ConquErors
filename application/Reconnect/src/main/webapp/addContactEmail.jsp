<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@page import="java.util.*,com.reconnect.model.*" %>
	<%
	    User user = (User)request.getAttribute("UserObj");
	    pageContext.setAttribute("userDetails", user); 
	%>
	
	<style>
		body{
				background: whitesmoke;
				font-family: Arial, Helvetica, sans-serif;
			}
			 
		  .register-form {
		    font-family: sans-serif;
		    width:50vh;
		    margin-left:50vh;
		    background:linear-gradient(to right, #ffffff 0%, #fafafa 50%, #ffffff 99%);
		    border: 2px solid black;
		    border-radius: 10px;
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
		  	margin-top:20vh;
		  	width:80%;
		  	
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
		
	</head>
	<body>
		<div class="main-container">
		<div class="nav-side">
			
			<div class="icon-bar"> 
				<div id="right-container">
					<a id="logo">ReConnect</a>
				</div> 
            </div>
			</div>
            <form action="../ContactController/addContact">
            <div class="form-body">
            			<div class="form-header">
	          		  			<h1>Add New Contact</h1>
	       				</div>
	       				<h4><font color="red">This Contact is an Existing User With same email Id</font></h4>
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="firstname" class="label-title">First Name *</label>
			                    <input type="text" id="contactEditFname" name="contactEditFname"  value=<%= user.getFname() %> class="form-input" placeholder="Enter your first name" required="required" />
			                </div>
			                <div class="form-group right">
			                    <label for="lastname" class="label-title">Last Name *</label>
			                    <input type="text" id="contactEditLname" name="contactEditLname" value=<%= user.getLname() %> class="form-input" placeholder="Enter your last name" />
			                </div>
			            </div>
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label class="label-title">Gender *</label>
			                    <div class="input-group">
			                    	<select type="text" id="contactEditGender" name="contactEditGender" value=<%= user.getGender() %> placeholder="Gender" >   
										<option value="Female">Female</option>
										<option value="Male">Male</option>
										<option value="Others">Others</option>
									</select>
			                    </div>
			                </div>
			            
			                <div class="form-group right">
			                    <label for="birthday" class="label-title">Date Of Birth *</label>
			                    <input type="date" class="form-input" id="contactEditDob" name="contactEditDob" value=<%= user.getDob() %> onchange="validateBirthday()">
			                    <div id="birthday_check"></div>
			                </div>
			            </div>  
			
			            <div class="form-group right">
			                <label for="address" class="label-title">Address *</label>
			               <input type="text" class="form-input" id="contactEditAddress" name="contactEditAddress" value=<%= user.getAddress() %> placeholder="Enter your address">
			           </div>  
			
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="city" class="label-title">City *</label>
			                    <input type="text" id="contactEditCity" name="contactEditCity" value=<%= user.getCity().getCity() %> class="form-input" placeholder="Enter city name">
			                </div>
			            
			                <div class="form-group right">
			                    <label for="state" class="label-title">State *</label>
			                    <input type="text" class="form-input" id="contactEditState" name="contactEditState" value=<%= user.getCity().getState() %> placeholder="Enter state" >
			                </div> 
			            </div>
			            <div class="horizontal-group">
			                <div class="form-group left">
			                    <label for="country" class="label-title">Country *</label>
			                    <input type="text" class="form-input" id="contactEditCountry" name="contactEditCountry" value=<%= user.getCity().getCountry() %> placeholder="Enter country" >
			                </div>  
			                <div class="form-group right">
			                    <label for="phone" class="label-title">Phone *</label>
			                    <input type="number" id="contactEditPhone" name="contactEditPhone" value=<%= user.getPhone() %> class="form-input" placeholder="Enter your phone number" onchange="validatePhone()">
			                    <div id="phone_check"></div>
			                </div>
			            
			            </div>
			            <div class="form-group">
			                <label for="email" class="label-title">Email *</label>
			                <input type="email" id="contactEditEamil" name="contactEditEamil" value=<%= user.getEmail() %> class="form-input" placeholder="Enter your email" required="required">
			                <div id="email_check"></div>
			            </div>
			            
			            <div class="horizontal-group">
			                <div class="form-group left" >
			                    <label for="company" class="label-title">Company *</label>
			                    <input type="text" class="form-input" id="contactEditCompany" name="contactEditCompany" value=<%= user.getCompany() %> placeholder="Enter Company Name">
			                </div>
			                <div class="form-group right" >
			                      <label for="choose-file" class="label-title">Upload Profile Picture *</label>
			                      <input type="file" id="profileEditPic" name="profileEditPic"  size="20" accept="image/gif, image/jpeg, image/png">
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

<!-- <table >
				<tr> 
					<td>
						<input type="text" name="contactEditFname" id="contactEditFname" placeholder="First Name" value=<%= user.getFname() %> required/>  
					</td>
					<td>		
						<input type="text" name="contactEditLname" id="contactEditLname" placeholder="Last Name" value=<%= user.getLname() %> required/>  
					</td>
				</tr>	
                <tr>
                	<td>
						<input type="email" id="contactEditEamil" name="contactEditEamil" placeholder="Email" value=<%= user.getEmail() %> hidden="true"/>   
					</td>	 
					<td>
						<input type="email" id="contactEditEamil" name="contactEditEamil" placeholder="Email" value=<%= user.getEmail() %> disabled/>   
					</td>
				</tr>
				<tr>	 
					<td>
						<select type="text" id="contactEditGender" name="contactEditGender" placeholder="Gender" value=<%= user.getGender() %> required>   
						<option value="Female">Female</option>
						<option value="Male">Male</option>
						<option value="Others">Others</option>
						</select>
					</td>
				</tr>
				<tr> 
					<td>
						<input type="text" name="contactEditPhone" id="contactEditPhone" placeholder="Phone Number" value=<%= user.getPhone() %> required/>  
					</td> 
				</tr>
                <tr> 
					<td>
						<input type="date" name="contactEditDob" id="contactEditDob" placeholder="Date of Birth" value=<%= user.getDob() %> required/>  
					</td> 
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditAddress" name="contactEditAddress" placeholder="Address" value=<%= user.getAddress() %> required/>   
					</td>
                    <td>
						<input type="text" id="contactEditCity" name="contactEditCity" placeholder="City" value=<%= user.getCity().getCity() %> required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditState" name="contactEditState" placeholder="State" value=<%= user.getCity().getState() %> required/>   
					</td>
                    <td>
						<input type="text" id="contactEditCountry" name="contactEditCountry" placeholder="Country" value=<%= user.getCity().getCountry() %> required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditCompany" name="contactEditCompany" placeholder="Company" value=<%= user.getCompany() %> required/>   
					
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="file" id="profileEditPic" name="profileEditPic"/>   
					</td>
				</tr>
				<tr>
					<td>
						<input id = "submit" type="submit" value="Submit" class="submit" />  
					</td>
				</tr>
			</table> -->