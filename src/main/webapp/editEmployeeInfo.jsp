<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Info</title>
<!-- Bootstrap core CSS -->
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

.form-signin input[type="password"] {
	margin-bottom: 20px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.form-signin input[type="button"] {
	margin-top: 10px;
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
	function validateEditInfoForm() {
		var o_username = document.forms[0].elements[0].value;
		var password = document.forms[0].elements[1].value;
		var username = document.forms[0].elements[2].value;
		var first_name = document.forms[0].elements[3].value;
		var last_name = document.forms[0].elements[4].value;
		

		if (o_username.length == 0) {
			alert("Please type an original username");
			return false;
		} else if (password.length == 0) {
			alert("Please type a password");
			return false;
		} else if (username.length == 0) {
			alert("Please enter a new username");
			return false;
		} else if (first_name.length == 0) {
			alert("Please enter a new first name");
			return false;
		} else if (last_name.length == 0) {
			alert("Please enter a new last name");
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
			<form class="form-style" action="EditInfoController"
				onsubmit="return validateEditInfoForm()" name="editinfoform"
				method="post">
			<h2 class="text-white">Welcome to the Edit Employee Information page!</h2>
			<div class="form-floating">
					<input type="text" class="form-control" name="o_username"
						id="floatingInput" placeholder="Original Username"> <label
						for="floatingInput">Original Username</label>
				</div>
			<div class="form-floating">
					<input type="password" class="form-control" name="password"
						id="floatingInput" placeholder="Password"> <label
						for="floatingInput">Password</label>
				</div>
			<div class="form-floating">
					<input type="text" class="form-control" name="username"
						id="floatingInput" placeholder="Username"> <label
						for="floatingInput">Username</label>
				</div>
			<div class="form-floating">
					<input type="text" class="form-control" name="first_name"
						id="floatingInput" placeholder="First Name"> <label
						for="floatingInput">First Name</label>
				</div>
				<div class="form-floating">
					<input type="text" class="form-control" name="last_name"
						id="floatingInput" placeholder="Last Name"> <label
						for="floatingInput">Last Name</label>
				</div>

				<button class="w-40 btn btn-md btn-primary" type="submit"
					value="editInfo">Submit</button>
				<button class="w-40 btn btn-md btn-danger" type="reset"
					value="Clear">Reset</button>
					
			</form>
			<br/>

			<a href="employeeInfo.jsp">Back to Information</a> <br /> <a
				href="welcome.jsp">Homepage</a> <br /> <a href="index.jsp">Logout</a>
		</main>

		<footer class="mt-auto text-white-50"> Created by Thomas
			Winter </footer>
	</div>
</body>
</html>