<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="Bean.ToolsOrderItem" %>
<%@ page import="java.util.ArrayList" %>



<jsp:include page="managerHeader.jsp" />
<link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/> 


<div class="top-content-container">
    <div class="inner-bg">
   	 <div class="manager-container">
   	         <!--/LeftNavigationBar-->
		    <jsp:include  page="LeftNavigationBar.jsp"/>
		    <!--/rightContent-->
		    <div id = rightcontent>
		     <div class = post>
		     <p class = homepagetitle>Service Order List</p>
		     <br>

		      <table border="1px" width="1060px" height="80px">
		      <tr id = "tr1">
			 
			      <td>OrderId</td>
			      <td>Username</td>
	              <td>Id</td>
	       		  <td>ServiceName</td>
	       		  <td>Detail</td>
	       		  <td>Date</td>
	       		  <td>Time</td>
	       		  <td>Price</td>
	              <td>UpdateOrder</td>
	              <td>RemoveOrder</td>
            	</tr> 
            	<%
              ArrayList<ServiceOrderItem> list = (ArrayList<ServiceOrderItem>)session.getAttribute("ServiceOrderItem"); 
                 int size = list.size();
                 for(int i = 0; i< size;i++){%>
                	  <tr id= "t2">
               		
               		<td>
               		<%=list.get(i).getOrderId() %>
               		</td>
               		<td>
               		<%=list.get(i).getUsername() %>
               		</td>
               		<td>
               		<%=list.get(i).getProductId() %>
               		</td>
               		<td>
               		<%=list.get(i).getServiceName() %>
               		</td>
               		<td>
               		<%=list.get(i).getServiceDetail() %>
               		</td>
               		<td>
               		<%=list.get(i).getDate() %>
               		</td>
               		<td>
               		<%=list.get(i).getTime() %>
               		</td>
               		<td>
               		<%=list.get(i).getPrice() %>
               		</td>
               		
               		<td>
               			 <form method='post' action='RemoveUpdateServiceOrder'>
               			
                    		<input type='submit' name='ServiceOrder' value='Update' class='btnbuy'/>
                    		<input type='hidden' name='OrderId' value="<%=list.get(i).getOrderId()%>">
                    		<input type='hidden' name='Username' value="<%=list.get(i).getUsername()%>">
                    		<input type='hidden' name='ServiceId' value="<%=list.get(i).getProductId()%>">
                    		<input type='hidden' name='ServiceName' value="<%=list.get(i).getServiceName()%>">
                    		<input type='hidden' name='ServiceDetail' value="<%=list.get(i).getServiceDetail()%>">
                    		<input type='hidden' name='serviceDate' value="<%=list.get(i).getDate()%>">
                    		<input type='hidden' name='serviceTime' value="<%=list.get(i).getTime()%>">
                    		<input type='hidden' name='servicePrice' value="<%=list.get(i).getPrice()%>">
                    		
                		</form>
               		
               		</td>
               		<td>
               			 <form method='post' action='RemoveUpdateServiceOrder'>
                    		<input type='submit' name='ServiceOrder' value='Remove' class='btnbuy'/>
                    		<input type='hidden' name='OrderId' value="<%=list.get(i).getOrderId()%>">
                    		<input type='hidden' name='Username' value="<%=list.get(i).getUsername()%>">
                    		<input type='hidden' name='ServiceId' value="<%=list.get(i).getProductId()%>">
                    		<input type='hidden' name='ServiceName' value="<%=list.get(i).getServiceName()%>">
                    		<input type='hidden' name='ServiceDetail' value="<%=list.get(i).getServiceDetail()%>">
                    		<input type='hidden' name='serviceDate' value="<%=list.get(i).getDate()%>">
                    		<input type='hidden' name='serviceTime' value="<%=list.get(i).getTime()%>">
                		</form>
               		
               		</td>
               </tr>
                	 
                 <%}%>
              
              </table>
        <br>
        <br> 
       <p class = homepagetitle>Tool Order List</p>
		<br>
         <table border="1px" width="1060px" height="80px">
		        <tr id = "tr1">
		
			      <td>OrderId</td>
			      <td>FullName</td>
	              <td>ProductName</td>
	       		  <td>Price</td>
	       		  <td>Quantity</td>
	       		  <td>Address</td>
	       		  <td>ZipCode</td>
	              <td>UpdateOrder</td>
	              <td>RemoveOrder</td>
            	 </tr> 
          <%
              ArrayList<ToolsOrderItem> toollist = (ArrayList<ToolsOrderItem>)session.getAttribute("ToolOrderItemlsit"); 
                 int listsize = toollist.size();
                 for(int i = 0; i< listsize;i++){%>
                 <tr id= "t2">
                 <td>
               		<%=toollist.get(i).getOrderId() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getFullName() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getProductName() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getPrice() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getQuantity() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getStreet() %> ,<%=toollist.get(i).getCity() %>,<%=toollist.get(i).getState() %>
               	 </td>
               	 <td>
               		<%=toollist.get(i).getZip() %> 
               	 </td>
               	<td>
               			 <form method='post' action='RemoveUpdateToolOrder'>
               			
                    		<input type='submit' name='ToolOrder' value='Update' class='btnbuy'/>
                    		<input type='hidden' name='OrderId' value="<%=toollist.get(i).getOrderId()%>">
                    		<input type='hidden' name='FullName' value="<%=toollist.get(i).getFullName()%>">
                    		<input type='hidden' name='ProductName' value="<%=toollist.get(i).getProductName()%>">
                    		<input type='hidden' name='Price' value="<%=toollist.get(i).getPrice()%>">
                    		<input type='hidden' name='Quantity' value="<%=toollist.get(i).getQuantity()%>">
                    		<input type='hidden' name='Street' value="<%=toollist.get(i).getStreet()%>">
                    		<input type='hidden' name='City' value="<%=toollist.get(i).getCity()%>">
                    		<input type='hidden' name='State' value="<%=toollist.get(i).getState()%>">
                    		<input type='hidden' name='Zip' value="<%=toollist.get(i).getZip()%>">
                    		 
                		</form>
               		
               		</td>
               		<td>
               			 <form method='post' action='RemoveUpdateToolOrder'>
                    		<input type='submit' name='ToolOrder' value='Remove' class='btnbuy'/>
                    		<input type='hidden' name='OrderId' value="<%=toollist.get(i).getOrderId()%>">
                    		<input type='hidden' name='FullName' value="<%=toollist.get(i).getFullName()%>">
                    		<input type='hidden' name='ProductName' value="<%=toollist.get(i).getProductName()%>">
                    		<input type='hidden' name='Price' value="<%=toollist.get(i).getPrice()%>">
                    		<input type='hidden' name='Quantity' value="<%=toollist.get(i).getQuantity()%>">
                    		<input type='hidden' name='Street' value="<%=toollist.get(i).getStreet()%>">
                    		<input type='hidden' name='City' value="<%=toollist.get(i).getCity()%>">
                    		<input type='hidden' name='State' value="<%=toollist.get(i).getState()%>">
                    		<input type='hidden' name='Zip' value="<%=toollist.get(i).getZip()%>">
                		</form>
               		
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
