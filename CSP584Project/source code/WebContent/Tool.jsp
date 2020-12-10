<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="Bean.Product" %>
<%@ page import="java.util.ArrayList" %>

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
                <h2>Tools</h2>
                <p> We sell tools for you to get your hands dirty</p>
            </div>
        </div>
        <div class="loop-wrap">

            <div class="loop-images-container">
                <%
                    ArrayList<Product> Productslsit = (ArrayList<Product>) session.getAttribute("product");
                    for (int i = 0; i < 5; i++) {
                %>
                <a href="#<%=Productslsit.get(i).getProductId()%>">
                    <img src="assets/img/tools/<%=Productslsit.get(i).getProductImage() %>" height="400" width="600"
                         alt="" class="loop-image">
                </a>
                <%
                    }
                %>
            </div>
        </div>
        <%
            for (int j = 0; j < 5; j++) {%>
        <div class="team-box">
            <a name="<%=Productslsit.get(j).getProductId() %>" style="position: relative;top: -400px;"></a>

            <div class="team-box-photo"><img src="assets/img/newProduct.jpg" alt=""
                                             data-at2x="assets/img/<%=Productslsit.get(j).getProductImage() %>"></div>
            <div class="team-box-newoproduct"><img src="assets/img/tools/<%=Productslsit.get(j).getProductImage() %>">
            </div>
            <div class="team-box-text">
                <h3><%=Productslsit.get(j).getProductName() %>
                </h3>
                <h4><%=Productslsit.get(j).getProductPrice() %>
                </h4>
                <p><%=Productslsit.get(j).getProductDescribe() %>
                </p>
                <br>
                <form method='post' action='Cart'>
                    <input type=hidden name="productID" value="<%=Productslsit.get(j).getProductId() %>">
                    <input type=hidden name="productName" value="<%=Productslsit.get(j).getProductName() %>">
                    <input type=hidden name="productPrice" value="<%=Productslsit.get(j).getProductPrice() %>">
                    <input type="submit" value="Add To Cart" class="button-2" style="border-style:none"/>
                </form>
            </div>
        </div>
        <%
            }
        %>

        <%
            ArrayList<Product> allProducts = (ArrayList<Product>) session.getAttribute("allProducts");
            for (Product product : allProducts) {
                if ("Old".equalsIgnoreCase(product.getProductStatus())) {


        %>


        <div class="box">
            <div class="team-box-photo"><img src="assets/img/tools/<%=product.getProductImage()%>" alt=""
                                             data-at2x="assets/img/<%=product.getProductImage()%>"></div>
            <div class="team-box-text">
                <h3><%=product.getProductName()%>
                </h3>
                <h4>$ <%=product.getProductPrice()%>
                </h4>
                <p><%=product.getProductDescribe()%>
                </p>
                <br>
                <form method='post' action='Cart'>
                    <input type=hidden name="productID" value="<%=product.getProductId()%>">
                    <input type=hidden name="productName" value="<%=product.getProductName()%>">
                    <input type=hidden name="productPrice" value="<%=product.getProductPrice()%>">
                    <input type=hidden name="productType" value="tool">
                    <input type="submit" value="Add To Cart" class="button-2" style="border-style:none"/>
                </form>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
