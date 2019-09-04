<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.SpringBoot.Model.IPODetail"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display IPOs</title>
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
  <li style="float:right"><a href="/logoutIPO">Logout</a></li>
</ul>	
<br>
<br>
	<%
		List ipoList = (List) request.getAttribute("ipoList");
		System.out.println(ipoList);
	%>

<div style="overflow-x:auto;">
	<table>
		<tr id="back">
			<td><b>Code</b></td>
			<td><b>Stock Exchange</b></td>
			<td><b>Total Shares</b></td>
			<td><b>Remarks</b></td>
			<td><b>Price per Share</b></td>
			<td><b>Open date time</b></td>	
			<td><b>Update</b></td>		
		</tr>

		<%
			for (int i = 0; i < ipoList.size(); i++) {
				IPODetail e = (IPODetail) ipoList.get(i);
		%>
		<tr>
			<td><%=e.getCompanyCode()%></td>
			<td><%=e.getStockExchange()%></td>
			<td><%=e.getTotalShares()%></td>
			<td><%=e.getRemarks()%></td>
			<td><%=e.getPriceperShare()%></td>
			<td><%=e.getOpenDateTime()%></td>
			<td><a href="updateIPO?ipoid=<%=e.getId()%>">Update</a></td>
		</tr>
		<% }%>

	</table>
</div>

</body>
</html>