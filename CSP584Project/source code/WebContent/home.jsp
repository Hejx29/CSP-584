<%@ page import="java.util.HashMap" %>
<%@ page import="Bean.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 top-content-text">
                    <h1>
                        Home Hub - Your Home Assistant<br>
                        <span class="top-content-text-big">Simply make your home more comfortable to live in.</span>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 top-content-computer">
                    <div class="top-content-computer-container">
                        <img src="assets/img/home.png" alt="">
                        <div class="top-content-video">

                            <!-- <iframe src="//player.vimeo.com/video/84910153?title=0&amp;byline=0&amp;portrait=0&amp;badge=0&amp;api=1" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> -->
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                
                    <form method='post' action="map.jsp">
                        <input type='text' name="keywords" class="custom-select" placeholder="cleaning near me">
                        <input type="submit" value="See the works" class="button-2"/>
<%--                        <a class="button-2" href=" ">See the works</a >--%>
                    </form>
             
            </div>
        </div>
        <div class='post'>
            <hr/>
            <%
                HashMap<String, Product> selectedproducts = new HashMap<String, Product>();
                String line = null;
                String TOMCAT_HOME = System.getProperty("catalina.home");
                HashMap<String, Product> productmap = (HashMap<String, Product>) request.getAttribute("products");
                for (Map.Entry<String, Product> entry : productmap.entrySet()) {

                    if (selectedproducts.size() < 2 && !selectedproducts.containsKey(entry.getKey())) {


                        BufferedReader reader = new BufferedReader(new FileReader(new File(TOMCAT_HOME + "/webapps/DealMatches.txt")));
                        line = reader.readLine().toLowerCase();

                        if (line == null) {
            %>
            <h2 align='center'>No Offers Found</h2>
            <%
                break;
            } else {
                do {

                    if (line.contains(entry.getKey())) {%>

            <h2 style="color: whitesmoke"><%=line%>
            </h2>
            <br>
            <%
                                    selectedproducts.put(entry.getKey(), entry.getValue());
                                    break;
                                }

                            } while ((line = reader.readLine()) != null);
                        }
                    }
                }
                pageContext.setAttribute("selectedproducts", selectedproducts);
            %>
        </div>
    </div>
</div>


<div class="services-container">
    <div class="container">
        <div class="col-sm-12 top-content-text">
            <h1>
                <span class="top-content-text-big" style="color: #0b0b0b">Deal Matches</span>
            </h1>
            <%
                HashMap<String, Product> selectedproducts2 = (HashMap<String, Product>) pageContext.getAttribute("selectedproducts");
                if (selectedproducts2.size() == 0) {%>
            <h2 align='center'>No Deals Found</h2>
            <%} else {%>
            <div class="row">
                <%
                    for (Map.Entry<String, Product> entry : selectedproducts2.entrySet()) {%>
                <div class="col-sm-6">
                    <div class="team-box">
                        <div class="team-box-photo"><img src="assets/img/tools/<%=entry.getValue().getProductImage()%>"
                                                         alt=""
                                                         data-at2x="assets/img/<%=entry.getValue().getProductImage()%>">
                        </div>
                        <div class="team-box-text">
                            <h3><%=entry.getKey()%>
                            </h3>
                            <h4>$ <%=entry.getValue().getProductPrice()%>
                            </h4>
                            <p><%=entry.getValue().getProductDescribe()%>
                            </p>
                            <br>
                            <form method='post' action='Cart'>
                                <input type=hidden name="productID" value="<%=entry.getValue().getProductId()%>">
                                <input type=hidden name="productName" value="<%=entry.getKey()%>">
                                <input type=hidden name="productPrice" value="<%=entry.getValue().getProductPrice()%>">
                                <input type=hidden name="productType" value="tool">
                                <input type="submit" value="Add To Cart" class="button-2" style="border-style:none"/>
                            </form>
                        </div>
                    </div>
                </div>
                <% }
                %>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>