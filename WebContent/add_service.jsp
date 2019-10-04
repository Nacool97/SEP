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
<link rel="stylesheet" href="./css/home.css">
<script src="./js/addservice.js"></script>
<title>Insert title here</title>
</head>
<body class="body">
	<header class="header"> <img class="logo" src="./img/icon.png"></img>
	<a class="a" href="vendor?actionName=logout">Logout</a> 
	<a class="a" href="vendorservice?actionName=display">Home</a> </header>
	<center>
		
					<form name="myform" action="AddService"
			onsubmit="return validateServiceForm()" method="post">
			<div>
				<h1>Add Service Details</h1>

				<table>
					<tr>
						<td><label for="sid" class="td"><b>Service Id</b></label><font color="red">*</font></td>
										

						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Service Id"
							name="sid" id="sid"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="sname"><b>Service Name </b></label><font color="red">*</font></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Service Name"
							name="sname" id="sname"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>

					<tr>
						<td><label for="scategory"><b>Category</b></label><font color="red">*</font></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select name="scategory" style="width: 175px">
								<option>Select</option>
								<c:forEach var="scategory" items="${categoryL}">
									<option value="${scategory}">${scategory}</option>
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
						<td><label for="sprice"><b>Price</b><font color="red">*</font></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Price"
							name="sprice" id="sprice"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="sstatus"><b>Status</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Status"
							name="sstatus" id="sstatus"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="stime"><b>Time</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter time" name="stime"
							id="stime"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
</tr>
						<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="add"></td>
					</tr>
			
					<tr>
						<td><label for="scontact"><b>Contact Details</b></label></td>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" placeholder="Enter Contact Details"
							name="scontact" id="scontact"></td>
					</tr>

					<tr>
						<td colspan="2"><input class="button" type="submit"
							value="Submit" style="margin-left: 50px;"></input></td>
					</tr>
				</table>
		</form>

	</center>
	<footer>
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>


</body>
</html>