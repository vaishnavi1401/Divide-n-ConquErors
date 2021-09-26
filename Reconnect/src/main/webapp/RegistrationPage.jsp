<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="utf-8">
    <title>Register Form Start</title>
    <link rel="stylesheet" href="register_css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="register_page.js"></script>
    <script>
		    window.history.forward();
		    function noBack() {
		        window.history.forward();
		    }  
    </script>
  </head>

  <body>

    <form class="register-form" id="register-form" action="UserServlet" method="post" enctype="multipart/form-data" onclick="formSubmitCheck()">  
        <div class="form-header">
            <h1>Create Account</h1>
        </div>
        <div id="checkform"></div>
        <div class="form-body">
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="firstname" class="label-title">First Name *</label>
                    <input type="text" id="firstname" name="firstname" class="form-input" placeholder="Enter your first name" required="required" />
                </div>
                <div class="form-group right">
                    <label for="lastname" class="label-title">Last Name *</label>
                    <input type="text" id="lastname" name="lastname" class="form-input" placeholder="Enter your last name" />
                </div>
            </div>
            <div class="horizontal-group">
                <div class="form-group left">
                    <label class="label-title">Gender *</label>
                    <div class="input-group">
                        <label for="male">
                            <input type="radio" name="gender" value="male" id="male" required="required" checked=select> Male</label>
                        <label for="female">
                            <input type="radio" name="gender" value="female" id="female" required="required"> Female</label>
                        <label for="female">
                            <input type="radio" name="gender" value="other" id="other" required="required"> Others</label>
                    </div>
                </div>
            
                <div class="form-group right">
                    <label for="birthday" class="label-title">Date Of Birth *</label>
                    <input type="date" class="form-input" id="birthday" name="birthday" required="required" onchange="validateBirthday()">
                    <div id="birthday_check"></div>
                </div>
            </div>  

            <div class="form-group right">
                <label for="address" class="label-title">Address *</label>
               <input type="text" class="form-input" id="address" name="address" placeholder="Enter your address" required="required">
           </div>  

            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="city" class="label-title">City *</label>
                    <input type="text" id="city" name="city" class="form-input" placeholder="Enter city name" required="required">
                </div>
            
                <div class="form-group right">
                    <label for="state" class="label-title">State *</label>
                    <input type="text" class="form-input" id="state" name="state" placeholder="Enter state" required="required">
                </div> 
            </div>
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="country" class="label-title">Country *</label>
                    <input type="text" class="form-input" id="country" name="country" placeholder="Enter country" required="required">
                </div>  
                <div class="form-group right">
                    <label for="phone" class="label-title">Phone *</label>
                    <input type="number" id="phone" name="phone" class="form-input" placeholder="Enter your phone number" required="required" onchange="validatePhone()">
                    <div id="phone_check"></div>
                </div>
            
            </div>
            <div class="form-group">
                <label for="email" class="label-title">Email *</label>
                <input type="email" id="email" name="email" class="form-input" placeholder="Enter your email" required="required" onchange="validateEmail()">
                <div id="email_check"></div>
            </div>

            <div class="form-group">
                <label for="username" class="label-title">Username *</label>
                <input type="username" id="username" name="username" class="form-input" placeholder="Enter your username" required="required" onchange="validateUserName()">
                <div id="name_check"></div>
            </div>
            <div class="horizontal-group">
          
                <div class="form-group left">
                    <label for="password" class="label-title">Password *</label>
                    <input type="password" id="password" name="password" class="form-input" placeholder="Enter your password" required="required" onchange="validateUserPwd()">
                <div id="pwd_check"></div>
            </div>
            
                <div class="form-group right">
                    <label for="confirm-password" class="label-title">Confirm Password *</label>
                    <input type="password" class="form-input" id="confirm-password" name="confirm-password" placeholder="enter your password again" required="required" onchange="checkPasswordSame()">
                    <div id="cpwd_check"></div>
                </div>
            </div>
            
            <div class="horizontal-group">
                <div class="form-group left" >
                    <label for="company" class="label-title">Company *</label>
                    <input type="text" class="form-input" id="company" name="company" placeholder="Enter Company Name" required="required">
                </div>
                <div class="form-group right" >
                      <label for="choose-file" class="label-title">Upload Profile Picture *</label>
                      <input type="file" id="image" name="image" size="20" required="required" accept="image/gif, image/jpeg, image/png">
                </div>
                    
            </div>
        
        <div class="form-footer">
            <button type="submit" class="btn">Register</button>
          	${message}
        </div>
    </div>
    </form>
  </body>
</html>

</html>