<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-image: url("./img/reg2.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/registration.css">
</head>
<body class="body">
<header class="header"> <img class="logo" src="./img/icon.png"></img>
	<a class="a" href="vendor?actionName=logout">Logout</a> <a class="a" href="">About Us</a>
	<a class="a" href="vendor_home.jsp">Home</a> </header>
	
		<h1 class="h"
		style="color: #87CEFA; text-align: center; padding-top: 20px;">Edit
		Vendor Details</h1>
		
	<center>
		<div>
			<form name="myform" action="vendor"
			onsubmit="return validateRegistrationForm()" method="post">

			

				<table class="table">
					<tr>
						<td><label for="fname" class="td"><b>First Name</b></label></td>

						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text" placeholder="Enter First Name" name="fname"
							id="fname" value="${vendor.getFirstName()}"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="lname"><b>Last Name </b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text" placeholder="Enter Last Name" name="lname" id="lname" value="${vendor.getLastName()}"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="age"><b>Age</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text" placeholder="Enter Age" name="age" id="age" value="${vendor.getAge()}"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="gender"><b>Gender</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select
							name="gender" style="width: 175px">
								<option value="${vendor.getGender()}">${vendor.getGender()}</option>
								<option value="male" name="gender">male</option>
								<option value="female" name="gender">female</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="cno"><b>Contact</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text"  name="cno" id="cno" value="${vendor.getContactNumber()}"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
					<td><label for="vid"><b>Vendor Id</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter vendor id"
						name="vid" id="vid" value="${vendor.getVendorId()}"></td>
				</tr>
				<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="email"><b>Email</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="email" placeholder="Enter Email" name="email" id="email" value="${vendor.getEmail()}"></td>
					</tr>
					<tr>
						<td><label for="zip"><b>Zip</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text" placeholder="Enter zip" name="zip" id="zip" value="${vendor.getZip()}"></td>
					</tr>
					<tr>
						<td><label for="city"><b>City</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="text" placeholder="Enter city" name="city" id="city" value="${vendor.getCity()}"></td>
					</tr>
					<tr>
						<td><label for="address"><b>Address</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="textarea" rows="5" cols="40" placeholder="Enter address" name="address" id="address" value="${vendor.getAddress()}"></td>
					</tr>
					<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="edit"></td>
					</tr>
					<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="submit" class="button"></td>
				</tr>
				</table>
				</form>
			
				</center>
				
</body>
</html>