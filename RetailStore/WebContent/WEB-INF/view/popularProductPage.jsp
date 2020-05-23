<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {
	
	var dps = [[]];
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		exportEnabled: true,
		//theme: "light2", // "light1", "dark1", "dark2"
		title: {
			text: "Popular Products"
		},
		data: [{
			type: "pie",
			yValueFormatString: "#,##0\"%\"",
			showInLegend: true,
			indexLabel: "{y}",
			indexLabelPlacement: "inside",
			dataPoints: dps[0]
		}]
});
 
	var yValue;
	var name;
	 
	<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		<c:forEach items="${dataPoints}" var="dataPoint">
			yValue = parseFloat("${dataPoint.y}");
			name = "${dataPoint.name}";
			dps[parseInt("${loop.index}")].push({
				name : name,
				y : yValue
			});
		</c:forEach>
	</c:forEach>
	 
	chart.render();
 
}
</script>
<title>Popular Product Page</title>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<a href="returntoCustomerDashboard?custId=${customerId}">Return To Customer Dash</a>
</body>
</html>