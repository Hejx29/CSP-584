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
		     <p class = homepagetitle>Update Product</p>
		     <br>
		      <form method='post' action='UpdateProduct'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             Product ID:
			      		</td>
			      		<td>
			      		<input type='text' name='productId' value="<%=request.getAttribute("Id")%>" class= inputstyle readonly = "true">
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Name:
			      		</td>
			      		<td>
			      		<input type='text' name='productName' value="<%=request.getAttribute("Name")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Price:
			      		</td>
			      		<td>
			      		<input type='text' name='productPrice' value="<%=request.getAttribute("Price")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Inventory:
			      		</td>
			      		<td>
			      		<input type='text' name='productInventory' value="<%=request.getAttribute("Inventory")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Status:
			      		</td>
			      		<td>
			      		<input type='text' name='productStatus' value="<%=request.getAttribute("Status")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Describe:
			      		</td>
			      		<td>
			      		<input type='text' name='productDescribe' value="<%=request.getAttribute("Describe")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	 <tr>
			      		<td class = inputname>
			             Product Image:
			      		</td>
			      		<td style="color:#ffffff;width:900px">
			      		
			      		<input type='text' name='productImage' class= inputstyle  value="<%=request.getAttribute("Image")%>" >
			      		</td>
			      	</tr> 
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="update product" value="update product" id="submit" style="border-style:none"
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
