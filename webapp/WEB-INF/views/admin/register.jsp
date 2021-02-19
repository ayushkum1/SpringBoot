<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   <%-- import, for the form binding technique, spring supplied for tag library --%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- step 2 of 2 way data binding --%>
<form:form method="post" modelAttribute="vendor_details"> 
	<table style="background-color: cyan; margin: auto;">
		
		<tr>
			<td>Enter User Email</td>
			<td><form:input path="email" /></td>
		</tr>
				
		<tr>
			<td>Enter User Name</td>
			<td><form:input path="name" /></td>
		</tr>
				
		<tr>
			<td>Enter Password</td>
			<td><form:input path="password" /></td>
		</tr>
		
		<tr>
			<td>Enter Registration Amount</td>
			<td><form:input path="regAmount" /></td>
		</tr>
		
				
		<tr>
			<td>Enter Registration Date</td>
			<td><form:input type="date" path="regDate" /></td>
		</tr>	
				
		<tr>
			<td>Choose Payment Mode</td>
			<td><form:radiobuttons path="details.mode" items="${requestScope.payment_modes}" /></td>
		</tr>
				
		<tr>
			<td>Choose Payment Amount</td>
			<td><form:input type="number" path="details.amount"/></td>
		</tr>
		
		<tr>
			<td>Choose Payment Date</td>
			<td><form:input type="date" path="details.paymentDate"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Register New Vendor" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>