
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


		<form action="RestaurantController" method="post" id="restautrant"
			enctype="multipart/form-data" onsubmit="return formvalidation()">
			<input type="hidden" name="action" value="addrecipe">
			<h3>Add Recipe</h3>
			<fieldset id="fields">
				<table border="2">
					<c:forEach items="${cuisineList}" var="cuisine12">


						<tr>
							<th>Select Cuisine:</th>
							<td width="100px"><input type="radio" name="cuisineid"
								value="${cuisine12.cuisineId}"></td>
							<th>Name of Cuisine:</th>
							<td><c:out value="${cuisine12.name}"></c:out></td>
							<th>country:</th>
							<td><c:out value="${cuisine12.country}"></c:out></td>
							<th>country:</th>
							<td><c:out value="${cuisine12.description}"></c:out></td>
						<tr>
					</c:forEach>
				</table>
					
				<div id="container">
					<div align="center" id="subcontainer">
					
					<table>
					<tr>
					<td>Select Branch: </td>
				<td><select id="branchid" name="branchid">
					
							<c:forEach var="branch" items="${branchlist}">

								<option value="${branch.branchId}">${branch.location}</option>

							</c:forEach>

						</select>
					</td>
					</tr>
					<tr>
						 <td>Name of Item:</td> 
						<td><input type="text" name="name"> </td>
					</tr>
						<tr>
						<td>Description:</td>
						<td><input type="text" name="description"></td>
						</tr>
						 <tr>
						 <td>Price:</td>
						 <td><input type="text" name="price"> </td>
						 </tr>
						 <tr>
						 <td>Image:</td>
						 <td><input type="file" name="image" size="20"></td>
						 </tr>
						 <tr> 
						 <td>Veg/Non-Veg:</td>
						 <td><select name="isveg">
							<option value="false">Non-Veg</option>
							<option value="true">Veg</option>
						</select>
						
						</td>
						</tr>
					</table>
						 <input type="submit" value="Submit">
					</div>
				</div>
			</fieldset>
		</form>


	</div>
</body>
</html>