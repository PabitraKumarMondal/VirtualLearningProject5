<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Find By Id</h1>
<form action="findByIdView" method="post">

		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" /></td>
			</tr>

			<tr>
				<td><input type="reset" name="reset" value="Clear" /></td>
				<td><input type="submit" name="save" value="Find" /></td>
			</tr>
		</table>
	</form>
</body>
</html>