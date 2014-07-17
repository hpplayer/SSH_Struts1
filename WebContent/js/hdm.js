function setTab(m,n){var menu=document.getElementById("tab"+m).getElementsByTagName("li");  
    var div=document.getElementById("tablist"+m).getElementsByTagName("div");
   // www.codefans.net
    var showdiv=[];
    for (i=0; j=div[i]; i++){if ((" "+div[i].className+" ").indexOf(" tablist ")!=-1){showdiv.push(div[i]);
      }
    }
    for(i=0;i<menu.length;i++)
    {menu[i].className=i==n?"now":"";
        showdiv[i].style.display=i==n?"block":"none";  
    }
}

function subsetTab(m,n){var menu=document.getElementById("subtab"+m).getElementsByTagName("li");  
    var div=document.getElementById("subtablist"+m).getElementsByTagName("div");
   // www.codefans.net
    var showdiv=[];
    for (i=0; j=div[i]; i++){if ((" "+div[i].className+" ").indexOf(" subtablist ")!=-1){showdiv.push(div[i]);
      }
    }
    for(i=0;i<menu.length;i++)
    {menu[i].className=i==n?"now":"";
        showdiv[i].style.display=i==n?"block":"none";  
    }
}
