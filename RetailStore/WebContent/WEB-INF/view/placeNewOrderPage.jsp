<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place New Order</title>
</head>
<body>
	<h1>Place new Order</h1> 
	<br><br>
	<div>
		<s:form action="placingNewOrder" modelAttribute="nOrder" method="post" >
			<s:label path="ordId">Customer OrderId : </s:label>
			<s:input path="ordId"></s:input>
			<s:errors path="ordId"></s:errors>
			<br><br>
			
			<s:label path="custId">CustomerId : </s:label>
			<s:input path="custId"></s:input>
			<s:errors path="custId"></s:errors>
			<br><br>
			
			<s:label path="prodName">Product Name : </s:label>
			<s:input path="prodName"></s:input>
			<s:errors path="prodName"></s:errors>
			<br><br>
			
			<s:label path="prodQuant">Product Quantity : </s:label>
			<s:input path="prodQuant"></s:input>
			<s:errors path="prodQuant"></s:errors>
			<br><br>
			
			<s:button type="submit">Place Order</s:button>
		</s:form><br>
	</div>
	<a href="returntoCustomerDashboard?custId=${customerId}">Return To Customer Dash</a>
</body>
</html>