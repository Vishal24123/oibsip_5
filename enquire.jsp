<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Book</title>
<style>
body {background-color: #abb44e;}
</style>
<script>
	function myfunction(objButton) {
		
		document.getElementById("buttonvalue").value=objButton.name;
		}
</script>
</head>
<body>
<p style="text-align:center"> Welcome  <%=request.getAttribute("uname") %> </p>
<input type="submit" value="Logout" name="Logout"/>
	
<form method="post" action="namesearch">
<input type=hidden name ="buttonvalue" id="buttonvalue">
<input type="text" id="search" name="search" placeholder="Enter the book name or book category"/>
<input type="submit" name="bookname" value="Click to check by book name" onclick="myfunction(this)"/>
<input type="submit" name="category" value="Click to check by book category" onclick="myfunction(this)"/></form>
<form method="post" action="logout"></form><br>
</body>
</html>
