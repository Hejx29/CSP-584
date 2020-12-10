<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>
<%
    String username = (String) session.getAttribute("username");
    HashMap<String, ArrayList<ServiceOrderItem>> serviceOrders = (HashMap<String, ArrayList<ServiceOrderItem>>) session.getAttribute("serviceOrder");

    if (serviceOrders.get(username) == null) {
%>

<div id="emptycartindent">
    <h2 id="h2">You have not booked any services!</h2>

    <h3><a href="javascript:;" onClick="javascript:history.back(-1);">Go Shopping Now</a></h3>
</div>
<%} else {%>

<!-- Top content -->

<%--    <div class="inner-bg">--%>
<div class="container">
    <div style="text-align: center">
        <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Your Service<br>

            </h1>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
        </div>
        <table border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr id="tr1">
                <td>ServiceNo</td>
                <td>ServiceName</td>
                <td>Total Hour</td>
                <td>Total Price</td>
                <td>Service Detail</td>
                <td>Appointment Date</td>
                <td>Appointment Time</td>
                <td colspan="2">Operation</td>
            </tr>
            <%
                for (ServiceOrderItem oi : serviceOrders.get(username)) {
                    String serviceName = oi.getServiceName();
                    String price = oi.getPrice();
                    String hour = oi.getHour();
                    String serviceDetail = oi.getServiceDetail();
                    String date = oi.getDate();
                    String time = oi.getTime();
                    int orderId = oi.getOrderId();
            %>

            <tr id="tr2">
                <td>
                    <%=orderId %>
                </td>
                <td>
                    <%=serviceName %>
                </td>
                <td>
                    <%=hour %>
                </td>

                <td>
                    <%=price %>
                </td>
                <td>
                    <%=serviceDetail %>
                </td>
                <td>
                    <%=date %>
                </td>
                <td>
                    <%=time %>
                </td>
                <td>
                    <form method='post' action='ClearOrDeleteCart'>
                        <input type=hidden name="orderId" value="<%=orderId %>">
                        <input type='submit' name='Cancel' value='Cancel' class='btnbuy'/>
                    </form>
                </td>
                <td>
                    <form method='post' action='WriteServiceReview.jsp'>
                        <input type=hidden name="orderId" value="<%=orderId %>">
                        <input type='submit' name='' value='WriteReview' class='btnbuy'/>
                    </form>
                </td>
            </tr>
            <% }
            %>
        </table>
    </div>
</div>
</div>
</div>
<%}%>

</body>
<br>
<br>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>