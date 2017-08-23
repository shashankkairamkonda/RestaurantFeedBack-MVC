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
				   <td><input type="password" name="password"></td>
				   </tr>
				   <tr>
				   <td>Confirm Password</td>
				   <td><input type="password" name="repassword"></td>
				   </tr>
				   <tr>
				   <td>Location:</td>
				   <td><input type="text" name="location"> </td>
				   </tr>
				   <tr>
				   <td>City:</td>
				   <td> 
				   <select name="city">
				   <option value="hyderabad">Hyderabad</option>
				   <option value="banglore">Banglore</option>
				   <option value="chennai">Chennai</option>
				   </select>
				   
				   </td>
				   </tr>
				   <tr>
				   <td>Postal Code:</td>
				   <td><input type="text" name="postalCode"> </td>
				   </tr>
				   <tr>
				   <td>State:</td>
				   <td><input type="text" name="state"></td>
				   </tr>
				   <tr>
				   <td>Branch Phone Number:</td>
				   <td><input type="number" name="phonenumber" ></td>
				   </tr>
				   <tr>
				   <td>Country:</td>
				   <td><input type="text" name="country"></td>
				   </tr>
				   <tr>
				   <td>Image:</td>
				   <td><input type="file" name="imagePath"></td>
				   </tr>
				   <tr>
				   <td>RegistrationId:</td>
				   <td><input type="text" name="registrationId"></td>
				   </tr>
				   
				   <tr>
				   <td><input type="submit" value="submit"></td>
				   <td><input type="reset" value="reset"> 
				   </tr>
				   </table>
				</fieldset>

			</form>

			<button onclick="userform()">User</button>
			<button onclick="restaurantform()">Restaurant</button>
		</div>

	</div>

	<jsp:include page="footer.html"></jsp:include>
</body>
</html>