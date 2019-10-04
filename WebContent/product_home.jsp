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
<body class="bd" style="overflow: scroll;">
	<header class="header"> <img class="logo"
		src="./img/icon.png" alt="logo"></img> <a class="a" href="vendor?actionName=logout">Logout</a>
	 <a class="a" href="vendorproduct?actionName=get">Add Product</a> 
	 <a class="a" href="addcategory.jsp">Add Category</a> 
	 <a class="a" href="vendorproduct?actionName=display">Home</a></header>


	<div>
		<c:forEach var="product" items="${productList}">
			<div
				style="height: 100px; width: 30%; border: 2px solid black; float: left; padding-top: 20px; margin-top: 50px; margin-left: 30px; padding-left: 20px;">
				product Name: ${product.getProductName()}; <br> product id:
				${product.getProductId()}; <br> Category:
				${product.getCategory()}; <br> Price: ${product.getPrice()}; <br>
				Stock: ${product.getStock()}; <a
					href="vendorproduct?productId=${product.getProductId()}&actionName=update">Edit</a> <a
					href="vendorproduct?productId=${product.getProductId()}&actionName=delete">Delete</a>

			</div>
		</c:forEach>


	</div>

	</center>
	<div>
		<footer class="footer">
		<p class="p">&copy;ShareYourEconomy</p>
		</footer>
	</div>
</body>
</html>