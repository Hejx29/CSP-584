<%@ page import="Bean.CartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="Bean.Product" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>


<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>
<br>

<%
    if (session.getAttribute("username") == null) {
        request.setAttribute("msg", "Please login first!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<%
    Map<Integer, CartItem> map = (Map<Integer, CartItem>) session.getAttribute("cart");
    String username = (String) session.getAttribute("username");
%>
<%if (map == null) {%>


<div id="emptycartindent">
    <h2 id="h2">Your cart is empty!</h2>

    <h3><a href="javascript:;" onClick="javascript:history.back(-1);">Go Shopping Now</a></h3>
</div>

<%} else {%>

<div id="indent">
    <table border="1px" width="960px" height="100px" style="margin-left:50px; position:relative">
        <tr id="tr1">
            <td>productName</td>
            <td>productPrice</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Operation</td>
        </tr>

        <%
            //1:将添加到购物车里面的物品显示出来
            //2:将购物车里面的内容遍历出来
            double count = 0;//显示出总价格
            for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
                //计算出每一样的书籍一共花了多少钱
                double price = entry.getValue().getProduct().getProductPrice() * entry.getValue().getNumber();
                //计算出一共花了多少钱
                count = count + price;
                count = (double) Math.round(count * 100) / 100;
        %>
        <tr id="tr2">
            <td>
                <%=entry.getValue().getProduct().getProductName()%>
            </td>
            <td>
                <font color="pink">

                    <%=entry.getValue().getProduct().getProductPrice() %>$
                </font>
            </td>
            <td>
                <%=entry.getValue().getNumber() %>
            </td>
            <td>
                <%=entry.getValue().getProduct().getProductPrice() * entry.getValue().getNumber()%>$
            </td>

            <td>
                <form method='post' action='ClearOrDeleteCart'>
                    <%
                        int productId = entry.getKey();
                    %>
                    <input type=hidden name="productID" value="<%=productId %>">
                    <input type='submit' name='Delete' value='Delete' class='btnbuy'/>
                </form>
            </td>
        </tr>
        <%} %>
        <tr id="tr2">
            <td colspan="3">Total</td>
            <td><%=count%>$
            </td>
            <td>
                <form method='post' action='ClearOrDeleteCart'>
                    <input type='submit' name='ClearCart' value='ClearCart' class='btnbuy'/>
                </form>
            </td>
        </tr>
    </table>

    <br>

    <div id="checkbutton">
        <ul class="nav navbar-nav ">
            <li><a data-toggle="modal" data-target="#register" href="" class="button-2"
                   style="border-style:none; margin-left:700px;">
                check out</a></li>
        </ul>
    </div>


    <!-- checkout -->
    <div id="register" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">check out</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="ToolOrder">
                        <h2>Payment Info</h2>
                        <tr>
                            <td><input type="hidden" name="price" value="<%=count%>"></td>
                        </tr>
                        <div class="form-group">
                            <label>Full Name</label>
                            <input class="form-control" type="text" name="fullName" required>
                        </div>
                        <div class="form-group">
                            <label>Phone</label>
                            <input class="form-control" type="text" name="phone" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input class="form-control" type="text" name="email" required>
                        </div>
                        <div class="form-group">
                            <label>Street</label>
                            <input class="form-control" type="text" name="streetAddress" required>
                        </div>
                        <div class="form-group">
                            <label>City</label>
                            <input class="form-control" type="text" name="city" required>
                        </div>
                        <div class="form-group">
                            <label>State</label>
                            <input class="form-control" type="text" name="state" required>
                        </div>
                        <div class="form-group">
                            <label>ZipCode</label>
                            <input class="form-control" type="text" name="zipCode" required>
                        </div>
                        <div class="form-group">
                            <label>Credit/AccountNo</label>
                            <input class="form-control" type="text" name="creditCardNo" required>
                        </div>
                        <div>
                            <label>Delivery Method: </label>
                            <input type='radio' name='deliveryMethod' value='pickup' onclick='displayPickup()'>
                            <label value='pickup'>Store Pickup</label>
                            <input type='radio' name='deliveryMethod' value='delivery' checked
                                   onclick='displayDelivery()'>
                            <label value='delivery'>Home Delivery</label>
                        </div>

                        <br>
                        <div class="form-group" id='pickupLocation' hidden='true'>
                            <label>Pickup Location</label>
                            <select name="pickuplocation" class="form-control">
                                <option value="">- select location -</option>
                                <option value="8331 S Stewart Ave" name="l1">8331 S
                                    Stewart Ave, Chicago, IL, 60620
                                </option>
                                <option value="10900 S Doty Ave" name="l1">10900 S Doty
                                    Ave, Chicago, IL, 60628
                                </option>
                                <option value="2844 N Broadway St" name="l1">2844 N
                                    Broadway St, Chicago, IL, 60657
                                </option>
                                <option value="500 Bayonne Crossing Way" name="l1">500
                                    Bayonne Crossing Way, Bayonne, NJ, 07002
                                </option>
                                <option value="2100 88th St" name="l1">2100 88th St,
                                    North Bergen, NJ, 07047
                                </option>
                                <option value="150 Harrison Ave" name="l1">150 Harrison
                                    Ave, Kearny, NJ, 07032
                                </option>
                                <option value="201 N Nellis Blvd" name="l1">201 N Nellis
                                    Blvd, Las Vegas, NV, 89110
                                </option>
                                <option value="400 Park Pl" name="l1">400 Park Pl,
                                    Secaucus, NJ, 07094
                                </option>
                                <option value="3705 E South St" name="l1">3705 E South
                                    St, Long Beach, CA, 90908
                                </option>
                                <option value="2770 Carson St" name="l1">2770 Carson St,
                                    Lakewood, CA, 90712
                                </option>
                            </select>
                        </div>

                        <br>
                        <div class="text-right">
                            <button class="button-2" type="submit">submit</button>
                            <button class="button-2" data-dismiss="modal" style="background-color: #843534">cancel
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%
    HashMap<String, String> prodRecmMap = (HashMap<String, String>) session.getAttribute("prodRecmMap");
    HashMap<String, Product> selectProduct = (HashMap<String, Product>) session.getAttribute("selectProduct");
    if (prodRecmMap == null) {%>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
<%
    }
    int l = 0;
    String myCarousel = null;
    for (String user : prodRecmMap.keySet()) {
        if (user.equals(username)) {
            String products = prodRecmMap.get(user);
            products = products.replace("[", "");
            products = products.replace("]", "");
            products = products.replace("\"", " ");
            ArrayList<String> productsList = new ArrayList<String>(Arrays.asList(products.split(",")));
            myCarousel = "myCarousel" + l;

%>
<div class="container">
    <br>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <h2>Recommended Products</h2>
        <hr/>
        <!-- Indicators -->
        <div class='carousel slide' id='<%=myCarousel%>' data-ride='carousel'>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">

                <%
                    int k = 0;
                    for (String prod : productsList) {
                        prod = prod.replace("'", "");
                        Product prodObj = new Product();
                        prodObj = selectProduct.get(prod.trim());
                        if (k == 0) {%>
                <div class="item active">
                    <%
                    } else {
                    %>
                    <div class="item">
                        <%}%>
                        <div class="box">
                            <img src="assets/img/tools/<%=prodObj.getProductImage()%>"
                                 alt="" width="460" height="345">
                            <div class="carousel-caption ">
                                <h3 style="color: #a6cac0"><%=prodObj.getProductName()%>
                                </h3>
                                <h4>$ <%=prodObj.getProductPrice()%>
                                </h4>
                                <p style="font-size: large"><%=prodObj.getProductDescribe()%>
                                </p>
                                <br>
                                <form method='post' action='Cart'>
                                    <input type=hidden name="productID" value="<%=prodObj.getProductId()%>">
                                    <input type=hidden name="productName" value="<%=prodObj.getProductName()%>">
                                    <input type=hidden name="productPrice" value="<%=prodObj.getProductPrice()%>">
                                    <input type=hidden name="productType" value="tool">
                                    <input type="submit" value="Add To Cart" class="button-2"
                                           style="border-style:none"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <%
                            k++;
                        }
                    %>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#<%=myCarousel%>" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#<%=myCarousel%>" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <%

                }
            }
        %>
    </div>
    <%}%>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>