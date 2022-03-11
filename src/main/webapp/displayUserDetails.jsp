<%@page import="java.util.Iterator"%>
<%@page import="com.training.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.LoginDAOImpl"%>
<%@page import="com.training.ers.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<% String username = (String)session.getAttribute("username"); %>
		<h4>You are logged in as : 
		<%= username %> 
		and the message is : 
		<%= session.getAttribute("message") %></h4>
	<%
	LoginDAO loginDAO = new LoginDAOImpl();
	List<User> users = loginDAO.getUsers();
	Iterator<User> iterator = users.iterator();
	%>
	<h4 align="center">List of all the users</h4>
	<table class="table table-dark">
	<thead>
	<tr>
		<th>User Id</th>
		<th>Username</th>
		<th>Password</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Login_id</th>
		</tr>
	</thead>
		<%
		while (iterator.hasNext()) {
			User user = iterator.next();
			
			%>
			<tr>
			<td><%= user.getUserId() %></td>
			<td><%= user.getUsername() %></td>
			<td><%= user.getPassword() %></td>
			<td><%= user.getFirstname() %></td>
			<td><%= user.getLastname() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getLogin_id() %></td>
			</tr>
		<%}
		%>
</table>
<a href="welcome.jsp">Back</a>
<br/>
<a href="index.jsp">Logout</a>
</body>
</html>