<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.SpringBoot.Model.Company"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Companies</title>
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}
#back tr{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color:black;
  color: white;
}
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
tr:nth-child(even){background-color: #f2f2f2}
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
</head>
<body>
<ul>
  <li><a href="#home">Import Data</a></li>
  <li><a href="/create">Manage Company</a></li>
  <li><a href="/insertStock">Manage Exchange</a></li>
   <li><a href="createIpo">Manage IPO Details</a></li>
  <li style="float:right"><a href="/logout">Logout</a></li>
</ul>	
<br>
<br>
	<%
		List companyList = (List) request.getAttribute("companyList");
		System.out.println(companyList);
	%>

<div style="overflow-x:auto;">
	<table>
		<tr id="back">
			<td><b>Code</b></td>
			<td><b>Company name</b></td>
			<td><b>Turnover</b></td>
			<td><b>CEO</b></td>
			<td><b>Board of Directors</b></td>
			<td><b>Sector ID</b></td>
			<td><b>Brief Writeup</b></td>
			<td><b>Update</b></td>
			

		</tr>

		<%
			for (int i = 0; i < companyList.size(); i++) {
				Company e = (Company) companyList.get(i);
		%>
		<tr>
			<td><%=e.getCompanyCode()%></td>
			<td><%=e.getCompanyName()%></td>
			<td><%=e.getTurnover()%></td>
			<td><%=e.getCeo()%></td>
			<td><%=e.getBoardOfDirectors()%></td>
			<td><%=e.getSectorId()%></td>
			<td><%=e.getBriefWriteup()%></td>
			<td><a href="updateCompany?cid=<%=e.getCompanyCode()%>">Update</a></td>
			


		</tr>
		<% }%>

	</table>
</div>

</body>
</html>