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

<!-- Top content -->
<%
    String username = (String) session.getAttribute("username");
    int productNo = Integer.parseInt(request.getParameter("orderId"));
    List<ToolsOrderItem> toolsOrderItemList = (List<ToolsOrderItem>) session.getAttribute("toolOrders");
    for (ToolsOrderItem oi : toolsOrderItemList) {
        if (productNo == oi.getOrderId()) {
%>

<%--    <div class="inner-bg">--%>
<div class="container">
    <div style="text-align: center">
        <div class="col-sm-12 top-content-text">
            <h1 style="color:#000;">
                Write Review<br>

            </h1>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
        </div>

        </h2>
        <div class='entry'>
            <form name='WriteReview' action='WriteReview' method='post'>
                <table border="1px" width="460px" height="100px" style="margin: auto">
                    <input type='hidden' name='type' value='Tool'>
                    <tr>
                        <td> Product Name:
                        </td>
                        <td>
                            <%=oi.getProductName() %>
                            <input type='hidden' name='productName' value='<%=oi.getProductName() %>'>
                        </td>
                    </tr>


                    <tr>
                        <td> Quantity:</td>
                        <td>
                            <%=oi.getQuantity() %>
                            <input type='hidden' name='hour' value='<%=oi.getQuantity() %>'>
                        </td>
                    </tr>


                    <tr>
                        <td> Price:</td>
                        <td>
                            <%=oi.getPrice() %>
                            <input type='hidden' name='price' value='<%=oi.getPrice() %>'>
                        </td>
                    </tr>

                    <tr>
                        <td> Store ID:</td>
                        <td>
                            HomeHub Mall
                            <input type='hidden' name='storeID' value='HomeHub'>
                        </td>
                    </tr>

                    <tr>
                        <td> Store Zip:</td>
                        <td>
                            <%=oi.getZip() %>
                            <input type='hidden' type='text' name='storeZip' value='<%=oi.getZip() %>'>
                        </td>
                    </tr>

                    <tr>
                        <td> Store City:</td>
                        <td>
                            <%=oi.getCity()%>
                            <input type='hidden' name='storeCity' value='<%=oi.getCity()%>'>
                        </td>
                    </tr>

                    <tr>
                        <td> Store State:</td>
                        <td>
                            <%=oi.getState()%>
                            <input type='hidden' name='storeState' value='<%=oi.getState()%>'>
                        </td>
                    </tr>

                    <% }
                    }
                    %>
                </table>

                <br/>

                <table style="margin: auto">
                    <tr align="left">
                        <td> User ID:</td>
                        <td><%=username%></td>
                    </tr>

                    <tr align="left">
                        <td align="left"> User Age:</td>
                        <td>
                            <input type='text' name='userAge' required>
                        </td>
                    </tr>


                    <tr align="left">
                        <td> User Gender:</td>
                        <td>
                            <select name='userGender'>
                                <option value='male' selected>Male</option>
                                <option value='female'>Female</option>
                            </select>
                        </td>
                    </tr>
                    <tr align="left">
                        <td> User Occupation:</td>
                        <td><input type='text' name='userOccupation' required></td>
                    </tr>

                    <tr>
                        <td>&nbsp;
                        </td>
                        <td>&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;
                        </td>
                        <td>&nbsp;
                        </td>
                    </tr>
                    <tr align="left">
                        <td> Review Rating:</td>
                        <td>
                            <select name='reviewrating'>
                                <option value='1' selected>1</option>
                                <option value='2'>2</option>
                                <option value='3'>3</option>
                                <option value='4'>4</option>
                                <option value='5'>5</option>
                            </select>
                        </td>
                    </tr>

                    <tr align="left">
                        <td> Review Date:</td>
                        <td><input type='date' name='reviewDate' required></td>
                    </tr>

                    <tr align="left">
                        <td> Review Text:</td>
                        <td><textarea name='reviewText' rows='4' cols='50' required> </textarea></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input type='submit' class='btnbuy' name='SubmitReview'
                                               value='SubmitReview'>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
<br>
<br>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>