<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.ToolsOrderItem" %>
<%@ page import="java.util.List" %>
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
    List<ToolsOrderItem> toolsOrderItemList = (List<ToolsOrderItem>) session.getAttribute("toolOrders");

    if (toolsOrderItemList == null || toolsOrderItemList.isEmpty()) {
%>

<div id="emptycartindent">
    <h2 id="h2">You have not order any tools!</h2>

    <h3><a href="getProduct">Go Shopping Now</a></h3>
</div>
<%} else {%>

<!-- Top content -->

<%--    <div class="inner-bg">--%>
<div class="container">
    <div style="text-align: center">
        <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Your Orders<br>

            </h1>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
        </div>
        <table border="1" cellpadding="3" cellspacing="0" style="width: 80%;margin:auto">
            <tr id="tr1">
                <td>OrderNo</td>
                <td>productName</td>
                <td>Quantity</td>
                <td>Total Price</td>
                <td>Delivery Method</td>
                <td>Create Time</td>
                <td colspan="2">Operation</td>
            </tr>
            <%
                for (ToolsOrderItem orderItem : toolsOrderItemList) {

            %>

            <tr id="tr2">
                <td>
                    <%=orderItem.getOrderId() %>
                </td>
                <td>
                    <%=orderItem.getProductName() %>
                </td>
                <td>
                    <%=orderItem.getQuantity() %>
                </td>

                <td>
                    <%=orderItem.getPrice() %>
                </td>
                <td>
                    <%=orderItem.getDeliveryMethod() %>
                </td>
                <td>
                    <%=orderItem.getCreateTime() %>
                </td>
                <td>
                    <form method='post' action='CancelToolOrder'>
                        <input type=hidden name="orderId" value="<%=orderItem.getOrderId() %>">
                        <input type='submit' name='Cancel' value='Cancel' class='btnbuy'/>
                    </form>
                </td>
                <td>
                    <form method='post' action='WriteToolReview.jsp'>
                        <input type=hidden name="orderId" value="<%=orderItem.getOrderId() %>">
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