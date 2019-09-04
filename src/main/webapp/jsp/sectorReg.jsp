<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type=text/css>
.note {
	text-align: center;
	height: 80px;
	background: -webkit-linear-gradient(left, #0072ff, #8811c5);
	color: #fff;
	font-weight: bold;
	line-height: 80px;
}

.form-content {
	padding: 5%;
	border: 1px solid #ced4da;
	margin-bottom: 2%;
}

.form-control {
	border-radius: 1.5rem;
}

.btnSubmit {
	border: none;
	border-radius: 1.5rem;
	padding: 1%;
	width: 20%;
	cursor: pointer;
	background: #0062cc;
	color: #fff;
}
  
.errorColor
{
color:red;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}


</style>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sector Registration</title>
</head>
<body>

<ul>
  <li><a href="#home">Import Data</a></li>
  <li><a href="/create">Manage Company</a></li>
  <li><a href="/insertStock">Manage Exchange</a></li>
   <li><a href="/createIpo">Manage IPO Details</a></li>
  <li style="float:right"><a href="/logoutSector">Logout</a></li>
</ul>
	<br>
	<br>

	<div class="container register-form">
		<form:form method="GET" action="/registerSector" modelAttribute="sector">
			<div class="note">
				<p>Sector Registration Form</p>
			</div>

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter the Sector ID</b>
							<form:input type="text" class="form-control" path="sectorId"
								id="sectorId" placeholder="Sector Id *" />
								<form:errors path="sectorId" class="errorColor"/>
						</div>
						<div class="form-group">
							<b>Enter Sector Name</b>
							<form:input type="text" class="form-control" path="sectorName" id="sectorName"
								placeholder="Sector Name *" />
								<form:errors path="sectorName" class="errorColor"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Brief Writeup</b>
							<form:input type="text" class="form-control" path="brief"
								id="brief" placeholder=" Brief Writeup *" />
								<form:errors path="brief" class="errorColor"/>
						</div>

					</div>

				</div>
				</div>
				<button type="submit" class="btnSubmit">Submit</button>
			
	</form:form>
	</div>



</body>
</html>