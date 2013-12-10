<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
<h3>Students</h3>
<c:set var="highlight" value="Students" scope="request"/>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/addStudent.html"/>">Add new student</a>
<table>
	<thead>
		<tr>
			<td>ID</td>
			<td>First name</td>
			<td>Second Name</td>
			<td>Average mark</td>
			<td>Group number</td>
		</tr>
	</thead>
	<c:forEach items="${students}" var="student">
		<tr>
			<td>${student.id}</td>
			<td><c:out value="${student.firstName}" escapeXml="true"/></td>
			<td><c:out value="${student.lastName}" escapeXml="true"/></td>
			<td>${student.averageMark}</td>
			<td>${student.groupNumber}</td>
			<td><a href="<c:url value="/editStudent.html?id=${student.id}"/>">Edit</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>