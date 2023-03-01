<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<style>
body {background-color: #8baf71;}
</style>
</head>
<body>
	<p>Add the books by filling the following details</p>
	<form method="post" action="addbook">
		Book Name:<input type="text" name="bname" id="bname"/><br>
		Book Category:<input type="text" name="category" id="category"/><br>
		Author Name:<input type="text" name="aname" id="aname"/><br>
		<input type="submit" name="submit"/>
	</form>
</body>
</html>