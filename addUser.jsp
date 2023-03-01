<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<style>
body {background-color: #a198ae;}
</style>
</head>
<body>
	<p>Add the users by filling the following details</p>
	<form method="post" action="adduser">
		Name:<input type="text" name="name" id="name"/><br>
		Email:<input type="email" name="email" id="email"/><br>
		Password:<input type="password" name="password" id="password"/><br>
		Do you want to make as an admin:<br>
  <input type="radio" id="admin" name="admin" value="yes">
  <label for="yes">YES</label>
  <input type="radio" id="admin" name="admin" value="no">
  <label for="no">No</label><br>
<input type="submit" name="submit"/>
	</form>
</body>
</html>