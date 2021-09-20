function validateUserName(){
    let temp=$("#appUser").find('input[name="user_name"]').val();
    // console.log(temp);
    let expr= /^[a-zA-z]{1}[a-zA-Z0-9_]*$/;

    if(!(expr.test(temp)) || (temp.length <4))
    {
        document.getElementById("user_name").style.border="2px solid red ";
        document.getElementById("usr_nm_check").innerHTML="<p><font color=red size=1px>Must contain alphabets, numbers and _ only<br>Length must be greater than 4</p></font>";
    }
    else{
        document.getElementById("user_name").style.border="2px solid green ";
        document.getElementById("usr_nm_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function validateUserPwd()
{
    let temp=$("#appUser").find('input[name="user_pwd"]').val();
    // console.log(temp);
    let expr= /^[a-zA-Z0-9]*$/;

    if(!(expr.test(temp)) || (temp.length <6))
    {
        document.getElementById("user_pwd").style.border="2px solid red ";
        document.getElementById("usr_pwd_check").innerHTML="<p><font color=red size=1px>Only alphabets an digits allowed<br>Length must be greater than 6</p></font>";
    }
    else{
        document.getElementById("user_pwd").style.border="2px solid green ";
        document.getElementById("usr_pwd_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function loginAsUser(){
    let form=document.getElementById('appUser');
    let user_name=form.elements['user_name'].value;
    let user_pwd=form.elements['user_pwd'].value;

    // var xhr =new XMLHttpRequest();
	// xhr.open("POST","UserLoginServlet",true);
	// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// //var request = "username=" + user_name + "&password=" + user_pwd;
    // xhr.send(request);
	// xhr.onreadystatechange=function(){
    //     if(xhr.readyState===4 && xhr.status === 200)
    //     {
    //         login successful response and redirect to user portal
    //         console.log(xhr.responseText);
    //     }
    // }

}

//servlet name UserLoginServlet

