<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<%@ page import="Bean.ContactInfo" %>
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
		     <p class = homepagetitle>Customer message</p>
		     <br>
		      <table border="1px" width="960px" height="100px">
		      <tr id = "tr1">
			 
			      <td>ContactID</td>
			      <td>CustomerId</td>
	              <td>Name</td>
	       		  <td>Email</td>
	       		  <td>Phone</td>
	              <td>message</td>
	              <td>respond message</td>
              </tr>
              <% ArrayList<ContactInfo> list = (ArrayList<ContactInfo>)session.getAttribute("ContactInfo"); 
                 int size = list.size();
                 for(int i = 0; i< size;i++){%>
                	  <tr id= "t2">
               		
               		<td>
               		<%=list.get(i).getContactid() %>
               		</td>
               		<td>
               		<%=list.get(i).getCustomerid() %>
               		</td>
               		<td>
               		<%=list.get(i).getCustomername() %>
               		</td>
               		<td>
               		<%=list.get(i).getCustomeremail() %>
               		</td>
               		<td>
               		<%=list.get(i).getCustomerphone() %>
               		</td>
               		<td>
               		<%=list.get(i).getCustomermessage() %>
               		</td>
               		
               		<td>
               			 <form method='post' action='replyMessage'>
               			
                    		<input type='submit' name='ContactInfo' value='reply' class='btnbuy'/>
                    		<input type='hidden' name='Contactid' value="<%=list.get(i).getContactid()%>">
                    		<input type='hidden' name='Customerid' value="<%=list.get(i).getCustomerid()%>">
                    		<input type='hidden' name='CustomerName' value="<%=list.get(i).getCustomername()%>">
                    		<input type='hidden' name='Customeremail' value="<%=list.get(i).getCustomeremail()%>">
                    		<input type='hidden' name='Customerphone' value="<%=list.get(i).getCustomerphone()%>">
                    		<input type='hidden' name='getCustomermessage' value="<%=list.get(i).getCustomermessage()%>">
                    		
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
