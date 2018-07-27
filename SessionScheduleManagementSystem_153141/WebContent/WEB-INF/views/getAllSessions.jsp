<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>ScheduledSessions</h1>
		<h5>
			<br>
		</h5>
		<br>
		<form  method = "post">
		<table>
			<tr>
				<th>SessionName</th>
				<th>Duration(Days)</th>
				<th>Faculty</th>
				<th>Mode</th>
			</tr>
			<tr>
			<td>${sessions}</td>
			</tr>
			<c:forEach items="${ScheduledSessions}" var="sessions">
				<tr>
					<td>${sessions.name}</td>
					<td>${sessions.duration}</td>
					<td>${sessions.faculty}</td>
					<td>${sessions.mode1}</td>
					<td><a href="getDetails/${sessions.name}">EnrollMe</a></td>
				</tr>
			</c:forEach>
		</table>
		</form>
</body>
</html>