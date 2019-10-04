<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body class="bd">
	<header class="header"> <img class="logo"
		src="./img/icon.png" alt="logo"></img> <a class="a" href="home.jsp">Home</a>
		<a class="a" href="EditVendor">Edit vendor</a>
	<a class="a" href="Logout">Logout</a> </header>

	<img class="products" src="./img/Products12.png" height="150px" width="200px">
	 
		<form action="userproduct">
		  <input type="hidden" name="actionName" value="display">
			<input class="buttonp" type="submit" value="Products"></input>
		</form>
		
      <img class="services" src="./img/services1.png" height="150px" width="200px" >
		<form action="userservice">
		<input type="hidden" name="actionName" value="display">
			<input class="buttons" type="submit" value="Services"></input>
		</form>
		
	<footer class="footer">
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>
</body>
</html>
