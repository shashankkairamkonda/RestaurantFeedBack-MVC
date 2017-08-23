
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


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
	width: 335px;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 10px 17px 10px 19px;
	float: left;
	HEIGHT: 493px;
}

img {
	HEIGHT: 137px;
	WIDTH: 157px;
	border-radius: 2px;
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

h5 {
	font-size: 26px;
	-webkit-border-after: dashed;
	-webkit-border-start: dotted;
	-webkit-border-end: dotted;
	-webkit-border-before: dotted;
}
</style>
</head>
<body onload="display()">
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">
		<c:choose>
			<c:when test="${RloggedUser ne null }">



				<div id="navigation">
					<div id="anchor">
						<ul>
							<li><a href="restaurantHome.jsp">Home</a></li>

							<li><a href="addBranch.jsp">Add Branch</a></li>
							<li><a href="RestaurantController?action=getCuisineName">AddCuisine</a>
							</li>

							<li><a href="RestaurantController?action=getCuisine">Add
									Recipe</a><br></li>

							<li><a
								href="RestaurantController?action=viewBranchs&&restaurantid=${restaurant.restaurantId}">View
									Branches</a></li>
						</ul>
					</div>
				</div>
				<c:forEach items="${branchlist}" var="branch">
					<div id="box">

						<h5>Located at:</h5>


						<img alt="" src="images/branches/${branch.imagePath}">

						<table>
							<tr>
								<td>Located:</td>
								<td><c:out value="${branch.location}"></c:out></td>
							</tr>
							<tr>
								<td>City:</td>
								<td><c:out value="${branch.city}"></c:out></td>
							</tr>

							<tr>
								<td>State:</td>
								<td><c:out value="${branch.state}"></c:out></td>
							</tr>

							<tr>
								<td>Country:</td>
								<td><c:out value="${branch.country}"></c:out></td>
							</tr>

							<tr>
								<td>Postal Code:</td>
								<td><c:out value="${branch.postalCode}"></c:out></td>
							</tr>

							<tr>
								<td>Phone Number:</td>
								<td><c:out value="${branch.phoneNumber}"></c:out></td>
							</tr>
							<tr>
								<td>Email-Id:</td>
								<td><c:out value="${branch.emailId}"></c:out></td>
							</tr>
						</table>
						<br>
						<a href="RestaurantController?action=deleteBranch&&branchid=${branch.branchId}">Do you want to delete this branch</a><br><br>
						<a href="RestaurantController?action=recipelist&&branchid=${branch.branchId}">Do you want to view recipe</a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${branchlist}" var="branch">
					<div id="box">

						<h5>Located at:</h5>


						<img alt="" src="images/branches/${branch.imagePath}">

						<table>
							<tr>
								<td>Located:</td>
								<td><c:out value="${branch.location}"></c:out></td>
							</tr>
							<tr>
								<td>City:</td>
								<td><c:out value="${branch.city}"></c:out></td>
							</tr>

							<tr>
								<td>State:</td>
								<td><c:out value="${branch.state}"></c:out></td>
							</tr>

							<tr>
								<td>Country:</td>
								<td><c:out value="${branch.country}"></c:out></td>
							</tr>

							<tr>
								<td>Postal Code:</td>
								<td><c:out value="${branch.postalCode}"></c:out></td>
							</tr>

							<tr>
								<td>Phone Number:</td>
								<td><c:out value="${branch.phoneNumber}"></c:out></td>
							</tr>
							<tr>
								<td>Email-Id:</td>
								<td><c:out value="${branch.emailId}"></c:out></td>
							</tr>
						</table>
						<a href="RestaurantController?action=recipelist&&branchid=${branch.branchId}">Do you want to view recipe</a>

					</div>
				</c:forEach>
			</c:otherwise>

		</c:choose>
	</div>


	<div>


		<jsp:include page="footer.html"></jsp:include>

	</div>
</body>
</html>