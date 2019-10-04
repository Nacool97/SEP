
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
<link rel="stylesheet" href="./css/registration.css">
<script src="./js/addproduct.js"></script>
<link rel="stylesheet" href="./css/home.css">
<title>Insert title here</title>
</head>
<body class="body">
	<!--  -->
	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	<a class="a" href="vendor?actionName=logout">Logout</a>
	<a class="a" href="product_home.jsp">Home</a>
	 </header>
	<center>
			<form name="myform" action="vendorproduct"
			onsubmit="return validateProductForm()" method="post">
			<div>
				<h1>Add Product Details</h1>

				<table>
					<tr>
						<td colspan="2"><label for="pid" class="td"><b>Product Id</b><font color="red">*</font></label></td>

						<td><input type="text" placeholder="Enter Product Id"
							name="pid" id="pid"></td>
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
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="name"><b>Product Name </b><font color="red">*</font></label></td>
						<td><input type="text" placeholder="Enter Product Name"
							name="pname" id="name"></td>
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
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="category"><b>Category</b><font color="red">*</font></label></td>
						<td><select name="category" style="width: 170px">
								<option value="select">Select</option>
								<c:forEach var="category" items="${categoryL}">
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
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="price"><b>Price</b><font color="red">*</font></label></td>
						<td><input type="text" placeholder="Enter Price" name="price"
							id="price"></td>
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
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="stock"><b>Stock</b></label></td>
						<td><input type="text" placeholder="Enter quantity"
							name="stock" id="stock"></td>
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
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="add"></td>
					</tr>

					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><input class="button" type="submit"
							value="Submit" style="margin-left: 120px; height: 50px;"></input>
						</td>
					</tr>
				</table>
		</form>

	</center>
	<footer>
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>


</body>

</html>