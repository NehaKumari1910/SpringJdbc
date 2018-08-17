<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<body>
<h1>SignIn Portal</h1>
<form action="login" method="post" modelAttribute="User">
<label for="username">Email-Id:</label>
<input type="text" name="email"/><br>
<label for="password">Password:</label>
<input type="password" name="password"/><br>
<input type="submit">
<a href="registration">SignUp</a>
<a href="forgot">Forgot password</a>
<%
String errorMsg="";
if(request.getAttribute("error")!=null)
{
	errorMsg=(String)request.getAttribute("error");
}
%>
<p>
<%=errorMsg%>
</p>

</form>
</body>
</html>