<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style type="text/css">
#container {
	height: 115%;;
}

#box {
    height: 167px;
    width: 217px;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 10px 17px 10px 19px;
	float: left;
}

img {
	border-radius: 2px;
	width: 40%;
}

h5 {
	font-size: 26px;
	-webkit-border-after: dashed;
	-webkit-border-start: dotted;
	-webkit-border-end: dotted;
	-webkit-border-before: dotted;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">

		<table>


			<c:forEach items="${restaurantlist}" var="restaurant">
				<div id="box">
					<input type="hidden" name="restaurantid"
						value="${restaurant.restaurantId}">
					<h5>
						<c:out value="${restaurant.registrationName}"></c:out>
					</h5>

					<div id="anchor">
						<a href="RestaurantController?action=viewBranchs&&restaurantid=${restaurant.restaurantId}">Do you want to view branch</a><br>
						<br>
						<br>
						<br> 
					</div>
				</div>
			</c:forEach>


		</table>
		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>
	</div>


</body>
</html>