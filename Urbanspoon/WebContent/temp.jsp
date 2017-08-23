<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style type="text/css">
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
					<input type="hidden" name="action" value="user_registration">
					<label>FirstName</label> <input  type="text" name="FirstName">
					<label>LastName</label> <input type="text" name="LastName">
					<label>Email Id</label> <input type="email" name="EmailId">
					<label>Password</label> <input type="password" name="password">
					<label>Confirm Password</label> <input type="password" name="repassword"> 
					<label>PhoneNumber</label> <input type="number" name="phonenumber"> 
					<input type="submit" value="REGISTER">
				</fieldset>

			</form>
			<form action="HomeController" id="restaurant" method="post" enctype="multipart/form-data" onsubmit="return formvalidation()">
				<h4>Restaurant</h4>
				<p>${error}</p>
				<fieldset id="fields">
				   <input type="hidden" name="action" value="restaurant_registration">
				   <table>
				   <tr>
				   <td>Restaurant Name:</td>
				   <td><input type="text" name="name"></td>
				   </tr>
				   <tr>
				   <td>Email Id</td>
				   <td><input type="email" name="EmailId"></td>
				   </tr>
				   <tr>
				   <td>Password</td>
				   <td></td>
				   </tr>
				   <tr>
				   <td></td>
				   <td></td>
				   </tr>
				   <tr>
				   <td></td>
				   <td></td>
				   </tr>
				   
				   </table>
					<label>Restaurant Name</label> <input type="text" name="name"> <label>Email Id</label>
					<input type="email" name="EmailId"> <label>Password</label> <input
						type="password" name="password">
						<label>Confirm Password</label><input type="password" name="repassword"> 
						<label>Location:</label>
						<input type="text" name="location"> <label>City:</label><input
						type="text" name="city"> <label>Postal Code:</label><input
						type="text" name="postalCode"> <label>State:</label><input
						type="text" name="state"> <label>Branch Phone Number:</label><input
						type="number" name="phonenumber"> 
						<label>Country:</label><input
						type="text" name="country"><label>Image:</label><input
						type="file" name="imagePath">
						<label>RegistrationId</label> <input
						type="text" name="registrationId">
						 <input type="submit"
						value="submit">
				</fieldset>

			</form>

			<button onclick="userform()">User</button>
			<button onclick="restaurantform()">Restaurant</button>
		</div>

	</div>

	<jsp:include page="footer.html"></jsp:include>
</body>
</html>