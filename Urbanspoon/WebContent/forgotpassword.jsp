
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
<script type="text/javascript">
	function userform() {
		document.getElementById("user").style.display = "block";
		document.getElementById("restaurant").style.display = "none";

	}
	function restaurantform() {
		document.getElementById("restaurant").style.display = "block";
		document.getElementById("user").style.display = "none";

	}
</script>
</head>
<body onload="userform()">
	<jsp:include page="header.jsp"></jsp:include>

	<div id="container">
		<div align="center" id="register">


			<form action="HomeController" id="user" method="post" onsubmit="return formvalidation()">
				<h4>User</h4>
				<p>${error}</p>
				<fieldset id="fields">
					<input type="hidden" name="action" value="userReset">
					<table>
					<tr><td>Email Id</td><td> <input type="email" name="EmailId"></td></tr>
					</table>
					<input type="submit" value="submit">
				</fieldset>

			</form>
			<form action="HomeController" id="restaurant" method="post" onsubmit="return formvalidation()">
				<h4>Restaurant</h4>
				<p>${error}</p>
				<fieldset id="fields">
				   <input type="hidden" name="action" value="restaurantReset">
					<table>
					<tr><td>Restaurant Name</td><td> <input type="text" name="name"></td></tr> 
					</table>
					
					
						 <input type="submit" value="submit">
				</fieldset>

			</form>

			<button onclick="userform()">User</button>
			<button onclick="restaurantform()">Restaurant</button>
		</div>

	</div>


</body>
</html>