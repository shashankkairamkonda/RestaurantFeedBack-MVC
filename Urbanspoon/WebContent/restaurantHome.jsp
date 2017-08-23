
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/Main.css">
<title>Insert title here</title>
<script type="text/javascript">
	function addbranch() {
		document.getElementById("addbranch").style.display = "block";
		document.getElementById("display").style.display = "none";

	}
	function display() {
		document.getElementById("display").style.display = "block";
		document.getElementById("addbranch").style.display = "none";

	}
</script>
<style type="text/css">
#container {
	height: 115%;;
}

#box {
	width: 18%;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 3px 0px 0px 15px;
	float: right;
}

img {
	border-radius: 2px;
	width: 70%;
}

#display {
	width: 80%;
	float: right;
	margin-top: -57%;
}

#nav-links {
	width: 20%;
	height: 100%;
	background-color: red;
}

#links {
	position: absolute;
	margin-top: 70px;
	margin-left: 43px;
}

ul {
	MARGIN: 30px 49px
}

#navigation {
	background-color: #150c0c;
	padding: 39px;
	margin: 3px;
}

#anchor {
	font-size: 20px;
}

#anc {
	color: #f7f5f6;
}
</style>
</head>
<body onload="display()">
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">
		<div id="navigation">
				<div id="anchor">
			<ul>
					<li>
							<a href="restaurantHome.jsp">Home</a> 
					</li>
					
					<li>
							<a href="addBranch.jsp">Add Branch</a> 
					</li>
					<li>
							<a href="RestaurantController?action=getCuisineName">AddCuisine</a>
					</li>

					<li>
							 <a href="RestaurantController?action=getCuisine">Add Recipe</a><br>
					</li>

					<li>
							<a href="RestaurantController?action=viewBranchs&&restaurantid=${restaurant.restaurantId}">View Branches</a>
					</li>
				</ul>
				</div>
		</div>
		
		<h1> Wel-Come-${restaurant.registrationName} </h1><br><br>
		<h1>${msg}</h1>
		<a href="updaterestaurant.jsp">Do you want to update your profile</a>
		
	</div>
	<div>


		<jsp:include page="footer.html"></jsp:include>

	</div>
</body>
</html>