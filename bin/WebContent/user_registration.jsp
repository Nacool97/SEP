<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="./css/home.css"> 
<script src="./js/vendor_registration.js"></script>
<title>Insert title here</title>
</head>

<body class="body">
<header class="header">
		<img class="logo" src="./img/icon.png"></img> 
		<a class="a" href="">About Us</a>
		 <a class="a" href="home.jsp">Home</a>
</header>
<center>
	<form name="myform" action="UserRegistration" onsubmit="return validateRegistrationForm()" method="post">
		
		<div>
			<h1>Userr Registration Form</h1>

			<table class="table"> 
				<tr>
					<td><label for="fname"class="td"><b>First Name</b></label></td>
				       
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter First Name"
						name="fname" id="fname"></td>
				</tr>
			<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="lname"><b>Last Name	</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Last Name"
						name="lname" id="lname"></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="age"><b>Age</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Age" name="age"
						id="age"></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="gender" ><b>Gender</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select name="gender" style="width: 175px">
							<option>Select</option>
							<option value="male" name="gender">male</option>
							<option value="female"  name="gender">female</option>
					</select></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="cno"><b>Contact</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Contact" name="cno"
						id="cno"></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="email"><b>Email</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="email" placeholder="Enter Email" name="email"
						id="email"></td>
				</tr> 
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="uid"><b>Vendor Id</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter user id"
						name="uid" id="uid"></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td><label for="pass"><b>Password</b></label></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" placeholder="Enter Password"
						name="pass" id="pass"></td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					<td colspan="2">
						<input class="button" type="submit" value="Register" style="margin-left:100px; "></input>	
					</td>
				</tr>
				</table>
				</form>
			<div class="pa">
			<p style="padding-bottom:200px;">Already have an account <a href="vendor_login.jsp">Sign In</a></p>
			</div>
			</center>

			<footer><p class="p">&copy;Shareyoureconomy</p></footer>

</body>
</html>