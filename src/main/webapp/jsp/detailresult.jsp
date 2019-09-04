<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.example.SpringBoot.Model.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<%
List<StockPrice> sp = (List<StockPrice>) request.getAttribute("res_list");
//out.println("IN jsp");
//out.println(sp);
List<Double> ls1 = new ArrayList<Double>();
List<Integer> ls2 = new ArrayList<Integer>();
for(int i=0;i<sp.size();i++)
{
      //out.print(list1.get(i).getExamid());
      //List<Assessment> ls = ExamDao.getExamRecords(list1.get(i).getExamid());
      StockPrice s = new StockPrice();
      s = sp.get(i);
      ls1.add(s.getCurrentPrice());
      ls2.add(s.getCompanyCode());
}

Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
for(int i=0;i<ls1.size();i++)
{
      map = new HashMap<Object,Object>();
      
      map.put("y", ls1.get(i));
      map.put("label", ls2.get(i));
      list.add(map);
}
String dataPoints = gsonObj.toJson(list);
%>
<div id="chartContainer" style="height: 350px; width: 100%;"></div>
            <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        
  <script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
      title: {
            text: "Stock Market"
      },
      axisX: {
            title: "Company"
      },
      axisY: {
            title: "Stock Price"
      },
      data: [{
            type: "column",
            yValueFormatString: "##0.0#",
            dataPoints: <%out.print(dataPoints);%>
      }]
});
chart.render();

}
</script> 

</body>
</html>