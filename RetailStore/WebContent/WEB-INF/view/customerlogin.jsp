<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
<style type="text/css">
	div{
		margin-left:35%;
		margin-top:14%;
	}
</style>
</head>
<body>
	<div>
		<s:form action="checkCustomer" modelAttribute="newCustomer" method="post" >
			<s:label path="custName">Customer UserName : </s:label>
			<s:input path="custName"></s:input>
			<s:errors path="custName"></s:errors>
			<br><br>
			
			<s:label path="custPass">Customer PassWord : </s:label>
			<s:password path="custPass"></s:password>
			<s:errors path="custPass"></s:errors>
			<br><br>
			
			<s:button type="submit">Login</s:button>
		</s:form><br>
	</div>
</body>
</html>