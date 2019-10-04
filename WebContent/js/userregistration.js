
function userRegistrationForm() {
	
	var firstName = document.forms["myform"]["fname"].value;
	var lastName = document.forms["myform"]["lname"].value;
	var age = document.forms["myform"]["age"].value;
	var contactNumber = document.forms["myform"]["cno"].value;
	var email = document.forms["myform"]["email"].value;
	var vendorId = document.forms["myform"]["vid"].value;
	var password = document.forms["myform"]["pass"].value;

	
  
  
    
	var rege = /\S+@\S+\.\S+/;
    var regexPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{4,15}$/;   
    if (firstName == "") {
        alert("firstName is required");
        return false;
    } 
    else if (firstName.length < 2 || firstName.length > 50) {
        alert("firstName should have 2 to 65 characters");
        return false;
    }
    if (lastName == "") {
        alert("lastName is required");
        return false;
    } 
    else if (lastName.length < 2 || lastName.length > 50) {
        alert("lastName should have 2 to 50 characters");
        return false;
    } 
   
    if (isNaN(age)||age<18)
    { 
        alert("The age must be greater than 18");
        return false;
    }
   
    
    if (contactNumber== "") {
        alert("contactNumber is required");
        return false;
    }
    else if(isNaN(contactNumber))
    	{
    	 alert("contactNumber must be numeric");
         return false;
    	}
    else if(contactNumber.length!=10)
    	 {
    		 alert("contactNumber should be contain 10 digits");
    		 return false;
    	 }
    
    if (email=="") 
    {
        alert("Email id is required");
        return false;
    }
    
    else if(!rege.test(email)){
    	alert("Email Id Invalid");
    	return false;
    }
    
    if (vendorId== "") {
        alert("vendorId is required");
        return false;
    }
    else if ( vendorId.length > 65) {
        alert("vendorId should have less than 50 characters");
        return false;
    }
    if (password== "") {
        alert("password is required");
       
        return false;
    } 
    else if (!regexPassword.test(password)) {
        alert("password is wrong format");
    	return false;
    }
}

function validateuserRegistrationForm() {
	
	var firstName = document.forms["myform"]["fname"].value;
	var lastName = document.forms["myform"]["lname"].value;
	var age = document.forms["myform"]["age"].value;
	var contactNumber = document.forms["myform"]["cno"].value;
	var email = document.forms["myform"]["email"].value;
	var userId = document.forms["myform"]["uid"].value;
	var password = document.forms["myform"]["pass"].value;
	
	var rege = /\S+@\S+\.\S+/;
    var regexPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{4,15}$/;   
    if (firstName == "") {
        alert("firstName is required");
        return false;
    } 
    else if (firstName.length < 2 || firstName.length > 50) {
        alert("firstName should have 2 to 65 characters");
        return false;
    }
    if (lastName == "") {
        alert("lastName is required");
        return false;
    } 
    else if (lastName.length < 2 || lastName.length > 50) {
        alert("lastName should have 2 to 50 characters");
        return false;
    } 
   
    if (isNaN(age)||age<18)
    { 
        alert("The age must be greater than 18");
        return false;
    }
   
    
    if (contactNumber== "") {
        alert("contactNumber is required");
        return false;
    }
    else if(isNaN(contactNumber))
    	{
    	 alert("contactNumber must be numeric");
         return false;
    	}
    else if(contactNumber.length!=10)
    	 {
    		 alert("contactNumber should be contain 10 digits");
    		 return false;
    	 }
    
    if (email=="") 
    {
        alert("Email id is required");
        return false;
    }
    
    else if(!rege.test(email)){
    	alert("Email Id Invalid");
    	return false;
    }
    
    if (userId== "") {
        alert("userId is required");
        return false;
    }
    else if ( userId.length > 65) {
        alert("userId should have less than 50 characters");
        return false;
    }
    if (password== "") {
        alert("password is required");
       
        return false;
    } 
    else if (!regexPassword.test(password)) {
        alert("password is wrong format");
    	return false;
    }
}
