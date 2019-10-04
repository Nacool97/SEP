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
		<center>
		<form name="myform" action="vendorservice"
			onsubmit="return validateServiceForm()" method="post">
			<div>
				<h1>Add Service Details</h1>

				<table>
					<tr>
						<td colspan="2"><label for="sid" class="td"><b>Service Id	<font color="red">*</font></b></label></td>

						<td><input type="text" placeholder="Enter Service Id"
							name="sid" id="sid" value="${service.getServiceid()}"></td>
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
						<td colspan="2"><label for="sname"><b>Service Name 	<font color="red">*</font></b></label></td>
						<td><input type="text" placeholder="Enter Service Name"
							name="sname" id="sname" value="${service.getServicename()}">
						</td>
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
						<td colspan="2"><label for="scategory"><b>Category 	<font color="red">*</font></b></label></td>
						<td><select name="scategory" style="width: 175px">
								<option value="${service.getCategory()}">${service.getCategory()}</option>
								<c:forEach var="scategory" items="${categoryList}">
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
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><label for="sprice"><b>Price 	<font color="red">*</font></b></label></td>
						<td><input type="text" placeholder="Enter Price"
							name="sprice" id="sprice" value="${service.getPrice()}"></td>
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
						<td colspan="2"><label for="sstatus"><b>Status</b></label></td>
						<td><input type="text" placeholder="Enter Status"
							name="sstatus" id="sstatus" value="${service.getStatus()}"></td>
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
						<td colspan="2"><label for="stime"><b>Time</b></label></td>
						<td><input type="text" placeholder="Enter time" name="stime"
							id="stime" value="${service.getTime()}"></td>
					</tr>
<tr>
						
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input
							type="hidden"  name="actionName" value="edit"></td>
					</tr>

					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
				
				
					<tr>
						<td colspan="2"><label for="scontact"><b>Contact Details<font color="red">*</font></b></label></td>
						<td><input type="text" placeholder="Enter Contact Details"
							name="scontact" id="scontact" value="${service.getContact()}"></td>
					</tr>
					<tr>
						<td colspan="2"><input class="button" type="submit"
							value="Submit" style="margin-left: 100px; margin-top:30px"></input></td>
					</tr>
					
				</table>
		</form>
	</center>

	<footer>
	<p class="p">&copy;ShareYourEconomy</p>
	</footer>


</body>
</html>