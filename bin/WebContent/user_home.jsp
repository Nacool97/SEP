<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="body">
	<header class="header" >
	<img class="logo" src="./img/icon.png" alt="logo"></img>
		
		<a class="a" href="home.jsp">Home</a>
		<a class="a" href="Logout">Logout</a>
	</header>
	
	<center style="margin-top:100px;">
	<form action="ShowProductListUser"> 
	<input class="button" type="submit" value="Products" ></input>
	</form>
	<form action="ShowServiceListUser">
	<input class="button" type="submit" value="Services"></input>
	</form>
	</center>
	<footer class="footer"  ><p class="p">&copy;ShareYourEconomy</p></footer>
</body>
</html>