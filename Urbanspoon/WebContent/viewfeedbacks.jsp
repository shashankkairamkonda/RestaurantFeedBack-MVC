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
    height: 128px;
    width: 214px;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 10px 17px 10px 19px;
	float: left;
}

#navigation {
	background-color: #150c0c;
	padding: 39px;
	margin: 3px;
}

img {
	border-radius: 2px;
	width: 40%;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">
	
	<c:if test="${feedbacklist eq null }">
	<h1>Sorry no feedbacks</h1>
	
	</c:if>
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


	



		<c:forEach items="${feedbacklist}" var="feedback">
			<div id="box">
			<table>
			<tr><th>FeedBack:</th></tr>
			<tr><td>Comments:</td><td>${feedback.comments}</td></tr>
			<%-- <tr><td>Date of feedback:</td><td>${feedback.feedbackDate}</td></tr> --%>
			<tr><td>Rating:</td><td>${feedback.rating}</td></tr>
			</table>
			</div>
		</c:forEach>

			</c:when>
			<c:otherwise>
			
			

		<c:forEach items="${feedbacklist}" var="feedback">
			<div id="box">
			<table>
			<tr><th>FeedBack:</th></tr>
			<tr><td>Comments:</td><td>${feedback.comments}</td></tr>
			<%-- <tr><td>Date of feedback:</td><td>${feedback.feedbackDate}</td></tr> --%>
			<tr><td>Rating:</td><td>${feedback.rating}</td></tr>
			</table>
			</div>
		</c:forEach>

			</c:otherwise>

		</c:choose>

		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>
	</div>


</body>
</html>