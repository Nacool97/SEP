function validateServiceForm() {
	
	var serviceId = document.forms["myform"]["sid"].value;
	var Servicename = document.forms["myform"]["sname"].value;
	var  serviceprice = document.forms["myform"]["sprice"].value;
	var  status = document.forms["myform"]["sstatus"].value;
	var  time= document.forms["myform"]["stime"].value;
	var  contact = document.forms["myform"]["scontact"].value;
	
	    if (serviceId== "") {
	        alert("service should not be empty");
	        return false;
	    } 
	
	   if (Servicename==""){
		   
		   alert("service name is required");
		   return false;
	   }
	   else if(!isNaN(productname)){
   	       alert("service name should not contain number");
           return false;
    	}

	   if (serviceprice== "") {
	        alert("price is required");
	        return false;
	    } 
	
	   else if(isNaN(serviceprice)){
  	       alert("price must be numeric");
           return false;
  	    }
	   
	   if(status==""){
		   alert("status must be filled");
		   return false;
	   }
	   if(time==""){
		   alert("time must be filled");
		   return false;
	   }
	   if(time==""){
		   alert("quantity must be filled");
		   return false;
	   }
	   
	   if(contact==""){
		   alert("contact no. must be filled")
	   }
	   
	   else if(isNaN(contact)){
  	       alert("contact must be numeric");
           return false;
  	     }
	   else if(contact.length!=10){
	 	   alert("contact must contain 10 digits")
	   }
	  
}

function validateScategoryForm(){
	var  scat= document.forms["myform"]["scategory"].value;
	if(scat==""){
		
		   alert("catergory name must be filled");
		   return false;
	   }
}