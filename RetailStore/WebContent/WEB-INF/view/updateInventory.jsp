<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating Inventory Products</title>
</head>
<body>
	<h1>Add more Quantity to it</h1>
	<div>
		<s:form action="updatingProduct" modelAttribute="updatedProd" method="post" >
			<s:label path="prodId">Product Id : </s:label>
			<s:input path="prodId"></s:input>
			<s:errors path="prodId"></s:errors>
			<br><br>
			
			<s:label path="prodQuant">Product Quantity : </s:label>
			<s:input path="prodQuant"></s:input>
			<s:errors path="prodQuant"></s:errors>
			<br><br>
			
			<s:button type="submit">Update</s:button>
		</s:form><br>
	</div>
</body>
</html>