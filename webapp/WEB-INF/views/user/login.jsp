<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center" style="color:red;">${requestScope.message}</h1>

<form method="post"> <%-- if no action is given, form is submitted on the same url, taking to user/login with method = post --%>
	<table style="background-color: cyan; margin: auto;">
		<tr>
			<td>Enter User Email</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><input type="password" name="password" /></td>
		</tr>

		<tr>
			<td><input type="submit" value="Login" /></td>
		</tr>
	</table>
</form>
</body>
</html>