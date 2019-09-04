<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.example.SpringBoot.Model.Sector"%>
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

.errorColor {
	color: red;
}
</style>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Updation</title>
</head>
<body>
	<br>
	<br>
	<%
		String compCode = request.getParameter("cid");
		int companyCode = Integer.parseInt(compCode);
	%>
	<div class="container register-form">
		<form:form method="GET" action="/updatedDisplay"
			modelAttribute="updateCompany">
			<div class="note">
				<p>Company Updation Form</p>
			</div>

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter the Company Name</b>
							<form:input type="text" class="form-control" path="companyName"
								id="companyName" placeholder="Company name*" />
							<form:errors path="companyName" class="errorColor" />
							<b>Enter the CEO </b>
							<form:input type="text" class="form-control" path="ceo" id="ceo"
								placeholder="CEO*" />
							<form:errors path="ceo" class="errorColor" />
							
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
						<b>Enter the turnover</b>
							<form:input type="text" class="form-control" path="turnover"
								id="turnover" placeholder="Turnover*" />
							<form:errors path="turnover" class="errorColor" />
							<b>Enter Board of directors</b>
							<form:input type="text" class="form-control"
								path="boardOfDirectors" id="boardOfDirectors"
								placeholder="Board Of Directors*" />
							<form:errors path="boardOfDirectors" class="errorColor" />
							
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
						<b>Brief Write Up</b>
							<form:input type="text" class="form-control" path="briefWriteup"
								id="briefWriteup" placeholder="Brief Write up*" />
							<form:errors path="briefWriteup" class="errorColor" />

						</div>
						<div class="form-group">
							
								<%
									List sectorDetails = (List) request.getAttribute("sectorList");
										Iterator itr = sectorDetails.iterator();
								%>

								<b><label class="control-label col-xs-4">Sector Id</label></b>


								<div class="col-xs-8">
									<form:select class="form-control" path="sectorId" >
										<option value="" disabled selected>Choose Sector Id</option>
										<%
											while (itr.hasNext()) {
														Sector sector = (Sector) itr.next();
														Integer sectorId = sector.getSectorId();
										%>
										<option value="<%=sectorId%> ">
											<%=sectorId%></option>

										<%
											}
										%>

									</form:select>
									<form:errors path="sectorId" cssClass="errorColor" />
								</div>
							</div>
					</div>
				</div>
				<form:input type="hidden" path="companyCode"
					value="<%=companyCode%>" />
				<button type="submit" class="btnSubmit">Submit</button>
			</div>
			</form:form>
	</div>
</body>
</html>