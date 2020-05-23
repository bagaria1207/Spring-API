<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Orders</title>
</head>
<body>
	<h1>Get All Placed Order</h1>
	<c:forEach items="${placedOrders}" var="entry">
		OrderId=${entry.key},&nbsp&nbsp 
		<c:forEach items="${entry.value}" var="listItem">
			<li>CustId=${listItem.custId}, &nbsp&nbsp ProductName=${listItem.prodName}, &nbsp&nbsp ProdQuant=${listItem.prodQuant}
		</c:forEach>
		<br><br>
	</c:forEach>
	<br><br><br>
	<a href="getToOwnerDash">
		Return to Owner Dash	
	</a>
</body>
</html>