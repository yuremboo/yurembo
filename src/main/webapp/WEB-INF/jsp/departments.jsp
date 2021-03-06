<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Departments</title>
</head>
<body>
<h3>Departments</h3>
<c:set var="highlight" value="Departments" scope="request"/>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/addDepartment"/>">Add new department</a>
<table>
	<thead>
		<tr>
			<td>ID</td>
			<td>Department</td>
		</tr>
	</thead>
	<c:forEach items="${departments}" var="department">
		<tr>
			<td>${department.departmentId}</td>
			<td><c:out value="${department.departmentName}" escapeXml="true"/></td>
			<td><a href="<c:url value="/editDepartment?id=${department.departmentId}"/>">Edit</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>