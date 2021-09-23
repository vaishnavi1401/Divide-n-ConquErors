     function display(list,button_name)
        {
        	var user_list= JSON.parse(list);
			str = "<tr><td><th>USERNAME</th><th>LOCATION</th></tr></td>"
		for(var key in user_list)
			  {
				str += "<tr>";
				str += "<td>" + "<input type='checkbox' name='username' id='"+key+"' value='" + key+ "'>" + "</td><td>" + key + "</td><td>"+user_list[key]+"</td>";
				str += "</tr>";
			}
			
			str += "  <button class= 'button'  onclick='deleteDisable(id)'  id='"+button_name+"' >"+button_name+"</button>";
			console.log(str);
			document.getElementById("myTable").innerHTML = str;
			}
        
        
      function openView(val){
        var tab="";
        console.log(val);
        if(val=="viewAll")
        {
        	   var xhr =new XMLHttpRequest();
        		 xhr.open("POST","Admin_user_details",true);
        	     xhr.send();
        	     
        		 xhr.onreadystatechange=function(){
        	         if(xhr.readyState===4 && xhr.status === 200)
        	         {
        	            // login successful response and redirect to user portal
        	             console.log(xhr.responseText);
        	             list=xhr.responseText
        	             displayAll(list);
        	         }  
        	     }
   		 }
   		
           
        
        else if(val==="viewDisable"){

     	   var xhr =new XMLHttpRequest();
     		 xhr.open("POST","Admin_DisabledUser_Details",true);
     		 
     		 xhr.onreadystatechange=function(){
     	         if(xhr.readyState===4 && xhr.status === 200)
     	         {
     	            // login successful response and redirect to user portal
     	             console.log(xhr.responseText);
     	            display(xhr.responseText,"disable");
     	         }  
     	     }
     		 xhr.send();
        }
        else{

     	   var xhr =new XMLHttpRequest();
     		 xhr.open("POST","Admin_DeletedUser_Details",true);
     	     xhr.send();
     		 xhr.onreadystatechange=function(){
     	         if(xhr.readyState===4 && xhr.status === 200)
     	         {
     	            // login successful response and redirect to user portal
     	             console.log(xhr.responseText);
     	            display(xhr.responseText,"delete");
     	         }  
     	     }
        }
        document.getElementById("myTable").innerHTML=tab;
      }
function displayAll(list)
{
	
        	var user_list= JSON.parse(list);
			str = "<tr><th>USERNAME</th><th>LOCATION</th></tr>"
		for(var key in user_list)
			  {
				str += "<tr>";
				str += "<td>"+ key + "</td><td>"+user_list[key]+"</td>";
				str += "</tr>";
			}
			console.log(str);
			document.getElementById("myTable").innerHTML = str;
}   
        
        function deleteDisable(val)
        {
			var username = document.querySelector('input[name="username"]:checked').value;
        	if(val==='delete')
        		{
	
        		 var xhr =new XMLHttpRequest();
         		 xhr.open("GET","Delete_User?username="+username,true);
         		 xhr.onreadystatechange=function(){
         	         if(xhr.readyState===4 && xhr.status === 200)
         	         {
         	            // login successful response and redirect to user portal
         	             console.log(xhr.responseText);
         	           // display(xhr.responseText,"disable");
         	         }  
         	     }
         		 xhr.send(null);
        		}
        	if(val==='disable')
    		{
    		 var xhr =new XMLHttpRequest();
     		 xhr.open("GET","Disable_User?username="+username,true);
			 xhr.setRequestHeader("Content-Type", "application/json");
     		 xhr.onreadystatechange=function(){
     	         if(xhr.readyState===4 && xhr.status === 200)
     	         {
     	             console.log(xhr.responseText);
     	           
     	         }  
     	     }
     		 xhr.send(null);
    		}
        }
        
        
        