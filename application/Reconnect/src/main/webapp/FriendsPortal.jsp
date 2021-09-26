<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            User Portal
        </title>
        <link rel="stylesheet" href="user_portal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<style type="text/css">
		
			a .tooltip{
				  visibility: hidden;
				  width: 150px;
				  background-color: black;
				  color: #fff;
				  text-align: center;
				  font-size:20px;
				  border-radius: 6px;
				  padding: 5px 0;
				  position: absolute;
				  z-index: 1;
				  margin-top: 2vh;
				  opacity: 0.75;
			}
			
			a:hover .tooltip{
				visibility: visible;
			}
			
		</style>
	
		<script>
			
			$(document).ready(function()
			{
				$("#myInput").on("keyup", function() {
			    		var value = $(this).val().toLowerCase();
			    		$("#overlay-content-data tr").filter(function() {
			      				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)});
			  			});
			});
			
		
			
			function sendReq(frnd){
				
				var ss=document.getElementById("info").value;
					
				console.log("hello"+frnd);
				
				var xhr;
        		xhr = new XMLHttpRequest();
        		
        		xhr.open("POST", "FriendServlet", true);
        		
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=sendRequest&username="+ss+"&friend="+frnd;
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(typeof(xhr.responseText));
        				console.log(xhr.responseText);
        		
        			}
        		}
				
			} 
			
		
			
			function responseOfPending(){
				
				console.log("in accept");
				
				var ss=document.getElementById("info").value;
				
				var forms = document.getElementById("responseOfPending");
				var choice = $('input[name="resp"]:checked').attr('id');
				var frnd = document.querySelector('input[name="resp"]:checked').value;
				console.log("checked",choice,frnd);
				var xhr;
				
				if(choice=="accept"){
					sendAcceptAsResponse(frnd,ss);
				}
				if(choice=="ignore"){
					sendIgnoreAsResponse(frnd,ss);
				}
        		
			}
			
			async function sendAcceptAsResponse(frnd,ss){
				
				xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=acceptFriendRequest&username="+ss+"&friend="+frnd;
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(typeof(xhr.responseText));
        				console.log("accept sts",xhr.responseText);
        		
        			}
        		}
				
			}
			
			async function sendIgnoreAsResponse(frnd,ss){
				
				xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=ignoreRequest&username="+ss+"&friend="+frnd;
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(typeof(xhr.responseText));
        				console.log("ignore sts",xhr.responseText);
        		
        			}
        		}
				
			}
			
			async function removeFriend(){
				
				var ss=document.getElementById("info").value;
				var frnd = document.getElementById("remove").name;
				console.log("name "+frnd);
				xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=removeFriend&username="+ss+"&friend="+frnd;
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(typeof(xhr.responseText));
        				console.log("remove sts",xhr.responseText);
        		
        			}
        		}
				
				
			}
			
        	async function getJsonData (ss, callback){
        		
        		var xhr;
        		xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=nonFriends&username="+ss;
        		
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				callback(xhr.responseText);
        		
        			}
        		}
        		
        	
        	}
        	
        	
        	function nonfriends()
        	{
        		document.getElementById("myOverlay").style.display = "block";
        		
        		var sessionUsername=document.getElementById("info").value;
        		
        		var data = getJsonData(sessionUsername, function (obj){
        			var obj = JSON.parse(obj);
        			console.log("non",obj);
        			var displaytext="<table id=myTable>";
        			displaytext += "<tr><th>Username</th><th>First Name</th><th>Last Name</th><th>City</th><th>State</th></tr>";
        			
    				for(i=0;i<obj.NonFriendsList.length;i++){
    					
    						var usrnm= obj.NonFriendsList[i].username;
    						
    						displaytext +="<tr>"+
    									"<td> "+obj.NonFriendsList[i].username+ "</td>"+
    									"<td> "+obj.NonFriendsList[i].fname+ "</td>"+
    									"<td> "+obj.NonFriendsList[i].lname+ "</td>"+	
    									"<td> "+obj.NonFriendsList[i].city['city']+ "</td>"+
    									"<td> "+obj.NonFriendsList[i].city.state+ "</td>"+
    									"<td><input type=button value=Send id="+usrnm+" name=rq onClick=sendReq(this.id)></td>"+
    									"</tr>";
    				}
    				
    				displaytext +="</table>";
    				
    				document.getElementById("overlay-content-data").innerHTML =displaytext;
    			
        		});
        	}
        	
			
        	async function getPendingJsonData (ss, callback){
        		console.log("in pending 1");
        	        		var xhr;
        	        		xhr = new XMLHttpRequest();
        	        		xhr.open("POST", "FriendServlet", true);
        	        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        	        		var request = "ac=viewPendingRequest&username="+ss;
        	        		console.log("in pending 2");
        	        		xhr.send(request);
        	        		xhr.onreadystatechange = function() {
        	        			if (xhr.readyState == 4 && xhr.status == 200) {
        	        				
        	        				console.log(typeof(xhr.responseText));
        	        				callback(xhr.responseText);
        	        		
        	        			}
        	        		}
        	}
        	 	
        	
        	function pendingRequests()
        	{
        		document.getElementById("myOverlay").style.display = "block";
        		
        		var sessionUsername=document.getElementById("info").value;
        		
        		var data = getPendingJsonData(sessionUsername, function (obj){
        			var obj = JSON.parse(obj);
        			console.log("pending",obj);
        			var displaytext="<form id=pendingForm><table id=myTable>";
        			displaytext += "<tr><th>Username</th><th>Accept</th><th>Ignore</th></tr>";
        			
        			for(i=0;i<obj.PendingReqList.length;i++)
        			{
    					
						var usrnm= obj.PendingReqList[i].username;
						
						displaytext +="<tr>"+
	        			"<td> "+usrnm+ "</td>"+		
	        			"<td><input type=radio value="+usrnm+ " name=resp id=accept></td>"+
	                    "<td><input type=radio value="+usrnm+ " name=resp id=ignore></td>"+
	        			"<td><input type=button value= submit onclick=responseOfPending()></td>"
	        			"</tr>";
					}
				     			
        			displaytext +="</table></form>";
        			
        			console.log(displaytext);
        			document.getElementById("overlay-content-data").innerHTML =displaytext;
        		 
        		});
        	}
        	
        	
        async function getFriendsJsonData (ss, callback)
        {
        	console.log("in json");
        		var xhr;
        		xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=viewFriends&username="+ss;
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log("xxx",xhr.responseText);
        				callback(xhr.responseText);
        		
        			}
        		}
        	
        		
		}
 	
		function viewFriends()
		{
			console.log("in frnd");
				document.getElementById("myOverlay").style.display = "block";
				
				var sessionUsername=document.getElementById("info").value;
				
				var data = getFriendsJsonData(sessionUsername, function (obj){
					var obj = JSON.parse(obj);
					console.log("frnd",obj);
	    			var displaytext="<table id=myTable>";
	    			displaytext += "<tr><th>Username</th><th>Name</th><th>Email</th><th>Address</th></tr>";
	    			
	    				    			
	    			for(i=0;i<obj.FriendsList.length;i++)
        			{
    					var usrnm = obj.FriendsList[i].username;
						var firstname = obj.FriendsList[i].fname;
						var email = obj.FriendsList[i].email;
						var city = obj.FriendsList[i].address;
												
						displaytext +="<tr>"+
						"<td>" + usrnm + "</td>"+
	        			"<td>" + firstname + "</td>"+
	                    "<td>" + email + "</td>"+
	        			"<td>" + city + "</td>"+
	        			
	        			/**********************need username for removing a friend************/
	        			"<td><input type=button value=remove name="+usrnm+ " id=remove onclick=removeFriend()></td>"+
	        			"</tr>";
					}
	    				    			
	    			displaytext +="</table>";
	    			console.log(displaytext);
	    			document.getElementById("overlay-content-data").innerHTML =displaytext;
	    		 
	    		});
			}
	        function closeSearch() {
	                document.getElementById("myOverlay").style.display = "none";
	        }
	           
        </script>
    </head>
    <body>
    	<input type="text" id="info" value="<%= session.getAttribute("message") %>">
    	
        <div class="main_container">
            <div class="icon-bar">
                <a class="active" href="UserPortal.jsp"><i class="fa fa-home"></i><div class="tooltip">Home</div></a>
                <a  onclick="nonfriends()" id="search"><i class="fa fa-search"></i><div class="tooltip">Find People</div></a> 
                <a  onclick="viewFriends()" id="search"><i class="fa fa-handshake-o" aria-hidden="true"></i><div class="tooltip" >My Friends</div></a> 
                <a onclick="pendingRequests()" id="my_requests"><i class="fa fa-question-circle" aria-hidden="true"></i><div class="tooltip">Pending Requests</div></a>    
            </div>
           
           
        </div>
         <div id="myOverlay" class="overlay">
         	
               <span class="closebtn" onclick="closeSearch()" title="Close Overlay"><i class="fa fa-times" aria-hidden="true"></i></span>
               
                <div class="overlay-content">
                   <input type="text" id="myInput"  placeholder="Search here" name="search">
                </div>
             		<div id="overlay-content-data">
             			
             		</div>
            </div>
    </body>
</html>