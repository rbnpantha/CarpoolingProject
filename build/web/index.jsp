<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="wrap">
		<div id="regbar">
			<div id="navthing">
				<h2>
					<a href="#" id="loginform">Login</a> | <a href="Register.jsp">Register</a>
				</h2>
				<div class="login">
					<div class="arrow-up"></div>
					<div class="formholder">
						<div class="randompad">
						<form action="UserLogin" method="post">
							<fieldset>
							
								<label name="email">Email</label>
								 <input type="email" placeholder="example@example.com" name="txtEmailLogin" />
								  <label name="password" >Password</label>
								<input type="password" name="txtPasswordLogin" />
								 <input type="submit" value="Login" />

							</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<img alt="Car image" src="image/carr.png" width="100%" height="550px">
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>



</body>
</html>
