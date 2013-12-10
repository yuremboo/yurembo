<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		<c:if test="${not empty group.groupNumber}">Delete Group</c:if>
	</title>
</head>
<body>
	<form:form method="POST" commandName="group">
		<table>
			<tr>
				<td>Group Number</td>
				<td><form:label path="groupNumber" >${group.groupNumber}</form:label></td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<form:label path="departmentId"  >${group.departmentId}</form:label>
				</td>
			</tr>
			<tr>
				<td>Curator</td>
				<td><form:label path="curator" >${group.curator}</form:label></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>