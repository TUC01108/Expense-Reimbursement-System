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
<title>Search For User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<% 
	String username = (String)session.getAttribute("username"); 
	String searchname = request.getParameter("searchname");
%>
		<h2>You are logged in as : 
		<%= username %> 
		and the message is : 
		<%= session.getAttribute("message") %></h2>
	<%
	LoginDAO loginDAO = new LoginDAOImpl();
	List<User> users = loginDAO.getUsersByUsername(searchname);
	Iterator<User> iterator = users.iterator();
	%>
	<h1>List of all the users where username is <%= searchname %></h1>
	<table class="table table-dark">
	<thead>
		<th>User Id</th>
		<th>Username</th>
		<th>Password</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Login_id</th>
	</thead>
		<%
		//while (iterator.hasNext()) {
			//User user = iterator.next();
			for(User obj : users){
			%>
			<%-- <tr>
			<td><%= user.getUserId() %></td>
			<td><%= user.getUsername() %></td>
			<td><%= user.getPassword() %></td>
			<td><%= user.getGender() %></td>
			<td><%= user.getNotification() %></td>
			<td><%= user.getQualification() %></td>
			</tr> --%>
			<tr>
        <td>    <%=  obj.getUserId()        %>    </td>
        <td>    <%=  obj.getUsername()        %>    </td> 
        <td>    <%=  obj.getPassword()         %>    </td>
        <td>    <%=  obj.getFirstname()        %>    </td>
        <td>    <%=  obj.getLastname()     %>    </td>
        <td>    <%=  obj.getEmail()    %>    </td>
        <td>    <%=  obj.getLogin_id()    %>    </td>
        </tr>
		<%}%>
</table>
<a href="searchUser.jsp">Search again</a>
<br/>
<a href="welcome.jsp">Home Page</a>
<br/>
<a href="index.jsp">Logout</a>
</body>
</html>