function validateProductForm() {
	
	var productId = document.forms["myform"]["pid"].value;
	var productname = document.forms["myform"]["name"].value;
	var  price = document.forms["myform"]["price"].value;
	var  stock = document.forms["myform"]["stock"].value;
	   if (productId== "") {
	        alert("productId should not be empty");
	        return false;
	    } 
	
	   if (productname==""){
		   
		   alert("product name is required");
		   return false;
	   }
	   else if(!isNaN(productname)){
   	       alert("product name should not contain number");
           return false;
    	}

	   if (price== "") {
	        alert("price is required");
	        return false;
	    } 
	
	   else if(isNaN(price)){
  	       alert("price must be numeric");
           return false;
  	    }
	   
	   if(stock==""){
		   alert("quantity must be filled");
		   return false;
	   }
	   
}