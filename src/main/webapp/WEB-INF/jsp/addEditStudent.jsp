<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		<c:if test="${empty student.id}">Add new Student</c:if>
		<c:if test="${not empty student.id}">Edit Student</c:if>
	</title>
</head>
<body>
	<form:form method="POST" commandName="student">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Second Name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Average Mark</td>
				<td><form:input path="averageMark"/></td>
			</tr>
			<tr>
				<td>Group Number</td>
				<td><form:input path="groupNumber"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>