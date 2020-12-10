<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.Profile" %>
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
		     <p class = homepagetitle>Add Customer</p>
		     <br>
		     <span class="errorMsg">
                        ${requestScope.addCustomerMsg}
                    </span>
		      <form method='post' action='AddCustomer'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             Username:
			      		</td>
			      		<td>
			      		<input type='text' name='Username' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Street:
			      		</td>
			      		<td>
			      		<input type='text' name='Street' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             City:
			      		</td>
			      		<td>
			      		<input type='text' name='City' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             State:
			      		</td>
			      		<td>
			      		<input type='text' name='State' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ZipCode:
			      		</td>
			      		<td>
			      		<input type='text' name='ZipCode' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Phone:
			      		</td>
			      		<td>
			      		<input type='text' name='Phone' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Email:
			      		</td>
			      		<td>
			      		<input type='text' name='Email' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="add customer" value="add customer" id="submit" style="border-style:none"
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
