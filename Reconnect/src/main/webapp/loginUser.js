function validateAppUserName(){
    let name=$("#appUser").find('input[name="usr_nm"]').val();
    // let pass=$("#appUser").find('input[name="usr_pwd"]').val();
    
    let name_len=name.length;
    // let pass_len=pass.length;

    if(name===""){
        $(".user_input_field").focus(function () { 
            $("this").css("border","1px solid green");
        });
    }
    if(name_len<8)
    {
        $(".user_input_field").focus(function () { 
            $("this").css("border","1px solid red");
        });
     }
    if(name_len>=8){
        $(".user_input_field").focus(function () { 
            $("this").css("border","1px solid blue");
        });    
    }
}