<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body>
<h3>Projects</h3>
<c:set var="highlight" value="Projects" scope="request"/>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/addProject"/>">Add new student</a>
<table>
	<thead>
		<tr>
			<td>ID</td>
			<td>Project name</td>
		</tr>
	</thead>
	<c:forEach items="${projects}" var="project">
		<tr>
			<td>${project.projectId}</td>
			<td><c:out value="${project.projectName}" escapeXml="true"/></td>
			<td><a href="<c:url value="/editProject?id=${project.projectId}"/>">Edit</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>