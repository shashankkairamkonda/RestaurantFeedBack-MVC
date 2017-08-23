<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style type="text/css">

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<div id="container">
		<div align="center" id="register">
		<p>${error}</p>
			<form action="HomeController" id="restaurant" method="post"  onsubmit="return formvalidation()">
				<fieldset id="fields">
				
				<input type="hidden" name="action" value="login" > 
					<table>
					<tr><td>Name</td><td><input type="text" name="userName" value="${userName}"></td></tr> 
					<tr><td>Password</td><td><input type="password" name="password"> </td></tr>
					</table>
					<div>
						User <input type="radio" name="loginAs" value="userLogin" style="width: 5%;"> 
						Restaurant Owner <input type="radio" name="loginAs" value="restaurantLogin" style="width: 5%;">
					</div>
					<input type="submit" value="submit"> <br><br>
					<a href="forgotpassword.jsp">Forgot your password?</a>

				</fieldset>

			</form>
		</div>

	</div>

		<div style="position: absolute; top: 10px">
			<jsp:include page="footer.html"></jsp:include>

		</div>

</body>
</html>