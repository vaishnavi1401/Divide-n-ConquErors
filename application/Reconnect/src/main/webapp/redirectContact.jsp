<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
			margin-left: 30vh
			
			
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
		
		.button {
		  border-radius: 4px;
		  background-color: green;
		  border: none;
		  color: #FFFFFF;
		  text-align: center;
		  font-size: 28px;
		  padding: 20px;
		  width: 320px;
		  transition: all 0.5s;
		  cursor: pointer;
		  margin: 5px;
		}
		
		.button span {
		  cursor: pointer;
		  display: inline-block;
		  position: relative;
		  transition: 0.5s;
		}
		
		.button span:after {
		  content: '\00bb';
		  position: absolute;
		  opacity: 0;
		  top: 0;
		  right: -20px;
		  transition: 0.5s;
		}
		
		.button:hover span {
		  padding-right: 25px;
		}
		
		.button:hover span:after {
		  opacity: 1;
		  right: 0;
		}
		.option-block{
			width:150vh;
			height:70vh;
			background:url("assets/portal_links.jpeg");
			background-repeat: repeat;
			background-size: cover;
			background-position: center;
		}
		
		.option-block-one{
			width:70vh;
			height:70vh;
			background-color: white;
			position: fixed;
			margin-left:80vh;
			position: relative;
		}
		
		.contact-add-section{
			width:50vh;
			height:12vh;
			margin-left:8vh;
			top:20vh;
			position: absolute;
		
		}
		
		.contact-list-section{
			width:50vh;
			height:12vh;
			margin-left:8vh;
			top:40vh;
			position: absolute;
		
		}
		* {
		  box-sizing: border-box;
		}
		input[type=text] {
		  padding: 10px;
		  font-size: 17px;
		  border: 1px solid grey;
		  float: left;
		  width: 80%;
		  background: #f1f1f1;
		}
				
		</style>
<body>
		<div class="main-container">
		<div class="nav-side">
			
			<div class="icon-bar"> 
				<div id="right-container">
					<a id="logo">ReConnect</a>
				</div> 
            </div>
		</div>
		<div class="option-block">
			
			<div class="option-block-one">
					<div class="contact-add-section">
							<button class="button" onclick="location.href = 'checkEmail.jsp';"><span>Add a New Contact </span></button>
					</div>
					<div class="contact-list-section">
							<button class="button" onclick="location.href = 'ContactController/viewContactMain';"><span>My Contacts </span></button>
					</div>
			</div>
			<div class="option-block-two"></div>
		</div>
		</div>
		
</body>
</html>