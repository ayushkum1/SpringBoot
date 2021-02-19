<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Last Action Status : ${requestScope.message}</h1>

	<table style="background-color: cyan; margin: auto;">
		<caption>Vendor List</caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Registration Amount</th>
				<th>Registration Date</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="v" items="${requestScope.vendor_list}">
		<tr>
			<td>${v.name}</td>
			<td>${v.email}</td>
			<td>${v.regAmount}</td>
			<td>${v.regDate}</td>
			<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
			<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td>
		</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<h3 style="align-content: center;">
		<a href="<spring:url value='/admin/register'/>">Add New Vendor</a>
	</h3>
	
	<h3 style="align-content: center;">
		<a href="<spring:url value='/admin/logout'/>">Log Me Out</a>
	</h3>
</body>
</html>