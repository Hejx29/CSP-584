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
		     <p class = homepagetitle>CustomerList</p>
		     <br>
		     
		      <table border="1px" width="960px" height="100px">
		      <tr id = "tr1">
			 
			      <td>Username</td>
	              <td>Street</td>
	       		  <td>City</td>
	       		  <td>State</td>
	       		  <td>ZipCode</td>
	       		  <td>Phone</td>
	       		  <td>Email</td>
	              <td>UpdateCustomer</td>
              </tr>
              <% 
              ArrayList<Profile> list = (ArrayList<Profile>)session.getAttribute("Customerlist"); 
                 int size = list.size();
                 for(int i = 0; i< size;i++){%>
                	  <tr id= "t2">
               		
               		<td>
               		<%=list.get(i).getUsername() %>
               		</td>
               		<td>
               		<%=list.get(i).getStreet() %>
               		</td>
               		<td>
               		<%=list.get(i).getCity() %>
               		</td>
               		<td>
               		<%=list.get(i).getState() %>
               		</td>
               		<td>
               		<%=list.get(i).getZipCode() %>
               		</td>
               		<td>
               		<%=list.get(i).getPhone() %>
               		</td>
               		<td>
               		<%=list.get(i).getEmail() %>
               		</td>
               		
               		<td>
               			 <form method='post' action='updateCustomer.jsp'>
               			
                    		
                    		<input type='hidden' name='Username' value="<%=list.get(i).getUsername()%>">
                    		<input type='hidden' name='Street' value="<%=list.get(i).getStreet()%>">
                    		<input type='hidden' name='City' value="<%=list.get(i).getCity()%>">
                    		<input type='hidden' name='State' value="<%=list.get(i).getState()%>">
                    		<input type='hidden' name='ZipCode' value="<%=list.get(i).getZipCode()%>">
                    		<input type='hidden' name='Phone' value="<%=list.get(i).getPhone()%>">
                    		<input type='hidden' name='Email' value="<%=list.get(i).getEmail()%>">
                    		<input type='submit' name='Customer' value='Update' class='btnbuy'/>
                    		
                		</form>
               		
               		</td>
               </tr>
                	 
                 <%}%>
              
              </table>
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
