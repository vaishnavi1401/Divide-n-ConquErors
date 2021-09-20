

function validateUserName(){
    let temp=$("#register-form").find('input[name="username"]').val();
    let expr= /^[a-zA-z]{1}[a-zA-Z0-9_]*$/;

    if(!(expr.test(temp)) || (temp.length <4))
    {
        document.getElementById("username").style.border="2px solid red ";
        document.getElementById("name_check").innerHTML="<p><font color=red size=1px>Must contain alphabets, numbers and _ only<br>Length must be greater than 4</p></font>";
    }
    else{
        document.getElementById("username").style.border="2px solid green ";
        document.getElementById("name_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function validateUserPwd()
{
    let temp=$("#register-form").find('input[name="password"]').val();
    let expr= /^[a-zA-Z0-9]*$/;

    if(!(expr.test(temp)) || (temp.length <6))
    {
        document.getElementById("password").style.border="2px solid red ";
        document.getElementById("pwd_check").innerHTML="<p><font color=red size=1px>Only alphabets an digits allowed<br>Length must be greater than 6</p></font>";
    }
    else{
        document.getElementById("password").style.border="2px solid green ";
        document.getElementById("pwd_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function validatePhone()
{
    let temp=$("#register-form").find('input[name="phone"]').val();
    let expr=/^[6-9]{1}[0-9]{9}$/;
    console.log("meoww");
    if(!(expr.test(temp)) || (temp.length<10)){
        document.getElementById("phone").style.border="2px solid red ";
        document.getElementById("phone_check").innerHTML="<p><font color=red size=1px>Phone Number must start between 6 to 9<br>Must be a 10 digit number</font></p>";
    }
    else{
        document.getElementById("phone").style.border="2px solid green ";
        document.getElementById("phone_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }

}

function validateEmail()
{
    let temp=$("#register-form").find('input[name="email"]').val();
    let expr=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if(!(expr.test(temp))){
        document.getElementById("email").style.border="2px solid red ";
        document.getElementById("email_check").innerHTML="<font color=red size=1px>Invalid email</font>";
    }
    else{
        document.getElementById("email").style.border="2px solid green ";
        document.getElementById("email_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }

}

function validateBirthday(){
    let temp=$("#register-form").find('input[name="birthday"]').val();
    let birthday=new Date(temp);
    let current=Date.now();

    let diff_in_dates=current-birthday.getTime();
    let age = new Date(diff_in_dates).getFullYear()-1970;
    
    if(age<18)
    {
        document.getElementById("birthday").style.border="2px solid red ";
        document.getElementById("birthday_check").innerHTML="<font color=red size=1px>Age must be above 18 yrs</font>";
    }
    else{
        document.getElementById("birthday").style.border="2px solid green ";
        document.getElementById("birthday_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }

}

function checkPasswordSame(){
    let temp1=$("#register-form").find('input[name="password"]').val();
    let temp2=$("#register-form").find('input[name="confirm-password"]').val();
    
    if(temp1===temp2){
        document.getElementById("confirm-password").style.border="2px solid green ";
        document.getElementById("cpwd_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
    else{
        document.getElementById("confirm-password").style.border="2px solid red ";
        document.getElementById("cpwd_check").innerHTML="<p><font color=red size=1px>Password does not match</p></font>";
    }
}

function formSubmitCheck()
{
    let form = document.getElementById('register-form');
	let f_nm=form.elements['firstname'].value;
    let l_nm=form.elements['lastname'].value;
    let gender= document.querySelector('input[name="gender"]:checked').value;
    let birthday=form.elements['birthday'].value; 
    let address=form.elements['address'].value;
    let city=form.elements['city'].value;
    let state=form.elements['state'].value;
    let country=form.elements['country'].value;
    let phone=form.elements['phone'].value;
    let email=form.elements['email'].value ;
    let username=form.elements['username'].value;
    let password=form.elements['password'].value;
    let confirm_pwd=form.elements['confirm-password'].value;

    var elements = document.getElementById("register-form");

    for (var i = 0; i < elements.length; i++) {
        if(elements[i].type=="text" || elements[i].type=="email"){
            if(elements[i].value == "")
            {
                elements[i].style.border="1px solid red";
                document.getElementById("checkform").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=1px>All fields are mandatory</font>"

            }
            else{
                elements[i].style.border="1px solid green";
            }
        }
       
    }

    /******************registration ajax post request *********************/ 


    // var xhr =new XMLHttpRequest();
	// xhr.open("POST","UserServlet",true);
	// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// var request = "firstname="+ f_nm + "&lastname="+l_nm+"&gender="+gender+"&birthday="+birthday+"&address="+address+"&city="+city+"&state="+state+"&country="+country+"&phone="+phone+"&email="+email+"&username="+username+"&password="+password;
    // xhr.send(request);
	// xhr.onreadystatechange=function(){
    //     if(xhr.readyState===4 && xhr.status === 200)
    //     {
    //         //response to check if registration successful if yes create a link or button to navigate to login page 
    //         console.log(xhr.responseText);
    //     }
        
    // }


}
