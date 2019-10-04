<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/registration.css">
</head>
<body class="bd">
	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	 <a class="a" href="vendorservice?actionName=display">Home</a>
	<a class="a" href="vendor?actionName=logout">Logout</a> </header>
	<center>
		<form name="myform" action="vendorservice" method="post">

			<h1>Add Category</h1>

			<table>
				<tr>
					<td><h2>
							<label for="category" class="td"><b>Category</b></label>
						</h2></td>

					<td><input type="text" placeholder="Enter Category"
						name="category" id="category"></td>
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
				<tr><input type="hidden" name="actionName" value="addcategory"></tr>
				<tr>
					<td colspan="2"><input class="button" type="submit"
						value="Submit"></input></td>
				</tr>
			</table>
		</form>

	</center>
	<footer>
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>


</body>
</html>