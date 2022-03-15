<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>You are logged in as : <%= (String)session.getAttribute("username") %></h2>
<h1><a href="displayUserDetails.jsp">View All Users</a></h1>
<h1><a href="searchUser.jsp" id="searchUsers">Search Users</a></h1>
<h1><a href="createNewExpense.jsp" id="createNewExpense">Create New Expense</a></h1>
<br/>
<a href="index.jsp">Logout</a>
</body>
</html>