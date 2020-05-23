<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete From Inventory</title>
</head>
<body>
	<h1>Enter ProductID to delete it from the inventory</h1>
	<div>
		<s:form action="deletingProduct" modelAttribute="deleteProd" method="post" >
			<s:label path="prodId">Product Id : </s:label>
			<s:input path="prodId"></s:input>
			<s:errors path="prodId"></s:errors>
			<br><br>
			
			<s:button type="submit">Delete</s:button>
		</s:form><br>
	</div>
</body>
</html>