<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>You are logged in as : <%= (String)session.getAttribute("username") %></h2>
<h1><a href="displayUserDetails.jsp">View All Users</a></h1>
<h1><a href="searchUser.jsp" id="searchUsers">Search Users</a></h1>
</body>
</html>