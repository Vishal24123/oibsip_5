<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See Added Book</title>
<style>
body {background-color: #e0dcdb;}
</style>
</head>
<body>
	<h2> Book Succesfully Added</h2>
	<table cellspacing="2" align="center" cellpadding="8" border="2" style="width:80%">
	<tr style="height:100px">
	<td align="right">Book Name :</td>
	<td><%=request.getAttribute("bname") %></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Category :</td>
	<td><%=request.getAttribute("category") %></td>
	</tr>
	<tr style="height:100px">
	<td align="right"> Author Name :</td>
	<td><%=request.getAttribute("aname") %></td>
	</tr>
	
  </table>
 <p style="text-align:center"><a href="action.jsp">Back</a> </p><br>
</body>
</html>