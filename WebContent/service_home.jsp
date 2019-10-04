<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bd">
	<header class="header"> <img class="logo"
		src="./img/icon.png" alt="logo"></img> <a class="a" href="vendor?actionName=logout">Logout</a>
	<a class="a" href="vendorservice?actionName=display">Home</a> <a class="a"
		href="vendorservice?actionName=get">Add Service</a> <a class="a"
		href="add_categoryservice.jsp">Add Category</a> </header>
	<center style="margin-top: 25px;">

		<div>
			<c:forEach var="service" items="${serviceList}">
				<div
					style="height: 150px; width: 20%; border: 2px solid black; float: left; margin-left: 30px; padding-left: 5px; padding-top: 10px;">
					Service Name: ${service.getServicename()} <br> Service id:
					${service.getServiceid()} <br> Category:
					${service.getCategory()} <br> Price: ${service.getPrice()} <br>
					Time: ${service.getTime()} <br> Status: ${service.getStatus()}
					<br> Contact: ${service.getContact()}<br> <a
						href="vendorservice?serviceid=${service.getServiceid()}&actionName=update">Edit</a> <a
						href="vendorservice?serviceid=${service.getServiceid()}&actionName=delete">Delete</a>

				</div>
			</c:forEach>


		</div>

		<!--<form action="AddCategorys" method="post"> 
	 <input class="button" type="submit" value="Add Service" ></input>
	</form>
	<form action="add_categoryservice.jsp">
	<input class="button" type="submit" value="Add Category"></input>
	</form> -->
	</center>
	<footer class="footer">
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>
</body>
</html>