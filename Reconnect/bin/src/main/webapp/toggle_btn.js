
function toggleUser_to_Admin(){
    var usr=document.getElementById("appUser")
    var adm=document.getElementById("admin")
    var tg_btn=document.getElementById("btn")

    usr.style.left="50px";
    adm.style.left="500px";
    tg_btn.style.left="190px";
}
function toggleAdmin_to_User(){
    var usr=document.getElementById("appUser")
    var adm=document.getElementById("admin")
    var tg_btn=document.getElementById("btn")

    usr.style.left="-560px";
    adm.style.left="38px";
    tg_btn.style.left="100px";
}


