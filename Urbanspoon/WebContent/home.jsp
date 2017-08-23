
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

#header {
	background-color: #408a3e;
	height: 15%;
}

#box {
	width: 30%;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 10px 0px 0px 120px;
	float: left;
	height: 60%;
}

#serch {
	height: 25%;
	width: 90%;
}

img {
	border-radius: 2px;
    width: 238px;
    height: 211px;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<br>
	<br>
	<div id="serch">
		<center>
		<form action="RestaurantController" method="post">
		<input type="hidden" name="action" value="search">
			<select name="city">
				   <option value="hyderabad">Hyderabad</option>
				   <option value="banglore">Banglore</option>
				   <option value="chennai">Chennai</option>
				   </select>
			<input type="search" name="search" placeholder="search">
			<input type="submit" value="search">
		</form>
	</div>
	</center>
	<center>
		<div id="container">

			<div id="box">
				<h1>Food</h1>
				<a href="HomeController?action=restaurantfood"><img alt="" src="images/food.jpg" height="120" width="120"></a><br>
				<br>
				<br> <a href="HomeController?action=restaurantfood">View Food</a>

			</div>
			<div id="box">
				<h1>Restaurant</h1>
				<a href="HomeController?action=restauranthome"><img alt="" src="images/restaurant.jpg" height="120" width="120"></a><br>
				<br>
				<br> <a href="HomeController?action=restauranthome">View Restaurant</a>
			</div>
		</div>
		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>
	</center>


</body>
</html>