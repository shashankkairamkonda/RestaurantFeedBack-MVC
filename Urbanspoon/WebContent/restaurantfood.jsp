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
	width: 335px;
	background-color: aquamarine;
	border-radius: 5px;
	padding: 5px;
	margin: 10px 17px 10px 19px;
	float: left;
	height: 442px;
	
}

img {
	border-radius: 2px;
    width: 40%;
}
h5{
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


		<c:if test="${ loggedUser eq null }">
			<c:forEach items="${recipesList}" var="recipe">
				<div id="box">
				
				<h5>
						<c:out value="${recipe.name}"></c:out>
					</h5>
					
					<a href=""><img height="100" width="150" alt="" src="images/recipes/${recipe.imagePath}"></a>
					<br>
					<h4>Description:${recipe.description}</h4>
					<h4>IsVeg:${recipe.isVeg}</h4>
					<br>
					<a href="login.jsp">Do you want add feedback.</a>
					<br><br>
					<a href="HomeController?action=viewfeedback&recipeid=${recipe.recipeId}">Do you want view feedback.</a>

				</div>
			</c:forEach>
		</c:if>

		<c:if test="${ loggedUser ne null }">
			<c:forEach items="${recipesList}" var="recipe">
				<div id="box">
					<h5>
						<c:out value="${recipe.name}"></c:out>
					</h5>
					<a href="HomeController?action=sendrid&value=${recipe.recipeId}"><img height="100" width="200" src="images/recipes/${recipe.imagePath}"></a>
					
					<br>
					<h4>Description:${recipe.description}</h4>
					<h4>IsVeg:${recipe.isVeg}</h4>
					<br>
					<a href="HomeController?action=sendrid&value=${recipe.recipeId}">Do you want add feedback.</a>
					<br><br>
					<a href="HomeController?action=viewfeedback&recipeid=${recipe.recipeId}">Do you want view feedback.</a>
					
				</div>
			</c:forEach>
		</c:if>

		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>
	</div>


</body>
</html>