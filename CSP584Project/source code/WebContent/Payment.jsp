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

<!-- Our team -->
<div class="team-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 team">
                <h2>Congratulations!</h2>
            </div>
        </div>
        <div class="row">
            <%
                String serviceDate = null;
                String serviceTime = null;
                Integer orderId = (Integer) request.getAttribute("orderId");
                String username = (String) session.getAttribute("username");
                HashMap<String, ArrayList<ServiceOrderItem>> serviceOrders = (HashMap<String, ArrayList<ServiceOrderItem>>)session.getAttribute("serviceOrder");
                for (ServiceOrderItem od : serviceOrders.get(username))
                    if (od.getOrderId()==orderId){
                        serviceDate = od.getDate();
                        serviceTime = od.getTime();
                    }
            %>
            <p>Your request has been submitted!</p>
            <p>Your Service No is <%=orderId %></p>
            <p>Thank You for choosing HomeHub. We will come on <%=serviceDate %> to help you.</p>
        </div>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>

