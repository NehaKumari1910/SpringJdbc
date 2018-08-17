<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Registration</title>
<script type="text/javascript" src="javaScript/formValidation.js"></script>
</head>

<body>
	<h1>Registration Portal</h1>
	<form action="register" name="Form" onsubmit="return validateForm()" method="post" modelAttribute="user" >
		<label for="Name">Name:</label> <input type="text" name="name"
			placeholder="name" /><br>
		<%
			String errorMsg = "";
			if ((String) request.getAttribute("name_error") != "") {
				errorMsg = (String) request.getAttribute("name_error");
			}
		%>
		<p>
			<%
				if (errorMsg != null) {
					out.println(errorMsg);
				}
			%>
		</p>
		<label for="gender">Gender:</label> <select name="gender">
			<option name="male" value="male">Male</option>
			<option name="female" value="female">Female</option>
		</select><br> <label for="Age">Age:</label> <input type="text" name="age"
			placeholder="age" /><br> <label for="Name">UserName:</label> <input
			type="text" name="username" placeholder="username" /><br> <label
			for="Email-Id">Email Id:</label> <input type="email"
			name="email" placeholder="email" /><br>
		<%
		String errorMsg1="";
			if ((String) request.getAttribute("email_error") != "") {
				errorMsg1 = (String) request.getAttribute("email_error");
			}
		%>
		<p>
			<%
				if (errorMsg1 != null) {
					out.println(errorMsg1);
				}
			%>
		</p>
		<label for="password">Password:</label> 
		<input type="password" name="password" placeholder="password" /><br>
		<%
		String errorMsg2="";
			if (request.getAttribute("password_error") != null) {
				errorMsg2 = (String) request.getAttribute("password_error");
			}
		%>
		<p>
			<%
				if (errorMsg2 != null) {
					out.println(errorMsg2);
				}
			%>
		</p>
		<label for="phone">Phone:</label>
		 <input type="text" name="phone" placeholder="phone" /><br>
		<%
		String errorMsg3="";
			if ((String) request.getAttribute("phone_error") != "") {
				errorMsg3 = (String) request.getAttribute("phone_error");
			}
		%>
		<p>
			<%
				if (errorMsg3 != null) {
					out.println(errorMsg3);
				}
			%>
		</p>
		<button><a href="register"></a>signup</button>
		<button type="submit" formaction="signIn.jsp">login</button>

	</form>
	
</body>
</html>