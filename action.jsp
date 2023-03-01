<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Action Page</title>
<style>
body {background-color: #abb489;}
</style>
</head>
</head>
<body>
	<p style="text-align:center"> Welcome  <%=request.getAttribute("uname") %></p>
	<form method="post" action="addUser.jsp">
	<input type="submit" value="AddUsers" name="AddUsers"/>
	</form><br>
	<form method="post" action="addBook.jsp">
	<input type="submit" value="AddBooks" name="Addbooks"/>
	</form><br>
	<form method="post" action="logout">		<input type="submit" value="Logout" name="Logout"/></form><br>
</body>
</html>