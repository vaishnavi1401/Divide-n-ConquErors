window.onbeforeunload = function() { return "Your work will be lost."; };

window.onscroll = function() {scrollFunction()};

function scrollFunction() 
{
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
      document.getElementById("navbar").style.padding = "30px 10px";
      document.getElementById("logo").style.fontSize = "30px";
      document.getElementsByClassName("home_page").style.padding="20px";
    } 
    else {
      document.getElementById("navbar").style.padding = "30px 10px";
      document.getElementById("logo").style.fontSize = "35px";
    }
}


