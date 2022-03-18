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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      .px-3 {
  
      	padding-top: 175px;
      }
      
      footer {
      padding-top: 90%;
      padding-bottom: 5%;
      }
    </style>


</head>
<body class="d-flex h-100 text-center text-white bg-dark">
    
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="mb-auto">
    <div>
      <h3 class="float-md-start mb-0">ERS</h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
        <a class="nav-link active text-white-50" aria-current="page" href="index.jsp">Home</a>
        <a class="nav-link text-white-50" href="#">Help</a>
        <a class="nav-link text-white-50" href="#">Contact</a>
      </nav>
    </div>
  </header>
    <main class="px-3">
	<% String username = (String)session.getAttribute("username"); %>
	
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
  </main>

  <footer class="mt-auto text-white-50">
    Created by Thomas Winter
  </footer>
</div>
</body>
</html>