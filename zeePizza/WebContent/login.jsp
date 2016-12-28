<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	th{
	color: white;
	}
	form { 
	
	display: inherit;
	}
</style>
</head>
<body>
<form method = "post" action = "loginServlet">
<table>
<tr>
	<th>Email</th> <td><input type = "text" name = "Email" required/></td>
	<th>Password</th><td><input type = "password" name = "Password" required/><td>
	<th></th><td><input type = "submit" value = "login"/></td>
</tr>
</table>
</form>
</body>
</html>