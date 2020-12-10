<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Review" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

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
                Your Review<br>
            </h1>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
        </div>
        <%
            String username = (String) session.getAttribute("username");
            HashMap<String, ArrayList<Review>> serviceReviews = (HashMap<String, ArrayList<Review>>) session.getAttribute("reviews");
            if (serviceReviews.get(username) == null) {
        %>
        <div id="emptycartindent">
            <h2 id="h2">No Reviews!!!</h2>
        </div>
        <%
        } else
            for (Review oi : serviceReviews.get(username)) {
        %>

        <table border="1px" width="460px" height="100px" style="margin: auto">
            <tr>
                <td> Product Name:
                </td>
                <td>
                    <%=oi.getProductname() %>
                    <input type='hidden' name='serviceName' value='<%=oi.getProductname() %>'>
                </td>
            </tr>


            <tr>
                <td> Product Type:</td>
                <td>
                    <%=oi.getProducttype() %>
                    <input type='hidden' name='hour' value='<%=oi.getProducttype() %>'>
                </td>
            </tr>


            <tr>
                <td> Total Service Price:</td>
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
                    <%=oi.getStorezip() %>
                    <input type='hidden' type='text' name='storeZip' value='<%=oi.getStorezip() %>'>
                </td>
            </tr>

            <tr>
                <td> Store City:</td>
                <td>
                    <%=oi.getStorecity()%>
                    <input type='hidden' name='storeCity' value='<%=oi.getStorecity()%>'>
                </td>
            </tr>

            <tr>
                <td> Store State:</td>
                <td>
                    <%=oi.getStorestate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getStorestate()%>'>
                </td>
            </tr>

            <tr>
                <td> User Age:</td>
                <td>
                    <%=oi.getUserage()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUserage()%>'>
                </td>
            </tr>
            <tr>
                <td> User Gender:</td>
                <td>
                    <%=oi.getUsergender()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUsergender()%>'>
                </td>
            </tr>
            <tr>
                <td> User Occupation:</td>
                <td>
                    <%=oi.getUserOccupation()%>
                    <input type='hidden' name='storeState' value='<%=oi.getUserOccupation()%>'>
                </td>
            </tr>

            <tr>
                <td> Review Rating:</td>
                <td>
                    <%=oi.getRate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getRate()%>'>
                </td>
            </tr>

            <tr>
                <td> Review Date:</td>
                <td>
                    <%=oi.getReviewDate()%>
                    <input type='hidden' name='storeState' value='<%=oi.getReviewDate()%>'>
                </td>
            </tr>
            <tr>
                <td> Review Text:</td>
                <td>
                    <%=oi.getReviewText()%>
                    <input type='hidden' name='storeState' value='<%=oi.getReviewText()%>'>
                </td>
            </tr>
        </table>
        <br/>
        <%
                }
        %>
    </div>
</div>


</body>
<br>
<br>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>