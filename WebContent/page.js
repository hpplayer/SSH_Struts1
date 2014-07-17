// JavaScript Document
function stripeTables(){
   var content=document.getElementById("content");
   var rows=content.getElementsByTagName("tr");
   var odd=false;
   for(var i=0;i<rows.length;i++){
       if(odd==true){
	       rows[i].className="classType1";
		   odd=false;
	   }else{
	      rows[i].className="classType2";
		  odd=true;
	   }
   }
}
function addLoadEvent(fun){
   var older=window.onload;
   if(typeof window.onload!="function"){
      window.onload=fun;
   }else{
	   window.onload=function(){
	       older();
		   fun();
	   }
      
   }
}
addLoadEvent(stripeTables);