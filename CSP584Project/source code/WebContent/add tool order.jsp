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
		     <p class = homepagetitle>Add Tool Order</p>
		     <br>
		     <span class="errorMsg">
                        ${requestScope.addToolOrderMsg}
                    </span>
		      <form method='post' action='AddToolOrder'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             Order ID:
			      		</td>
			      		<td>
			      		<input type='text' name='orderid' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Username:
			      		</td>
			      		<td>
			      		<input type='text' name='username' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             productId:
			      		</td>
			      		<td>
			      		<input type='text' name='productId' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             productName:
			      		</td>
			      		<td>
			      		<input type='text' name='productName' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             fullName:
			      		</td>
			      		<td>
			      		<input type='text' name='fullName' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             phone:
			      		</td>
			      		<td>
			      		<input type='text' name='phone' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             email:
			      		</td>
			      		<td>
			      		<input type='text' name='email' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             zip:
			      		</td>
			      		<td>
			      		<input type='text' name='zip' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             street:
			      		</td>
			      		<td>
			      		<input type='text' name='street' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             city:
			      		</td>
			      		<td>
			      		<input type='text' name='city' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             state:
			      		</td>
			      		<td>
			      		<input type='text' name='state' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             price:
			      		</td>
			      		<td>
			      		<input type='text' name='price' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             creditNo:
			      		</td>
			      		<td>
			      		<input type='text' name='creditNo' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             buyId:
			      		</td>
			      		<td>
			      		<input type='text' name='buyId' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             deliveryMethod:
			      		</td>
			      		<td>
			      		<input type='text' name='deliveryMethod' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             pickupLocation:
			      		</td>
			      		<td>
			      		<input type='text' name='pickupLocation' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             quantity:
			      		</td>
			      		<td>
			      		<input type='text' name='quantity' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             createTime:
			      		</td>
			      		<td>
			      		<input type='datetime' name='createTime' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="addtoolorder" value="Add Tool Order" id="submit" style="border-style:none"
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
