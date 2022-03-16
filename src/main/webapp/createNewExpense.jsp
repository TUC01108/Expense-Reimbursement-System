 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Expense Reimbursement</title>
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
      .btn {
      	align-self: center;
      	width: 75px
      	
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
<h1>Create Expense Reimbursement</h1>
<h2>Select Type:</h2>
<table class="table table-dark">
<thead>
<tr>
<th scope="col">#</th>
<th scope="col">Type</th>
<th scope="col">Usage</th>
</tr>
</thead>
<tbody>
<tr>
<th scope="row">
<div class="form-check">
   <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="a" checked>
   <label class="form-check-label" for="exampleRadios1">
   
   </label>
</div>
</th>
<td>Travel Expense</td><td>Expense related to client interview travel.</td>
</tr>
<tr>
<th scope="row">
<div class="form-check">
   <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="b">
   <label class="form-check-label" for="exampleRadios2">
   
   </label>
</div>
</th>
<td>Certification</td><td>User for successfully obtaining approved certifications (2 maximum per calendar year).</td>
</tr>
<tr>
<th scope="row">
<div class="form-check">
   <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="c">
   <label class="form-check-label" for="exampleRadios3">
   
   </label>
</div>
</th>
<td>Relocation</td><td>Used when traveled more than 50 miles to a training location.</td>
</tr>
<tr>
<td></td>
<td><button type="button" class="btn btn-secondary">Cancel</a></button></td>

<td><button type="button" class="btn btn-warning"><a href="createNewExpenseDetails.jsp">Create</a></button></td>

</tr>
</tbody>
</table>
 </main>
<br/>
<button type="button" class="btn btn-light"><a href="welcome.jsp">Back</a></button>
<br/>
<button type="button" class="btn btn-light"><a href="index.jsp">Logout</a></button>
<footer class="mt-auto text-white-50">
    Created by Thomas Winter
  </footer>
</div>
</body>
</html>