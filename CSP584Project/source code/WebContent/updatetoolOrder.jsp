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
		     <p class = homepagetitle>Update Tool Order</p>
		     <br>
		      <form method='post' action='UpdateToolOrder'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             OrderId:
			      		</td>
			      		<td>
			      		<input type='text' name='OrderId' value="<%=request.getAttribute("OrderId")%>" class= inputstyle readonly = "true">
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             FullName:
			      		</td>
			      		<td>
			      		<input type='text' name='FullName' value="<%=request.getAttribute("FullName")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ProductName:
			      		</td>
			      		<td>
			      		<input type='text' name='ProductName' value="<%=request.getAttribute("ProductName")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Price:
			      		</td>
			      		<td>
			      		<input type='text' name='Price' value="<%=request.getAttribute("Price")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Quantity:
			      		</td>
			      		<td>
			      		<input type='text' name='Quantity' value="<%=request.getAttribute("Quantity")%>" class= inputstyle >
			      		</td>
			   		</tr>
			      	<tr>
			      		<td class = inputname>
			             City:
			      		</td>
			      		<td>
			      		<input type='text' name='City' value="<%=request.getAttribute("City")%>" class= inputstyle >
			      		</td>
		
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             State:
			      		</td>
			      		<td>
			      		<input type='text' name='State' value="<%=request.getAttribute("State")%>" class= inputstyle >
			      		</td>
		
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Zip:
			      		</td>
			      		<td>
			      		<input type='text' name='Zip' value="<%=request.getAttribute("Zip")%>" class= inputstyle >
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
