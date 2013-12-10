<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		<c:if test="${not empty student.id}">Delete Student</c:if>
	</title>
</head>
<body>
	<form:form method="POST" commandName="student">
		<form:label path="id"/>
		<table>
			<tr>
				<td>First Name</td>
				<td><form:label path="firstName">${student.firstName}</form:label></td>
			</tr>
			<tr>
				<td>Second Name</td>
				<td><form:label path="lastName">${student.lastName}</form:label></td>
			</tr>
			<tr>
				<td>Average Mark</td>
				<td><form:label path="averageMark">${student.averageMark}</form:label></td>
			</tr>
			<tr>
				<td>Group Number</td>
				<td><form:label path="groupNumber">${student.groupNumber}</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>