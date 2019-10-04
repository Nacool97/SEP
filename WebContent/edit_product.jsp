<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  -->

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
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/registration.css">

</head>
<body>
	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	<a class="a" href="vendor?actionName=logout">Logout</a> 
	<a class="a" href="product_home.jsp">Home</a> </header>
	<h1 class="h"
		style="color: #000000; text-align: center; padding-top: 20px;">Edit
		Product Details</h1>


	<form action="vendorproduct" method="post">
		<center>
			<table class="baccc" style="padding-top: 50px;">
				<tr>
					<td colspan="2"><label for="pid"><b>Product Id	<font color="red">*</font></b></label></td>
					<td><input type="text" placeholder="Enter Product id"
						name="pid" id="pid" value="${product.getProductId()}" required></td>
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
					<td colspan="2"><label for="pname"><b>Name	<font color="red">*</font></b></label></td>
					<td><input type="text" placeholder="Enter Product name"
						name="pname" id="pname" value="${product.getProductName()}" required></td>
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
					<td colspan="2"><label for="category"><b>Category</b></label></td>
					<td><select name="category" style="width: 170px">
							<option value="${product.getCategory()}">${product.getCategory()}</option>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category}">${category}</option>
							</c:forEach>
					</select></td>
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
					<td colspan="2"><label for="price"><b>Price	<font color="red">*</font></b></label></td>
					<td><input type="text" placeholder="Enter Price" name="price"
						id="price" value="${product.getPrice()}" required></td>
				</tr>
				<tr>
					<td colspan=2><label for="stock"><b>Stock 	<font color="red">*</font></b></label></td>
					<td><input type="text" placeholder="Enter Stock" name="stock"
						id="stock" value="${product.getStock()}" required></td>
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
					<td colspan="2"><input  class="button" type="submit" name="submit"
						value="submit" style="margin-left: 160px; margin-top:30px; height:50px"></td>
				</tr>
				 <tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="edit"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
			</table>
		</center>
	</form>


	<footer class="f" style="color: white;text-align:right;">
	<p style="padding: 30px;">&copy;Share your economy</p>
	</footer>

</body>
</html>