function validateAdminName(){
    let temp=$("#admin").find('input[name="admin_username"]').val();
    // console.log(temp);
    let expr= /^[a-zA-z]{1}[a-zA-Z0-9_]*$/;

    if(!(expr.test(temp)) || (temp.length <4))
    {
        document.getElementById("admin_username").style.border="2px solid red ";
        document.getElementById("admin_nm_check").innerHTML="<p><font color=red size=1px>Must contain alphabets, numbers and _ only<br>Length must be greater than 4</p></font>";
    }
    else{
        document.getElementById("admin_username").style.border="2px solid green ";
        document.getElementById("admin_nm_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function validateAdminPwd()
{
    let temp=$("#admin").find('input[name="admin_pwd"]').val();
    // console.log(temp);
    let expr= /^[a-zA-Z0-9]*$/;

    if(!(expr.test(temp)) || (temp.length <6))
    {
        document.getElementById("admin_pwd").style.border="2px solid red ";
        document.getElementById("admin_pwd_check").innerHTML="<p><font color=red size=1px>Only alphabets an digits allowed<br>Length must be greater than 6</p></font>";
    }
    else{
        document.getElementById("admin_pwd").style.border="2px solid green ";
        document.getElementById("admin_pwd_check").innerHTML="<font color=green size=1px>"+""+"</font>";
    }
}

function loginAsAdmin(){
    let form=document.getElementById('admin');
    let user_name=form.elements['admin_username'].value;
    let user_pwd=form.elements['admin_pwd'].value;

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