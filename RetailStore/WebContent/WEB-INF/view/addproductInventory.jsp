<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding to Inventory</title>
</head>
<body>
	<h1>Enter Product details to be added</h1>
	<div>
		<s:form action="addingNewProduct" modelAttribute="newProd" method="post" >
			<s:label path="prodName">Product Name : </s:label>
			<s:input path="prodName"></s:input>
			<s:errors path="prodName"></s:errors>
			<br><br>
			
			<s:label path="prodQuant">Product Quantity : </s:label>
			<s:input path="prodQuant"></s:input>
			<s:errors path="prodQuant"></s:errors>
			<br><br>
			
			<s:label path="prodPrice">Product Price: </s:label>
			<s:input path="prodPrice"></s:input>
			<s:errors path="prodPrice"></s:errors>
			<br><br>
			
			<s:button type="submit">Add</s:button>
		</s:form><br>
	</div>
</body>
</html>