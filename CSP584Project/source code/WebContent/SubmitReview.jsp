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

        <div id='content'>
            <div class='entry'>
                <div class="row">
                    <%
                        String message = (String) request.getAttribute("msg");
                        String productName= (String) request.getAttribute("productName");
                        if (message.equals("Successful")) {%>

                    <h2>Congratulations!</h2>
                    <h2>Review for <%=productName%> Stored ! </h2>
                    <%} else {%>
                    <h2>Mongo Db is not up and running </h2>
                    <%}%>
                </div>
            </div>
            <div class='post'><h2 class='title meta'>
                <a style='font-size: 24px;' href="WriteReview?name=viewReview">View My Review</a>
            </h2>
        </div>
    </div>
</div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>

