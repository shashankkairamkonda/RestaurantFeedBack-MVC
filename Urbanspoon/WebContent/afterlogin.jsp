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
select * from restaurant where restaurant_id = (select restaurant_id from branch where restaurant_id=(select branch_id from serve where branch_id=6));
#box {
	width: 50%;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 3px 0px 0px 15px;
	float: left;
	height: 100%;
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

		<form action="HomeController" method="post">
			<table>

				<c:forEach items="${recipesList}" var="recipe">
					<tr><th>Item Name:</th>
					<td><c:out value="${recipe.name}"></c:out></td>
					</tr>
					<input type="hidden" name="recipeid" value="${recipe.recipeId}">


					<input type="hidden" name="action" value="feedback">
					<tr>
					<th>Comments:</th>
					<td><textarea name="comments"></textarea></td>
					</tr>
					<tr>
					<th>Date:</th>
					<td><input type="date" name="date"></td>
					</tr>
					<tr> 
					<th>Rating:</th>
					<td>
					<select	name="rating">
							<option>Rating</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select>
					</td>
					</tr>
					
				</c:forEach>

			</table>
			
			<br><br><br>
			<input type="submit" value="submit">
		</form>


		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>
	</div>


</body>
</html>