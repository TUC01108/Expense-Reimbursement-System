<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
<h2>You are logged in as : <%= (String)session.getAttribute("username") %></h2>
<h1><a href="displayUserDetailsManager.jsp">View All Employees</a></h1>
<h1><a href="searchReimbursementByUser.jsp" id="searchUsers">Search Reimbursement Requests By Username</a></h1>
<h1><a href="approveOrDenyReimbursement.jsp" id="createNewExpense">Approve/Deny Pending Reimbursement Requests</a></h1>
<h1><a href="allEmployeePending.jsp" id="viewPending">View All Pending Reimbursements</a></h1>
<h1><a href="allEmployeeResolved.jsp" id="viewResolved">View All Resolved Reimbursements</a></h1>
<h1><a href="employeeInfo.jsp" id="viewInfo">View Manager Information</a></h1>

</main>
<a href="index.jsp">Logout</a>
<footer class="mt-auto text-white-50">
    Created by Thomas Winter
  </footer>
</div>
</body>
</html>