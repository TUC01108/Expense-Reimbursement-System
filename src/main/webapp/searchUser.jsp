<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>
<body>
<h1 align="center">User search page</h1>
<form action="searchUserResults.jsp" align="center">
Enter Username to search : <input type="text" name="searchname">
<input type="submit" value="Search">
</form>
<a href="welcome.jsp">Back</a>
<br/>
<a href="index.jsp">Logout</a>
</body>
</html>