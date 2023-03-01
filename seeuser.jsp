<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See Added User</title>
<style>
body {background-color: #e0dcdb;}
</style>
</head>
<body>
	<h2> User Succesfully Added</h2>
	<table cellspacing="2" align="center" cellpadding="8" border="2" style="width:80%">
	<tr style="height:100px">
	<td align="right"> Name :</td>
	<td><%=request.getAttribute("name") %></td>
	</tr>
	
	<tr style="height:100px">
	<td align="right"> Email ID  :</td>
	<td><%=request.getAttribute("email") %></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Password :</td>
	<td><%=request.getAttribute("password") %></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Is He An Admin :</td>
	<td><%=request.getAttribute("admin") %></td>
	</tr>
  </table>
  <p style="text-align:center"><a href="action.jsp">Back</a> </p><br>
</body>
</html>