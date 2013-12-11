<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Groups</title>
</head>
<body>
<h3>Groups</h3>
<c:set var="highlight" value="Groups" scope="request"/>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/addGroup.html"/>">Add new group</a>
<table>
	<thead>
		<tr>
			<td>Group Number</td>
			<td>Department</td>
			<td>Curator</td>
		</tr>
	</thead>
	<c:forEach items="${groups}" var="group">
		<tr>
			<td>${group.groupNumber}</td>
			<td><a href="<c:url value="/groups.html?departmentId=${group.departmentId}"/>">${group.departmentId}</a></td>
			<td><c:out value="${group.curator}" escapeXml="true"/></td>
			<td><a href="<c:url value="/editGroup.html?groupNumber=${group.groupNumber}"/>">Edit</a></td>
			<td><a href="<c:url value="/deleteGroup.html?groupNumber=${group.groupNumber}"/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>