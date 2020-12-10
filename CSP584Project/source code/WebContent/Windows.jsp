<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<jsp:include page="header.jsp"/>

<

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
                        <h2>Window Tinting Benefits</h2>
                        <br>
                        <h3>Protection from fading</h3>
                        <p>The sun's ultraviolet rays can wreak havoc on interior furnishings and merchandise by fading
                            and shortening their shelf life. Window films screen out the sun's harmful UV rays, they
                            greatly reduce fading of furniture, carpeting and artwork.</p>
                        <br>
                        <h3>Reduced glare</h3>
                        <p>Glare causes eye fatigue and lower productivity. Drawing curtains or closing blinds is a
                            claustrophobic approach at best, and it drives up the bill for artificial lighting. Window
                            films let in the light but not the glare, and help maintain an "open" feeling.</p>
                        <br>
                        <h3>Big energy savings</h3>
                        <p>Watch the numbers drop on those HVAC costs with Window films. A reflective window film can
                            keep out as much as 80% of the sun's heat, and dramatically lower air conditioning costs. In
                            the winter, the same window film helps retain interior heat, and reduces heating costs.</p>
                        <br>
                        <h3>Increased safety</h3>
                        <p>Splintered, flying glass is one of the dangerous consequences of disasters, whether natural
                            or man-made. Madico residential window film is specifically designed to help hold broken
                            glass in place and lessen the chance of injury and property damage.</p>
                        <br>
                    </div>

                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">

                        <p>There are many different window tint level options. The window tint level right for your home
                            will depend on several factors including where you live, which direction your windows face,
                            and your personal preferences for light blocked. Our local professionals can help you select
                            the one that works best for you and your home.</p>
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
                        <input type=hidden name="productID" value="5">
                        <input type=hidden name="productName" value="Windows Tinting">
                        <input type=hidden name="productPrice" value="35">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2"
                               style="border-style:none"/>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>
</body>

<jsp:include page="footer.jsp"/>
</html>
