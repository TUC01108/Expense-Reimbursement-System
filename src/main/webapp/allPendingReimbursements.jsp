<%@page import="java.util.Iterator"%>
<%@page import="com.training.model.Reimbursement"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.EmployeeDAOImpl"%>
<%@page import="com.training.ers.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Reimbursements</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
		<% String username = (String)session.getAttribute("username"); %>
			<%
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
				List<Reimbursement> reimbursements = employeeDAO.getPendingReimbursements(username);
				Iterator<Reimbursement> iterator = reimbursements.iterator();
			%>
			<h4 align="center">List of All Pending Reimbursements</h4>
			<table class="table table-dark">
				<thead>
					<tr>
						<th>Reimbursement Id</th>
						<th>Type</th>
						<th>Status</th>
						<th>Amount</th>
						<th>Created Date</th>
						<th>Submitted Date</th>
					</tr>
				</thead>
				<%
				while (iterator.hasNext()) {
					Reimbursement reimbursement = iterator.next();
				%>
				<tr>
					<td><%=reimbursement.getReimbursementId()%></td>
					<td><%=reimbursement.getR_type()%></td>
					<td><%=reimbursement.getStatus()%></td>
					<td><%=reimbursement.getAmount()%></td>
					<td><%=reimbursement.getCreated_date()%></td>
					<td><%=reimbursement.getSubmitted_date()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<a href="welcome.jsp">Back</a> <br /> <a href="index.jsp">Logout</a>
		</main>

		<footer class="mt-auto text-white-50"> Created by Thomas
			Winter </footer>
	</div>
</body>
</html>