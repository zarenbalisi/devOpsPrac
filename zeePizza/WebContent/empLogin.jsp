<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	form { 
	
	display: inherit;
	}
</style>
</head>
<body>
<form method = "post" action = "employeeLoginServlet">
<table>
<tr>
	<th>Email</th> <td><input type = "text" name = "empEmail" required/></td>
	<th>Password</th><td><input type = "password" name = "empPassword" required/><td>
	<th></th><td><input type = "submit" value = "login"/></td>
</tr>
</table>
</form>
</body>
</html>