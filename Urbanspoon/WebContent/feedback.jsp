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

subcontainer{
    width: 459px;
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
		<div align="center" id="subcontainer">
			<form action="HomeController" method="post" onsubmit="return formvalidation()">
			<input type="hidden" name="recipeid" value="${recipeid}">
			<table>
			<tr><td>Your selected recipe is added by:</td><td><c:out value="${restaurant.registrationName}"></c:out></td></tr>
			<tr><td>Location:</td><td><c:out value="${branch.location}"></c:out></td></tr>
			<tr><td>City:</td><td><c:out value="${branch.city}"></c:out></td></tr>
			<tr><td>State:</td><td><c:out value="${branch.state}"></c:out></td></tr>
			<tr><td>Email I'd:</td><td><c:out value="${branch.emailId}"></c:out></td></tr>
			<tr><td>Phone Number:</td><td><c:out value="${branch.phoneNumber}"></c:out></td></tr>
			
			</table>
			
				<h3>Give your valuable FeedBack:</h3>
				<input type="hidden" name="action" value="feedback"><br>
			<table>
				<tr><td>Comments:</td><td><textarea name="comments"></textarea></td></tr>
				<tr><td>Date:</td><td><input type="date" name="date"></td></tr> 
				<tr><td>Rating:</td><td>
				<select name="rateing">
					<option>Rating</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select></td></tr>
				<tr></tr><tr></tr>
					<tr><td></td><td><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset"></td></tr>
			</table>

			</form>


		</div>
	</div>






	<div style="position: absolute; top: 10px">
		<jsp:include page="footer.html"></jsp:include>

	</div>



</body>
</html>