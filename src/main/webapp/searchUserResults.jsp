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
<title>Insert title here</title>
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
	<table border="2" cellspacing="10" cellpadding="10">
		<th>User Id</th>
		<th>Username</th>
		<th>Password</th>
		<th>Gender</th>
		<th>Notification</th>
		<th>Qualification</th>

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
        <td>    <%=  obj.getGender()        %>    </td>
        <td>    <%=  obj.getNotification()     %>    </td>
        <td>    <%=  obj.getQualification()    %>    </td>
        </tr>
		<%}%>
</table>
<a href="searchUser.jsp">Search again</a>
<a href="index.jsp">Logout</a>
</body>
</html>