<%@page import="com.training.ers.dao.ManagerDAOImpl"%>
<%@page import="com.training.ers.dao.ManagerDAO"%>
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
<title>Approve Reimbursment</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
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
					<a class="nav-link active text-white-50" aria-current="page"
						href="index.jsp">Home</a> <a class="nav-link text-white-50"
						href="#">Help</a> <a class="nav-link text-white-50" href="#">Contact</a>
				</nav>
			</div>
		</header>
		<main class="px-3">
			<%
			int reimbursementId = Integer.parseInt(request.getParameter("reimbursementid"));
			
			ManagerDAO managerDAO = new ManagerDAOImpl();
			Boolean result = managerDAO.rejectApply(reimbursementId);
			
			%>
			<h1>Reimbursement Rejected Successfully</h1>
			
			
</main>
<a href="approveOrDenyReimbursement.jsp">Go Back</a> <br /> 
<a href="welcomeManager.jsp">Home Page</a> <br /> 
<a href="index.jsp">Logout</a>
<footer class="mt-auto text-white-50">
    Created by Thomas Winter
  </footer>
</div>
</body>
</html>