<%@ page import="Bean.ServiceOrderItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Product" %>
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
        <div class="col-sm-6">
            <div class="team-box">
                <%
                    Product data = (Product) request.getAttribute("data");
                %>
                <div class="team-box-photo"><img src="assets/img/tools/<%=data.getProductImage() %>" alt=""
                                                 data-at2x="assets/img/<%=data.getProductImage() %>"></div>
                <div class="team-box-text">
                    <h3><%=data.getProductName()%>
                    </h3>
                    <h4>$ <%=data.getProductPrice()%>
                    </h4>
                    <p><%=data.getProductDescribe()%>
                    </p>
                    <br>
                    <form method='post' action='Cart'>
                        <input type=hidden name="productID" value=<%=data.getProductId()%>>
                        <input type=hidden name="productName" value=<%=data.getProductName()%>>
                        <input type=hidden name="productPrice" value=$<%=data.getProductPrice()%>>
                        <input type=hidden name="productType" value="tool">
                        <input type="submit" value="Add To Cart" class="button-2" style="border-style:none"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>

