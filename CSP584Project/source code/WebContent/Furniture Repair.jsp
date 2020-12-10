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
                        <h2>Wood furniture repair</h2>
                        <p>One of the common materials for furnitre manufacturing is wood. Sofas, chairs, bed frames or
                            any other type of furniture can loose structural stability or even brake apart because of
                            the damaged wooden parts. On time repairs can save the furniture from more comlicated
                            restorations and save the money.</p>
                        <p><br></p>


                    </div>
                    <p class="button-2">Price: 69$/h
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
                        <input type=hidden name="productID" value="19">
                        <input type=hidden name="productName" value="Wood Furniture Repair">
                        <input type=hidden name="productPrice" value="69">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2" style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>Leather repair & restoration</h2>
                        <p>We offer a full service of leather repair from the small scratch, rip or tear to complete
                            leather restorations. Also we do leather cleaning, protection and rejuvenation of leather
                            upholstery.By the end of the process you will get refreshed and renewed furniture piece that
                            will last for years.</p>
                        <br>


                    </div>
                    <p class="button-2">Price: 130$/h
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
                        <input type=hidden name="productID" value="20">
                        <input type=hidden name="productName" value="Leather Repair">
                        <input type=hidden name="productPrice" value="130">
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