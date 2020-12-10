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
		     <p class = homepagetitle>Add Service Order</p>
		     <br>
		     <span class="errorMsg">
                        ${requestScope.addOrderMsg}
                    </span>
		      <form method='post' action='AddServiceOrder'>
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
			             Service ID:
			      		</td>
			      		<td>
			      		<input type='text' name='serviceid' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ServiceName:
			      		</td>
			      		<td>
			      		<input type='text' name='servicename' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             serviceDetail:
			      		</td>
			      		<td>
			      		<input type='text' name='servicedetail' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             serviceDate:
			      		</td>
			      		<td>
			      		<input type='date' name='servicedate' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             serviceTime:
			      		</td>
			      		<td>
			      		<input type='time' name='servicetime' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             firstName:
			      		</td>
			      		<td>
			      		<input type='text' name='firstname' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             lastName:
			      		</td>
			      		<td>
			      		<input type='text' name='lastname' value='' class= inputstyle >
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
			             zipCode:
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
			             serviceHour:
			      		</td>
			      		<td>
			      		<input type='text' name='serviceHour' value='' class= inputstyle >
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
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="addserviceorder" value="Add Service Order" id="submit" style="border-style:none"
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
