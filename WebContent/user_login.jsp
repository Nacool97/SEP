<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="./css/registration.css">
<script src="./js/vendor_login.js"></script>
<title>Insert title here</title>
</head>

<body class="body">

	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	 <a class="a" href="">Home</a> </header>
	<center style="margin-top: 100px;">
		<form name="myform" action="user"
			onsubmit="return validateuserRegistrationForm()" method="post">
			<div>
				<h1>User Sign-In</h1>
				<c:if test="${loginstatus==true }">

					<h3 style="color: red;">Invalid userid or password...</h3>

					
				</c:if>
				<table>
					<tr>
						<td colspan="2"><label for="uid"><b>User Id</b><font color="red">*</font></label></td>
						<td><input type="text" placeholder="Enter user id" name="uid"
							id="uid"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="pass"><b>Password</b><font color="red">*</font></label></td>
						<td><input type="password" placeholder="Enter Password"
							name="pass" id="pass"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
				<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="login"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input class="button" type="submit"
							value="Sign-In"></input></td>
					</tr>
				</table>
		</form>

	</center>
	<footer>
	<p class="p">&copy;Shareyoureconomy</p>
	</footer>




</body>
</html>