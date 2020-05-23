<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Order Page</title>
</head>
<body>
	<h1>All Orders Placed by the Customer</h1>
	<c:forEach items="${listPlacedOrder}" var="listItem">
		<li>OrderId=${listItem.ordId}, &nbsp&nbsp ProductName=${listItem.prodName}, &nbsp&nbspProductQuantity=${listItem.prodQuant}</li>
	</c:forEach>
	<br><br>
	<a href="returntoCustomerDashboard?custId=${customerId}">Return To Customer Dash</a>
</body>
</html>