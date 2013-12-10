<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		<c:if test="${empty group.groupNumber}">Add new Group</c:if>
		<c:if test="${not empty group.groupNumber}">Edit Group</c:if>
	</title>
</head>
<body>
	
	<form:form method="POST" commandName="group">
		<table>
			<tr>
				<td>Group Number</td>
				<td><form:input path="groupNumber"/></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><form:input path="departmentId"/></td>
			</tr>
			<tr>
				<td>Curator</td>
				<td><form:input path="curator"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>