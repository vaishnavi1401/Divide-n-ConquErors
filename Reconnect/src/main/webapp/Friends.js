
function sendstatus(){
	var ss=document.getElementById("info").value;
				var x=document.getElementById("button").value;
				var xhr;
				
        		xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		
				if(x=="accept"){
					var request = "ac=acceptFriendRequest&username="+ss+"&friend="+frnd;
	        		xhr.send(request);
				}
				else if(x=="ignore"){
					var request = "ac=ignoreRequest&username="+ss+"&friend="+frnd;
	        		xhr.send(request);
				}
				else if(x=="remove"){
					var request = "ac=removeFriend&username="+ss+"&friend="+frnd;
	        		xhr.send(request);
				}
        		xhr = new XMLHttpRequest();
        		
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(xhr.responseText);
        		
        			}
        		}
				
}
function getPendingJsonData (ss, func){
        		
        		var xhr;
        		xhr = new XMLHttpRequest();
        		xhr.open("POST", "FriendServlet", true);
        		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		var request = "ac=viewPendingRequest&username="+ss;
        		
        		xhr.send(request);
        		xhr.onreadystatechange = function() {
        			if (xhr.readyState == 4 && xhr.status == 200) {
        				
        				console.log(xhr.responseText);
        				func(xhr.responseText);
        		
        			}
        		}
}
 	
function pendingRequests(){
	document.getElementById("myOverlay").style.display = "block";
	
	var sessionUsername=document.getElementById("info").value;
	
	var data = getPendingJsonData(sessionUsername, function (obj){
		var obj = JSON.parse(obj);
		
		var displaytext="<table id=myTable>";
		displaytext += "<tr><th>Username</th><th>First Name</th><th>Last Name</th><th>City</th><th>State</th></tr>";
		console.log("*****************");
		console.log(i,obj.PendinReqList[0].fname);
		console.log();
		for(var i=0;i<4;i++){
				
				displaytext +="<tr>"+
							
							/*"<td> "+obj.PendinReqList[i]+ "</td>"+
							"<td> "+obj.PendinReqList[i].lname+ "</td>"+	
							"<td> "+obj.PendinReqList[i].city['city']+ "</td>"+
							"<td> "+obj.PendinReqList[i].city.state+ "</td>"+*/
							"<td><input type=button value=accept id="+usrnm+" name=rq onClick=sendstatus(this.id)></td>"+
							"<td><input type=button value=ignore id="+usrnm+" name=rq onClick=sendstatus(this.id)></td>"+
							"<td><input type=button value=remove id="+usrnm+" name=rq onClick=sendstatus(this.id)></td>"+
							"</tr>";
		}
		
		displaytext +="</table>";
		
		document.getElementById("overlay-content-data").innerHTML =displaytext;
	
	});
}