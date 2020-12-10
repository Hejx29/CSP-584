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
                        <h2>water heater repair </h2>
                        <h4>Water Heater Warning Signs
                        </h4>

                        <p>-- A sudden spike in your utility bills. If your water heater suddenly has to work harder to
                            get the job done, it may be a sign that repairs are necessary.
                        </p>
                        <p>
                            -- A leaking or rusted tank. Your water heater should be inspected regularly for physical
                            signs of damage. Look for water pooling around the floor and/or corrosion on the unit
                            itself.
                        </p>
                        <p>-- Poor water quality. An aging heater may be the culprit behind rust-colored, foul smelling
                            water coming out of the tap.</p>
                        <p>
                        </p>
                        -- Noisy operation. Cracks, pops and other odd noises can indicate scale buildup on your unit’s
                        heating elements.
                        <br>


                    </div>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <p>Homehub can diagnose and repair all types of water heater problems on several types of
                            systems. We’re the team you can always count on for flawless repairs and effective,
                            efficient plumbing solutions!</p>


                        <br>

                    </div>
                    <p class="button-2">Price: 45$/h
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
                        <input type=hidden name="productID" value="17">
                        <input type=hidden name="productName" value="Water heater repair ">
                        <input type=hidden name="productPrice" value="45">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" style="border-style:none" class="button-2"/>

                    </form>
                    <br>
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