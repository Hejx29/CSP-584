<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.Product" %>
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
		<body>
			<div class="top-content-container">
			    <div class="inner-bg">
			   	 <div class="manager-container">
			   	    <!--/LeftNavigationBar-->
					<jsp:include  page="LeftNavigationBar.jsp"/>
					<!--/rightContent-->
					<div id = rightcontent>
					  <div class = post>
						 <p class = homepagetitle>Bar Chart Of Product Inventory</p>
						 <br>
					         <div id="container" style="width: 1000px; height:850px; margin: 0 auto;"></div>
					         <script language="JavaScript">
							        function drawChart() {
							            /* Define the chart to be drawn.*/
							            var data = google.visualization.arrayToDataTable([
							                ['Product Name', 'Inventory'],
							                <%ArrayList<Product> Productslsit = (ArrayList<Product>)session.getAttribute("Inventory");
							                
									        for (Product product : Productslsit) {%>

									             ['<%=product.getProductName() %>' , <%=Integer.parseInt(product.getProductInventory()) %>],
									        <%}%>
							            ]);
							            var options = {
							                title: 'Inventory of Product',
							                isStacked: true
							            };
							            /* Instantiate and draw the chart.*/
							            var chart = new google.visualization.BarChart(document.getElementById('container'));
							            chart.draw(data, options);
							        }
							        google.charts.setOnLoadCallback(drawChart);
							    </script>        
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
