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
	<header class="header"> <img class="logo" src="./img/icon.png"
		alt="logo"></img> <a class="a" href="user?actionName=logout">Logout</a> <a
		class="a" href="userproduct?actionName=displaycart">Cart</a> <a class="a"
		href="userproduct?actionName=display">Home</a> </header>

	<%-- 	<center style="margin-top:100px;"> --%>
	<form action="userproduct" method="get">
		<table>

			<tr>
				<td><label for="category"><b>Category</b></label></td>
				<td><select name="category" style="width: 170px">
						<option value="select">Select</option>
						<c:forEach var="category" items="${categoryList}">
							<option value="${category}">${category}</option>
						</c:forEach>

				</select><tr>

				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
					type="hidden" name="actionName" value="search"></td>
					</tr>
					<button type="submit" name="submit" id="${category}" value="go">go</button></td>
			</tr>
			
		</table>
	</form>
	</center>
	<c:if test="${addCartStatus=='true'}">
	Item is Added to cart Successfully</c:if>
	<div>
		<c:forEach var="product" items="${product}">
			<div
				style="height: 100px; width: 15%; border: 2px solid black; float: left; padding-top: 20px; margin-top: 50px; margin-left: 30px; padding-left: 20px;">
				product Name: ${product.getProductName()}; <br> product id:
				${product.getProductId()}; <br> Category:
				${product.getCategory()}; <br> Price: ${product.getPrice()}; <br>
				Stock: ${product.getStock()}; <a
					href="userproduct?productId=${product.getProductId()}&actionName=addcart">Add
					to Cart</a>
			</div>
		</c:forEach>
	</div>
	<footer class="footer">
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>
</body>
</html>