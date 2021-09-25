<!DOCTYPE html>

<html>

<body>
<% String val = request.getParameter("email"); %>
<% String name = request.getParameter("name"); %>
<%session.setAttribute("emailEdit", val);%>
<form action="ContactController/editContact">
 <table >
				<tr> 
					<td>
						<input type="text" value="<%=name%>" name="contactEditFname" id="contactEditFname" placeholder="First Name" required/>  
					</td>
					<td>		
						<input type="text" name="contactEditLname" id="contactEditLname" placeholder="Last Name" required/>  
					</td>
				</tr>	
                <tr>	 
					<td>
						<input type="email" value="<%=val%>" id="contactEditEamil" name="contactEditEamil" placeholder="Email" required disabled/>   
					</td>
				</tr>
				<tr>	 
					<td>
						<select type="text" id="contactEditGender" name="contactEditGender" placeholder="Gender" required>   
						<option value="Female">Female</option>
						<option value="Male">Male</option>
						<option value="Others">Others</option>
						</select>
					</td>
				</tr>
				<tr> 
					<td>
						<input type="text" name="contactEditPhone" id="contactEditPhone" placeholder="Phone Number" required/>  
					</td> 
				</tr>
                <tr> 
					<td>
						<input type="date" name="contactEditDob" id="contactEditDob" placeholder="Date of Birth" required/>  
					</td> 
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditAddress" name="contactEditAddress" placeholder="Address" required/>   
					</td>
                    <td>
						<input type="text" id="contactEditCity" name="contactEditCity" placeholder="City" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditState" name="contactEditState" placeholder="State" required/>   
					</td>
                    <td>
						<input type="text" id="contactEditCountry" name="contactEditCountry" placeholder="Country" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="text" id="contactEditCompany" name="contactEditCompany" placeholder="Company Name" required/>   
					</td>
				</tr>
                <tr>	 
					<td>
						<input type="file" id="profileEditPic" name="profileEditPic"  required/>   
					</td>
				</tr>
				<tr>
					<td>
						<input id = "submit" type="submit" value="Submit" class="submit" />  
					</td>
				</tr>
			</table>
</form>
<p>
<h3><a href="EmpController/list" >View Employee</a></h3>
</body>
</html>