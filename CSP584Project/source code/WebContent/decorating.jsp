<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<jsp:include page="header.jsp"/>


<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>
<div class=".product-container ">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>Mini decorating</h2>
                        <p>Get design inspiration and custom solutions to spice up your space or refresh a room.</p>
                        <p>--Choose your personal Designer</p>
                        <p>--1:1 time your designer via online messaging or phone calls</p>
                        <p>--3 initial ideas to help capture your style, delivered within 2 days</p>
                        <p>--A final design concept with curated design picks and a shopping list</p>
                        <p>--Multiple design revisions until it’s perfect</p>
                        <p>--Access to hundreds of brands and a personal ordering team</p>
                        <p><br></p>
                        <p><br></p>


                        <br>


                    </div>
                    <p class="button-2">Price: 34.5$/h
                    <p>
                        <br>
                    <form method='post' action='appointment.jsp'>
                        <div class="form-group">
                            <label>You need</label>
                            <select name="serviceHours" class="button-2">
                                <option value="1">1h</option>
                                <option value="2">2h</option>
                                <option value="3">3h</option>
                                <option value="4">4h</option>
                                <option value="5">5h</option>
                                <option value="6">6h</option>
                            </select>
                        </div>
                        <input type=hidden name="productID" value="6">
                        <input type=hidden name="productName" value="Mini Decorating">
                        <input type=hidden name="productPrice" value="38.5">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2" style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>Full decorating</h2>
                        <p>Collaborate with homehub to transform a blank canvas or redesign an entire room.</p>
                        <p>--Choose your personal Designer</p>
                        <p>--1:1 time your designer via online messaging or phone calls</p>
                        <p>--3 initial ideas to help capture your style, delivered within 2 days</p>
                        <p>--A final design concept with curated design picks and a shopping list</p>
                        <p>--Multiple design revisions until it’s perfect</p>
                        <p>--Access to hundreds of brands and a personal ordering team</p>
                        <p>--Layout visualizations so you don’t have to imagine the design</p>
                        <p>--Custom floor plan to take the guesswork out of layouts</p>
                        <br>


                    </div>
                    <p class="button-2">Price: 80$/h
                    <p>
                        <br>
                    <form method='post' action='appointment.jsp'>
                        <div class="form-group">
                            <label>You need</label>
                            <select name="serviceHours" class="button-2">
                                <option value="1">1h</option>
                                <option value="2">2h</option>
                                <option value="3">3h</option>
                                <option value="4">4h</option>
                                <option value="5">5h</option>
                                <option value="6">6h</option>
                            </select>
                        </div>
                        <input type=hidden name="productID" value="7">
                        <input type=hidden name="productName" value="Full Decorating">
                        <input type=hidden name="productPrice" value="80">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" style="border-style:none" class="button-2"/>
                    </form>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>