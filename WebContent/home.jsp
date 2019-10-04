<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/registration.css">
<link rel="stylesheet" href="./css/home.css">

<title>Insert title here</title>
<% response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%> 
 <style>
body {
	background-image: url("./img/bgimg.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
 
</head>

<body class="body">
	<header class="header"> 
	   <img class="logo" src="./img/icon.png"
		alt="logo"></img> 
		<a class="a" href="home.jsp "><b>Home</b></a> </header>

	<div class="div1">
		<a href="user_registration.jsp">
		<img class="img2" src="./img/user.jpg"></a> 
		<a href="vendor_registration.jsp"><img class="img1" src="./img/vendor.jpg"></a>
		<h1 class="user">USER</h1>
		<h1 class="vendor">VENDOR</h1>
		
	</div>
	<footer>
	<p class="p">&copy; ShareYourEconomy</p>
	</footer>
</body>

</html>
