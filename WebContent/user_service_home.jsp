<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bd">
	<header class="header"> <img class="logo"
		src="./img/icon.png" alt="logo"></img> <a class="a"
		href="user_service_home.jsp">Home</a> <a class="a"
		href="userservice?actionName=displayCart">Cart</a> <a class="a" href="user?actionName=logout">Logout</a>
	</header>

	<%-- 	<center style="margin-top:100px;"> --%>
	<form action="userservice" method="post">
		<table>

			<tr>
				<td><label for="category"><b>Category</b></label></td>
				<td><select name="category" style="width: 170px">
						<option value="select">Select</option>
						<c:forEach var="category" items="${categoryList}">
							<option value="${category}">${category}</option>
						</c:forEach>
						
				</select>
				<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="search"></td>
					</tr><input type="submit" value="search"></input></td>

			</tr>
		</table>
	</form>
	</center>
	<c:if test="${addCartStatus=='true'}">
	Item is Added to cart Successfully</c:if>
	<div>
		<c:forEach var="service" items="${service}">
			<div
				style="height: 150px; width: 20%; border: 2px solid black; float: left; padding-top: 20px; margin-top: 50px; margin-left: 30px; padding-left: 20px;">
				product Name: ${service.getServicename()}; <br> product id:
				${service.getServiceid()}; <br> Category:
				${service.getCategory()}; <br> Price: ${service.getPrice()}; <br>
				Status: ${service.getStatus()}; <br> Time:
				${service.getTime()}; <br> Contact: ${service.getContact()}; <a
					href="userservice?serviceId=${service.getServiceid()}&actionName=add">Add
					to Cart</a>

			</div>
		</c:forEach>


	</div>
	<footer class="footer">
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>
</body>
</html>