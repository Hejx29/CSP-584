<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Review" %>
<%@ page import="Bean.Bestrating" %>
<%@ page import="Bean.MostSold" %>
<%@ page import="Bean.Mostsoldzip" %>
<%@ page import="com.mongodb.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.Iterator;" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>
<!-- Top content -->
<div class="container">
    <div style="text-align: center">
        <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Top 5 most liked products<br>
            </h1>
            
        </div>
        <% ArrayList<Bestrating> bestrated = new ArrayList<Bestrating>();
        	bestrated = (ArrayList<Bestrating>)session.getAttribute("bestrated");
        	
        	if (bestrated.size() == 0) {
        %>
        <div id="emptycartindent">
            <h2 id="h2">No Trending Data</h2>
        </div>
       <% } %>
       <table border="1px" width="660px" height="200px" style="margin: auto">
            <tr>
                <td> Product Name</td>
                <td> Review Rating</td>
            </tr>
   <% for (Bestrating best:bestrated) {
        %>
        <tr id= "t2">
             	<td>
                    <%=best.getProductname() %>
                    <input type='hidden' name='ProductName' value='<%=best.getProductname() %>'>
                </td>
                
                <td>
                    <%=best.getRating()%>
                    <input type='hidden' name='rating' value='<%=best.getRating()%>'>
                </td>
        </tr>
       <% } %>
       </table>
       
       <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Top 5 most sold products regardless of the rating<br>
            </h1>
      </div>
      <% ArrayList<MostSold> mostsold = new ArrayList<MostSold>();
      		mostsold = (ArrayList<MostSold>)session.getAttribute("mostsold");
        	
        	if (mostsold.size() == 0) {
        %>
        <div id="emptycartindent">
            <h2 id="h2">No Trending Data</h2>
        </div>
       <% } %>
       <table border="1px" width="660px" height="200px" style="margin: auto">
            <tr>
                <td> Product Name</td>
                <td> Count</td>
            </tr>
   <% for (MostSold msold:mostsold) {
        %>
        <tr id= "t2">
             	<td>
                    <%=msold.getProductname() %>
                    <input type='hidden' name='ToolName' value='<%=msold.getProductname() %>'>
                </td>
                
                <td>
                    <%=msold.getCount()%>
                    <input type='hidden' name='count' value='<%=msold.getCount()%>'>
                </td>
        </tr>
       <% } %>
       </table>
       
       <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Top 5 zip-codes where maximum number of products sold
      </div>
      <% ArrayList<Mostsoldzip> mostsoldzip = new ArrayList<Mostsoldzip>();
      		mostsoldzip = (ArrayList<Mostsoldzip>)session.getAttribute("mostsoldzip");
        	
        	if (mostsoldzip.size() == 0) {
        %>
        <div id="emptycartindent">
            <h2 id="h2">No Trending Data</h2>
        </div>
       <% } %>
       <table border="1px" width="660px" height="200px" style="margin: auto">
            <tr>
                <td> Zip</td>
                <td> Count</td>
            </tr>
   <% for (Mostsoldzip msoldzip:mostsoldzip) {
        %>
        <tr id= "t2">
             	<td>
                    <%=msoldzip.getZipcode() %>
                    <input type='hidden' name='ToolName' value='<%=msoldzip.getZipcode() %>'>
                </td>
                
                <td>
                    <%=msoldzip.getCount()%>
                    <input type='hidden' name='count' value='<%=msoldzip.getCount()%>'>
                </td>
        </tr>
       <% } %>
       </table>
        </div>
  </div>
