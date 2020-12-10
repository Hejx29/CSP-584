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
                        <h2>Light Fixture Installation</h2>
                        <p>If you're looking for safe, reliable and professional light fixture installation help,
                            HomeHub can connect you with the right electrician for you. Whether you're a busy
                            professional or a busy parent (or both!), finding the time to rewire your lighting can be
                            near-impossible. And if you've no experience with electrical wiring, it can be potentially
                            dangerous. Homehub connects you with local electrical service providers with the knowledge
                            and the expertise necessary to install your lighting, quickly and efficiently. </p>
                        <br>
                        <br>
                    </div>
                    <p class="button-2">Price: 35$/h
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
                        <input type=hidden name="productID" value="13">
                        <input type=hidden name="productName" value="Light Fixture Installation">
                        <input type=hidden name="productPrice" value="35">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2" style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>Outlet Installation</h2>
                        <p>Our professional handymen are experts at repairing and replacing existing outlets/sockets and
                            light switches. Whether it's an outlet or a dimmer light switch, we have you covered. Every
                            handyman is vetted and will arrive prepared with the proper tools and supplies to get your
                            job done right the first time</p>
                        <p>--Vetted and background-checked professionals</p>
                        <p>--Friendly 24/7 customer service</p>
                        <p>--Affordable pricing</p>
                        <br>

                        <br>
                    </div>
                    <p class="button-2">Price: 50$/h
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
                        <input type=hidden name="productID" value="14">
                        <input type=hidden name="productName" value="Outlet Installation">
                        <input type=hidden name="productPrice" value="50">
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