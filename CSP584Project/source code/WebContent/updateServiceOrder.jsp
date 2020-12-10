<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.Product" %>
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
		     <p class = homepagetitle>Update Service Order</p>
		     <br>
		      <form method='post' action='UpdateServiceOrder'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             OrderId:
			      		</td>
			      		<td>
			      		<input type='text' name='OrderId' value="<%=request.getAttribute("OrderId")%>" class= inputstyle readonly = "true" >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Username:
			      		</td>
			      		<td>
			      		<input type='text' name='Username' value="<%=request.getAttribute("Username")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ServiceId:
			      		</td>
			      		<td>
			      		<input type='text' name='ServiceId' value="<%=request.getAttribute("ServiceId")%>" class= inputstyle readonly = "true">
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ServiceName:
			      		</td>
			      		<td>
			      		<input type='text' name='ServiceName' value="<%=request.getAttribute("ServiceName")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ServiceDetail:
			      		</td>
			      		<td>
			      		<input type='text' name='ServiceDetail' value="<%=request.getAttribute("ServiceDetail")%>" class= inputstyle >
			      		</td>
			   		</tr>
			      	<tr>
			      		<td class = inputname>
			             serviceDate:
			      		</td>
			      		<td>
			      		<input type='text' name='serviceDate' value="<%=request.getAttribute("serviceDate")%>" class= inputstyle >
			      		</td>
		
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             serviceTime:
			      		</td>
			      		<td>
			      		<input type='text' name='serviceTime' value="<%=request.getAttribute("serviceTime")%>" class= inputstyle >
			      		</td>
		
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             servicePrice:
			      		</td>
			      		<td>
			      		<input type='text' name='servicePrice' value="<%=request.getAttribute("servicePrice")%>" class= inputstyle >
			      		</td>
		
			      	</tr>
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="update service order" value="update service order" id="submit" style="border-style:none"
	               			class="button-2";>
	                    </td>
			      	</tr>
			      	
			      	
			      </table>
			    </form>
        <br>
        <br>
        
		     </div>
		    </div>
    </div>
 </div>


</div>
</body>
<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
