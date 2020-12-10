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
		     <p class = homepagetitle>Add Product</p>
		     <br>
		     <span class="errorMsg">
                        ${requestScope.addProductMsg}
                    </span>
		      <form method='post' action='AddProduct'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             Product ID:
			      		</td>
			      		<td>
			      		<input type='text' name='productId' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Name:
			      		</td>
			      		<td>
			      		<input type='text' name='productName' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Price:
			      		</td>
			      		<td>
			      		<input type='text' name='productPrice' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Inventory:
			      		</td>
			      		<td>
			      		<input type='text' name='productInventory' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Describe:
			      		</td>
			      		<td>
			      		<input type='text' name='productDescribe' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Product Image:
			      		</td>
			      		<td style="color:#ffffff;width:900px">
			      		
			      		<input type='file' name='image' class= inputstyle  required>
			      		</td>
			      	</tr>
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="add product" value="add product" id="submit" style="border-style:none"
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
    <br style='clear:both'/>
 </div>


</div>
</body>
<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
