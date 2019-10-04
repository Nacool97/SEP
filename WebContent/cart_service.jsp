<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/home.css">
</head>
<header class="header"> <img class="logo" src="./img/icon.png"
	alt="logo"></img> <a class="a" href="user?actionName=logout">Logout</a> </header>
<body>
	<c:if test="${removeCartStatus=='true'}">
	Item is removed from  cart Successfully</c:if>
	<div>
		<c:forEach var="service" items="${service}">
			<div
				style="height: 150px; width: 20%; border: 2px solid black; float: left; padding-top: 20px; margin-top: 50px; margin-left: 30px; padding-left: 20px;">
				service Name: ${service.getServicename()}; <br> service id:
				${service.getServiceid()}; <br> Category:
				${service.getCategory()}; <br> Price: ${service.getPrice()}; <br>
				Status: ${service.getStatus()}; <br> Time:
				${service.getTime()}; <br> Contact: ${service.getContact()}; <a
					href="userservice?serviceId=${service.getServiceid()}&actionName=delete">Delete</a>

			</div>
		</c:forEach>


	</div>
	<h3>
		<b>Total: ${total}</b>
	</h3>
</body>
<footer>
<p class="p">&copy; Shareyoureconomy</p>
</footer>


</body>
</html>