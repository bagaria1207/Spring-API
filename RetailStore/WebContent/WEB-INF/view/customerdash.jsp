<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer DashBoard</title>
</head>
<body>
	<h1>Welcome to Customer DASHBOARD</h1>
		<a href="placedOrder?custId=${loginCustomer.custId}">
			Orders
		</a>
		<br><br>
		<a href="newOrder">
			New Order
		</a>
		<br><br>
		<a href="popularProducts?custId=${loginCustomer.custId}">
			Popular Products
		</a>
		<h5>
			<a href="customerLogout">LOGOUT</a>
		</h5>
</body>
</html>