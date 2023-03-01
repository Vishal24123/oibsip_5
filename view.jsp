<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<title>View Book Details</title>
</head>
<body>
	<div class="row">
   <div class="col-sm-3" style="background-color:lavender;">Book Id</div>
   <div class="col-sm-3" style="background-color:lavenderblush;">Book Name</div>
   <div class="col-sm-3" style="background-color:lavender;">Author Name</div>
   <div class="col-sm-3" style="background-color:lavenderblush;">Category</div>
</div> <br>

<div class="row">
		<div class="col-sm-3" style="background-color:lavender;"><%=request.getAttribute("bid")%></div>
		<div class="col-sm-3" style="background-color:lavenderblush;"><%=request.getAttribute("bname")%></div>
		<div class="col-sm-3" style="background-color:lavender;"><%=request.getAttribute("aname")%></div>
		<div class="col-sm-3" style="background-color:lavenderblush;"><%=request.getAttribute("bcategory")%></div>
		</div><br>
</body>
</html>