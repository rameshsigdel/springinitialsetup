<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page.</title>
</head>
<body>
<form action="login" method ="POST">
<label>Username:</label><input type="text" name="userName"  value="${userName}"><br><br>
<label>Password :</label><input type="password" name="password"><br><br>
<input type="checkbox" name="rememberme" value="1 " ${checked}/>Remember Me? <br/>	
<input type="submit" value="submit"><br><br>
 <%
	if(request.getAttribute("err_msg") != null){
		out.println(request.getAttribute("err_msg"));
	}
%>
</form>
</body>
</html>