<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Urban Spoon</title>
<style type="text/css">
body {
	margin: 0px;
}

#header {
	background-image:
		url('http://localhost:8011/Urbanspoon/images/color.jpg');
	height: 15%;
}

ul, li {
	float: left;
	display: inline;
	margin: -10PX 0PX 0PX 10PX;
}

a {
	padding: 6px;
	background: #cbdcea;
	color: currentColor;
	cursor: initial;
}

#right {
	float: right;
}

input[type="search"] {
	width: 35%;
	border-radius: 10px;
	height: 30%;
	border-color: orange;
}

#logo img {
	height: 58px;
	width: 74px;
	position: absolute;
	border-radius: 12px;
}

input[type="submit"] {
	height: 30px;
	border-radius: 7px;
}
</style>
</head>

<body>
	<div id="header">
		<div id="logo">
			<a href="home.jsp"><img alt="" src="images/UrbanSpoon.jpg"></a>
		</div>
		<div>. .</div>

		<div id="right">
			<ul>
				<c:if test="${ loggedUser eq null }">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="registration.jsp">Register</a></li>
					<li><a href="login.jsp">Login</a></li>
				</c:if>
				<c:if test="${ loggedUser ne null }">
					<li><a href="home.jsp">Home</a></li>
					<li><a href="logout.jsp">Logout</a></li>
				</c:if>
			</ul>
		</div>

	</div>




</body>
</html>