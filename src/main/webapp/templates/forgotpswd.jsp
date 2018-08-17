<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Forgot Password</title>
<script type="text/javascript" src="javaScript/formValidation.js"></script>
</head>

<body>
	<h1>Forgot Password</h1>
	<form action="forgot" name="forgotform"  method="post" >
		<label for="Email-Id">Email Id:</label> 
		<input type="email" name="emailaddress" placeholder="email" /><br>
		<input type="submit" value="submit">
	</form>
	
</body>
</html>