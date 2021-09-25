
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            User Portal
        </title>
        <link rel="stylesheet" href="user_portal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

   		
   		<script type="text/javascript">
   		
   			function friends()
   			{
   				console.log("hello");
   				var xhr;
   				xhr = new XMLHttpRequest();
   				
   				xhr.open("GET", "FriendServlet?ac=sendRequest", true);
   				xhr.send();
   				xhr.onreadystatechange = function() {
   					if (xhr.readyState == 4 && xhr.status == 200) {
   						console.out("hi");
   						console.log(xhr.responseText);
   					}
   				}
   				
   			}
   		</script>
   
    </head>
    <body>
    	<input type="text" id="info" value="<%= session.getAttribute("message") %>">
        <div class="main_container">
          
            <div class="icon-bar">
                <a class="active" href="#"><i class="fa fa-home"></i></a>
                <a href="FriendsPortal.jsp"><i class="fa fa-users" aria-hidden="true"></i></a>
                <a href="blockList.jsp"><i class="fa fa-ban" aria-hidden="true"></i></a>
                
                <a href="LandingPage.jsp" target="_blank" onchange="navigate_to_login()"><i class="fa fa-power-off"></i></a>
            </div>
            </div>
    </body>
</html>

<!-- function navigate_to_login(){
    window.history.forward();
    function noBack() {
        window.history.forward();
    }  
    setTimeout(noBack(), 0);
}

window.history.forward();
function noBack() {
    window.history.forward();
    window.onunload = function () { null }; 
} 

function openSearch(serach_option) {  
var x=document.getElementById("info").value;
console.log(typeof(x));
console.log("hello");

document.getElementById("myOverlay").style.display = "block";
var xhr;
	xhr = new XMLHttpRequest();
	var str;
	
	//alert("after xhr");
	var baseurl = "ContactController/viewContact";

	xhr.open("GET", baseurl, true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("hello me");
			console.log(xhr.responseText);
			var obj = JSON.parse(xhr.responseText);
			var displaytext = "";
			displaytext += "<table id=myTable border=1><tr><th>First Name</th><th>Last Name</th><th>Email</th><th>City</th><th>State</th><th>Country</th></tr>";
		
			for(i=0;i<obj.Contactlist.length;i++){
					console.log(obj.Contactlist[i].fname);
					displaytext +="<tr>"+
								"<td> "+obj.Contactlist[i].fname+ "</td>"+
								"<td> "+obj.Contactlist[i].lname+ "</td>"+
								"<td> "+obj.Contactlist[i].email+ "</td>"+
								"<td> "+obj.Contactlist[i].city1[0]+ "</td>"+
								"<td> "+obj.Contactlist[i].city1.state+ "</td>"+
								"<td> "+obj.Contactlist[i].city1.country+ "</td>"+
								+"</tr>";
			}
			displaytext +="</table>";
			document.getElementById("table_area").innerHTML = displaytext;
			document.getElementById("myOverlay").style.display = "block";
        //document.getElementById("overlay-content-data").innerHTML=myFunction(displaytext);
		}
	}
  
}

function closeSearch() {
  document.getElementById("myOverlay").style.display = "none";
}

	function myFunction() {
		var input, filter, table, tr, td, i, txtValue;
		input = document.getElementById("myInput");
		table= document.getElementById("table_area");
		  filter = input.value.toUpperCase();
		  table = displaytext;
		tr = table.getElementsByTagName("tr");
		  for (var i=0;i<displaytext.length;i++)
		  {
			td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }
		  }
}

</script>

 <div id="myOverlay" class="overlay">
                <span class="closebtn" onclick="closeSearch()" title="Close Overlay">X</span>
                <div class="overlay-content">
                   <input type="text" id="myInput" onclick="myFunction()" placeholder="Search here" name="search">
                </div>
                <div id="table_area" ></div>
                <div id="overlay-content-data">
                </div>
-->
