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
<h1 style="color: green;">${sessionScope.message}</h1>
<h1 style="color: red;">Vendor Details : ${sessionScope.user_details}</h1>
<h1><a href="<spring:url value='/user/logout'/>">LogOut</a></h1>
</body>
</html>