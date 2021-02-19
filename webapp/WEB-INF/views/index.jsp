<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- import spring supplied jsp tag lib for url rewriting --%>
    <%@ taglib uri ="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>
	Welcome to Spring MVC
</h2>
<h2>
	<a href="<spring:url value='/user/login'/>"> User Login </a>
</h2>
</body>
</html>