<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.example.SpringBoot.Model.IPODetail,com.example.SpringBoot.Model.Company,com.example.SpringBoot.Model.StockExchange"%>
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
<title>IPO Registration</title>
</head>
<body>
<ul>
  <li><a href="#home">Import Data</a></li>
  <li><a href="/create">Manage Company</a></li>
  <li><a href="/insertStock">Manage Exchange</a></li>
   <li><a href="/createIpo">Manage IPO Details</a></li>
  <li style="float:right"><a href="/logoutIPO">Logout</a></li>
</ul>
	<br>
	<br>
<%
		String ipo = request.getParameter("ipoid");
		int ipoCode = Integer.parseInt(ipo);
	%>
	<div class="container register-form">
		<form:form method="GET" action="/updatedIPODisplay" modelAttribute="ipo">
			<div class="note">
				<p>IPO Updation Form</p>
			</div>

			<div class="form-content">
				<div class="row">
				<div class="col-md-6">
						<div class="form-group">
							
								<%
									List companyDetails= (List) request.getAttribute("companyList");
										Iterator itr = companyDetails.iterator();
								%>

								<b><label class="control-label col-xs-4">Company Code</label></b>


								<div class="col-xs-8">
									<form:select class="form-control" path="companyCode">
										<option value="" disabled selected>Choose Company Id</option>
										<%
											while (itr.hasNext()) {
														Company company = (Company) itr.next();
														Integer companyId = company.getCompanyCode();
										%>
										<option value="<%=companyId%> ">
											<%=companyId%></option>

										<%
											}
										%>

									</form:select>
									<form:errors path="companyCode" cssClass="errorColor" />
								</div>
						</div>
						<div class="form-group">
							
								<%
									List stockDetails= (List) request.getAttribute("stockList");
										Iterator itr1 = stockDetails.iterator();
								%>

								<b><label class="control-label col-xs-4">Stock Code</label></b>


								<div class="col-xs-8">
									<form:select class="form-control" path="stockExchange">
										<option value="" disabled selected>Choose Stock Id</option>
										<%
											while (itr1.hasNext()) {
														StockExchange stockExchange = (StockExchange) itr1.next();
														int stockId = stockExchange.getStockExchangeId();
										%>
										<option value="<%=stockId%> ">
											<%=stockId%></option>

										<%
											}
										%>

									</form:select>
									<form:errors path="stockExchange" cssClass="errorColor" />
								</div>
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter the Price per share</b>
							<form:input type="text" class="form-control" path="priceperShare"
								id="priceperShare" placeholder="price per Share *" />
							<form:errors path="priceperShare" class="errorColor" />
						</div>
						<div class="form-group">
							<b>Enter Remarks</b>
							<form:input type="text" class="form-control" path="remarks"
								id="remarks" placeholder="remarks *" />
							<form:errors path="remarks" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter Total shares</b>
							<form:input type="text" class="form-control" path="totalShares"
								id="totalShares" placeholder="totalShares *" />
							<form:errors path="totalShares" class="errorColor" />
						</div>
						</div>
						<div class="col-md-6">
						<div class="form-group">
							<b>Open Date and time</b>
							<form:input type="date" class="form-control" path="openDateTime"
								id="openDateTime" placeholder="Open Date Time *" />
							<form:errors path="openDateTime" class="errorColor" />
						</div>
						</div>
				</div>
				<form:input type="hidden" path="id"
					value="<%=ipoCode%>" />
				<button type="submit" class="btnSubmit">Submit</button>
			</div>
		</form:form>
	</div>



</body>
</html>