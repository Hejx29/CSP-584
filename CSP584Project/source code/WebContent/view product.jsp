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
		     <p class = homepagetitle>ProductList</p>
		     <br>
		     
		      <table border="1px" width="960px" height="100px">
		      <tr id = "tr1">
			 
			      <td>ID</td>
	              <td>Name</td>
	       		  <td>Price</td>
	       		  <td>Inventory</td>
	       		  <td>Status</td>
	              <td>UpdateProduct</td>
	              <td>RemoveProduct</td>
              </tr>
              <% 
              ArrayList<Product> list = (ArrayList<Product>)session.getAttribute("product"); 
                 int size = list.size();
                 for(int i = 0; i< size;i++){%>
                	  <tr id= "t2">
               		
               		<td>
               		<%=list.get(i).getProductId() %>
               		</td>
               		<td>
               		<%=list.get(i).getProductName() %>
               		</td>
               		<td>
               		<%=list.get(i).getProductPrice() %>
               		</td>
               		<td>
               		<%=list.get(i).getProductInventory() %>
               		</td>
               		<td>
               		<%=list.get(i).getProductStatus() %>
               		</td>
               		
               		
               		
               		<td>
               			 <form method='post' action='RemoveUpdateProduct'>
               			
                    		<input type='submit' name='Product' value='Update' class='btnbuy'/>
                    		<input type='hidden' name='productId' value="<%=list.get(i).getProductId()%>">
                    		<input type='hidden' name='productName' value="<%=list.get(i).getProductName()%>">
                    		<input type='hidden' name='productPrice' value="<%=list.get(i).getProductPrice()%>">
                    		<input type='hidden' name='productInventory' value="<%=list.get(i).getProductInventory()%>">
                    		<input type='hidden' name='productImage' value="<%=list.get(i).getProductImage()%>">
                    		<input type='hidden' name='productStatus' value="<%=list.get(i).getProductStatus()%>">
                    		<input type='hidden' name='productDescribe' value="<%=list.get(i).getProductDescribe()%>">
                    		
                		</form>
               		
               		</td>
               		<td>
               			 <form method='post' action='RemoveUpdateProduct'>
                    		<input type='submit' name='Product' value='Remove' class='btnbuy'/>
                    		<input type='hidden' name='productId' value="<%=list.get(i).getProductId()%>">
                    		<input type='hidden' name='productName' value="<%=list.get(i).getProductName()%>">
                    		<input type='hidden' name='productPrice' value="<%=list.get(i).getProductPrice()%>">
                    		<input type='hidden' name='productPrice' value="<%=list.get(i).getProductInventory()%>">
                    		<input type='hidden' name='productImage' value="<%=list.get(i).getProductImage()%>">
                    		<input type='hidden' name='productStatus' value="<%=list.get(i).getProductStatus()%>">
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
