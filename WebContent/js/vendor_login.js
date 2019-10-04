function validateRegistrationForm() {
	var vendorId = document.forms["myform"]["vid"].value;
	var password = document.forms["myform"]["pass"].value;
	var regexPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{4,15}$/;  
	
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
	var userId = document.forms["myform"]["uid"].value;
	var password = document.forms["myform"]["pass"].value;
	var regexPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{4,15}$/;  
	
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