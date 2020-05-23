<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inventory</title>
</head>
<body>
	<h1>Current Inventory List</h1>
	<c:forEach items="${invList}" var="listItem">
		<li>ProductId=${listItem.prodId}, &nbsp&nbsp ProductName=${listItem.prodName}, &nbsp&nbsp ProductQuant=${listItem.prodQuant}</li>
	</c:forEach>
	<h3>
		<a href="addToInventory">
			Add Product
		</a>
	</h3>
	<h3>
		<a href="updateInInventory">
			Update Product
		</a>
	</h3>
	<h3>
		<a href="deleteProductFromInventory">
			Delete Product from Inventory
		</a>
	</h3>
	<a href="getToOwnerDash">
		Return to Owner Dash
	</a>
</body>
</html>