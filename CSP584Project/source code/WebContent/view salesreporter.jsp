<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="Bean.ToolsOrderItem" %>
<%@ page import="java.util.ArrayList" %>



<jsp:include page="managerHeader.jsp" />
<link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/> 
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {
            packages: ['corechart']
        });
    </script>

<div class="top-content-container">
    <div class="inner-bg">
   	 <div class="manager-container">
   	         <!--/LeftNavigationBar-->
		    <jsp:include  page="LeftNavigationBar.jsp"/>
		    <!--/rightContent-->
		    <div id = rightcontent>
		     <div class = post>
		     <p class = homepagetitle>Table of Service Sold</p>
		     <br>

		      <table border="1px" width="1060px" height="80px">
		      <tr id = "tr1">  
	       		  <td>ServiceName</td>
	       		  <td>ServiceTotalTime</td>
	       		  <td>Counts</td>
	       		  <td>Price</td>
            	</tr> 
            	<%
            	HashMap<String, ServiceOrderItem> ServiceorderPaymentHashMap = (HashMap<String, ServiceOrderItem>)session.getAttribute("ServiceOrderItem"); 
                 
                 for(ServiceOrderItem sop : ServiceorderPaymentHashMap.values()){%>
                	  <tr id= "t2">
               		
               
               		<td>
               		<%=sop.getServiceName() %>
               		</td>
               		<td>
               		<%=sop.getServiceTotalTime()%>
               		</td>
               		
               		<td>
               		<%=sop.getCounts() %>
               		</td>
               		<td>
               		<%=sop.getPrice() %>
               		</td>
               		
               		
               </tr>
                	 
                 <%}%>
              
              </table>
        <br>
        <br> 
       <p class = homepagetitle>Table of Tool Sold</p>
		<br>
         <table border="1px" width="1060px" height="80px">
		        <tr id = "tr1">
		
			      
	              <td>ProductName</td>
	       		  <td>Price</td>
	              <td>SaleAmount</td>
	              <td>Counts</td>
            	 </tr> 
          <%
          HashMap<String, ToolsOrderItem> toollist = (HashMap<String, ToolsOrderItem>)session.getAttribute("ToolOrderItemlsit"); 
                 
          for(ToolsOrderItem tool : toollist.values()){
        	  String amount = String.format("%.2f", Double.parseDouble(tool.getSaleAmount()));
        	  String price = String.format("%.2f", Double.parseDouble(tool.getSaleAmount())/tool.getCounts());
          %>
                 <tr id= "t2">
                 <td>
               		<%=tool.getProductName() %>
               		</td>
               		<td>
               		<%=price %>$
               		</td>
               		<td>
               		<%= amount %>$
               		</td>
               		<td>
               		<%=tool.getCounts() %>
               		</td>
               		
               	
                 </tr>
                 <%}%>
		  </table> 
		  <br>
		  <br>
		     <p class = homepagetitle>Bar Chart Of Tool SaleAmount</p>
						 <br>
					         <div id="container" style="width: 1000px; height:550px; margin: 0 auto;"></div>
					         <script language="JavaScript">
							        function drawChart() {
							            /* Define the chart to be drawn.*/
							            var data = google.visualization.arrayToDataTable([
							                ['Product Name', 'SaleAmount'],
							                <%HashMap<String, ToolsOrderItem> ToolChart = (HashMap<String, ToolsOrderItem>)session.getAttribute("ToolOrderItemlsit"); 
;
							                
									        for (ToolsOrderItem tools : ToolChart.values()) {
									        %>

								             ['<%=tools.getProductName() %>' , <%= Double.parseDouble(tools.getSaleAmount())%>],

									        <%}%>
							            ]);
							            var options = {
							                title: 'SaleAmount of Tools',
							                isStacked: true
							            };
							            /* Instantiate and draw the chart.*/
							            var chart = new google.visualization.BarChart(document.getElementById('container'));
							            chart.draw(data, options);
							        }
							        google.charts.setOnLoadCallback(drawChart);
							    </script>        
		     
		     <br>
		     <br>
		     
		     <p class = homepagetitle>Table of Tool Sold</p>
		<br>
         <table border="1px" width="1060px" height="80px">
		        <tr id = "tr1">
		
			      
	              
	       		  <td>CreateTime</td>
	              <td>SaleAmount</td>
	            
            	 </tr> 
          <%
          HashMap<String, ToolsOrderItem> tooltime = (HashMap<String, ToolsOrderItem>)session.getAttribute("ToolOrderTime"); 

          
          for(ToolsOrderItem tool : tooltime.values()){
                  	  String amount = String.format("%.2f", Double.parseDouble(tool.getSaleAmount()));
          %>
                 <tr id= "t2">
                 <td>
                	<%=tool.getCreateTime() %> 
               		</td>
               		<td>
               		<%= amount %>$
               		</td>
               		
               		
               	
                 </tr>
                 <%}%>
		  </table> 
		     
		     </div>
		    </div>
    </div>
    <br style='clear:both'/>
 </div>


</div>
</body>
<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
