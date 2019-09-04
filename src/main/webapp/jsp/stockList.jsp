<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.SpringBoot.Model.StockExchange"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying the stock lists</title>
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

tr:nth-child(even) {
	background-color: #f2f2f2
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
  <li style="float:right"><a href="/logoutStock">Logout</a></li>
</ul>	
<br>
<br>
	<%
		List stockList = (List) request.getAttribute("stockList");
		System.out.println(stockList);
	%>

	<div style="overflow-x: auto;">
		<table>
			<tr>
				<td><b>Stock ID</b></td>
				<td><b>Stock name</b></td>
				<td><b>Brief</b></td>
				<td><b>Contact Address</b></td>
				<td><b>Remarks</b></td>
				<td><b>Update</b></td>
			</tr>

			<%
				for (int i = 0; i < stockList.size(); i++) {
					StockExchange se = (StockExchange) stockList.get(i);
			%>
			<tr>
				<td><%=se.getStockExchangeId()%></td>
				<td><%=se.getStockExchangeName()%></td>
				<td><%=se.getBrief()%></td>
				<td><%=se.getContactAddress()%></td>
				<td><%=se.getRemarks()%></td>
				<td><a href="updateStock?sid=<%=se.getStockExchangeId()%>">Update</a></td>
			</tr>
			<%
				}
			%>

		</table>
	</div>

</body>
</html>