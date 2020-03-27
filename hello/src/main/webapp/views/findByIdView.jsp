<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Report</h1>
	<table width="50%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Marks</th>
			</tr>
		</thead>

		<tbody align="center">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.marks}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>