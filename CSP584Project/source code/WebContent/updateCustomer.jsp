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
		     <p class = homepagetitle>Update Customer</p>
		     <br>
		      <form method='post' action='UpdateCustomerList'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             Username:
			      		</td>
			      		<td>
			      		<input type='text' name='Username' value="<%=request.getParameter("Username")%>" class= inputstyle readonly = "true" >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Street:
			      		</td>
			      		<td>
			      		<input type='text' name='Street' value="<%=request.getParameter("Street")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             City:
			      		</td>
			      		<td>
			      		<input type='text' name='City' value="<%=request.getParameter("City")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             State:
			      		</td>
			      		<td>
			      		<input type='text' name='State' value="<%=request.getParameter("State")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             ZipCode:
			      		</td>
			      		<td>
			      		<input type='text' name='ZipCode' value="<%=request.getParameter("ZipCode")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Phone:
			      		</td>
			      		<td>
			      		<input type='text' name='Phone' value="<%=request.getParameter("Phone")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Email:
			      		</td>
			      		<td>
			      		<input type='text' name='Email' value="<%=request.getParameter("Email")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	 
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="update customer" value="update customer" id="submit" style="border-style:none"
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
