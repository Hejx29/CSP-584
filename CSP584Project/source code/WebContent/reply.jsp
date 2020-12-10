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
		     <p class = homepagetitle>reply Customer</p>
		     <br>
		     <span class="errorMsg">
                        ${requestScope.addCustomerMsg}
                    </span>
		      <form method='post' action='sendEmail'>
		      	<table class='table'>
			     	 <tr>
			      		<td class = inputname>
			             To:
			      		</td>
			      		<td>
			      		<input type='text' name='Receiver' value="<%=request.getAttribute("Email")%>" class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             From:
			      		</td>
			      		<td>
			      		<input type='text' name='Poster' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Password:
			      		</td>
			      		<td>
			      		<input type='password' name='Password' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Subject:
			      		</td>
			      		<td>
			      		<input type='text' name='Subject' value='' class= inputstyle >
			      		</td>
			      	</tr>
			      	<tr>
			      		<td class = inputname>
			             Compose email:
			      		</td>
			      		<td>
			      		<input type='text' name='Email' value='' class= inputstyle style="height:300px;">
			      		</td>
			      	</tr>
			      	
			      	
			      	<tr>
				      	<td >
				      	</td>
				      	<td align="right"><input type="submit" name="submit" value="send" id="submit" style="border-style:none"
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
