<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Session Demo</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f4f4f4;
}

.form-container {
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

input {
	width: 100%;
	padding: 8px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background: #28a745;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background: #218838;
}
</style>
</head>
<body>

	<div class="form-container">
		<h2>Login Form</h2>
		<form action="FirstServlet" method="post">
			<label for="name">Name:</label> <input type="text" id="name" name="name" required> 
			<label for="email">Email:</label> <input type="email" id="email" name="email" required>
			<label for="uname">Username:</label> <input type="text" id="uname" name="uname" required> 
			<label for="uname">Password:</label> <input type="text" id="pwd" name="pwd" required> 
			
			<input type="submit" value="Register">
		</form>
	</div>

</body>
</html>
