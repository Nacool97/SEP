<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="./css/home.css">
<script src="./js/vendor_registration.js"></script>
<title>Insert title here</title>
</head>
<body class="body">
	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	<a class="a" href="home.jsp">Home</a> </header>
	<center>
		<div>
			<form name="myform" action="user" onsubmit="return validateRegistrationForm()" method="post">

				<div>
					<h1>User Registration Form</h1>

					<table class="table">
						<tr>

							<td "><label for="fname"><b>First Name
										<font color="red">*</font>
								</b></label></td>

							<td><input type="text" placeholder="Enter First Name"
								name="fname" id="fname" minlength="3" maxlength="50" required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>

						</tr>
						<tr>
							<td ><label for="lname"><b>Last Name
										<font color="red">*</font>
								</b></label></td>
							<td><input type="text" placeholder="Enter Last Name"
								name="lname" id="lname" minlength="3" maxlength="50" required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td ><label for="age"><b>Age <font
										color="red">*</font></b></label></td>
							<td><input type="text" placeholder="Enter Age" name="age"
								id="age"></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>

							<td ><label for="gender"><b>Gender <font
										color="red">*</font></b></label></td>
							<td><select name="gender" style="width: 175px">
									<option>Select</option>
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
							<td ><label for="cno"><b>Contact <font
										color="red">*</font></b></label></td>
							<td><input type="tel" placeholder="Enter Contact" name="cno"
								id="cno" maxlength="10" pattern="[0-9]{10}" required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td ><label for="email"><b>Email <font
										color="red">*</font></b></label></td>
							<td><input type="email" placeholder="Enter Email"
								name="email" id="email"
								pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
								required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td ><label for="uid"><b>User Id <font
										color="red">*</font></b></label></td>
							<td><input type="text" placeholder="Enter user id"
								name="uid" id="uid" required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td ><label for="pass"><b>Password <font
										color="red">*</font></b></label></td>
							<td><input type="password" placeholder="Enter Password"
								name="pass" id="pass"
								pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" required></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td ><input class="button" type="submit"
								value="Register Here" style="height: 50px;"></input></td>
						</tr>
					</table>
			</form>
		</div>
		<div class="pa">
			<p style="padding-bottom: 200px;">
				<b> Already have an account?&nbsp;&nbsp;&nbsp;<a
					href="user_login.jsp">Sign In</a></b>
			</p>
	</center>
	</div>
	<footer>
	<p class="p">&copy;Shareyoureconomy</p>
	</footer>

</body>
</html>