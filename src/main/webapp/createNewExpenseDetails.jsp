<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Expense Reimbursement</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 0px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

form {
	padding-top: 80px;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: 5px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="email"] {
	margin-bottom: 10px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 5px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.form-signin input[type="button"] {
	margin-bottom: 5px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

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
</style>

<script type="text/javascript">
	function validateCreateNewExpense() {
		var r_type = document.forms[0].elements[0].value;
		var amount = document.forms[0].elements[1].value;
		var comments = document.forms[0].elements[2].value;

		if (r_type.length == 0) {
			alert("Please enter a type of reimbursement");
			return false;
		} else if (amount.length == 0) {
			alert("Please type an amount");
			return false;
		} 
		if (amount < 0) {
			alert("Please enter a positive amount");
			return false;
		}
	}
</script>
</head>
<body class="text-center bg-dark">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0 text-white">ERS</h3>
				<nav class="nav nav-masthead justify-content-center float-md-end">
					<a class="nav-link active text-white-50" aria-current="page"
						href="index.jsp">Home</a> <a class="nav-link text-white-50"
						href="#">Help</a> <a class="nav-link text-white-50" href="#">Contact</a>
				</nav>
			</div>
		</header>
		<main class="form-signin">
			Expense Reimbursement Detail Return back to Expense Reimbursements
			<!--  
Expense Reimbursement ID
Type
Created Date
Status
Comments
Date
Purpose
Amount

Attach Files
Submit
Save
-->
			<form class="form-style" action="ReimbursementController"
				onsubmit="return validateCreateNewExpense()" name="createNewExpense"
				method="post">

				<div class="form-floating">
					<input type="text" class="form-control" name="r_type"
						id="floatingInput" placeholder="Username"> <label
						for="floatingInput">Type</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" name="amount"
						id="floatingInput" placeholder="Password"> <label
						for="floatingInput">Amount</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" name="comments"
						id="floatingInput" placeholder="Confirm Password"> <label
						for="floatingInput">Comments</label>
				</div>
				
				<button class="w-40 btn btn-md btn-danger" type="reset"
					value="Clear">Reset</button>
				<button class="w-40 btn btn-md btn-primary" type="submit"
					value="Submit">Submit</button>
				
			</form>
		</main>
		<br />
		<button type="button" class="btn btn-light">
			<a href="createNewExpense.jsp">Back</a>
		</button>
		<br />
		<button type="button" class="btn btn-light">
			<a href="index.jsp">Logout</a>
		</button>
		<footer class="mt-auto text-white-50"> Created by Thomas
			Winter </footer>
	</div>
</body>
</html>