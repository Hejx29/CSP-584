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
                        <h2>electric wiring repair</h2>
                        <br>
                        <p>As our suite of electrical devices expands, the infrastructure of our home needs to keep up.
                            Part of expanding and upgrading your electrical infrastructure is updating your home's
                            wiring and circuitry. Is your home prepared for the growing demand you're putting on your
                            wires, breakers, and outlets?</p>
                        <br>
                        <p>If you're not sure, then you need to call HomeHub to inspect your wiring to make sure your
                            electrical system is meeting your needs safely. Our technicians are all highly skilled and
                            equipped to repair, upgrade, or replace your home's wiring, including rewiring and whole
                            house rewiring.</p>
                        <br>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h4>Our team can work on all kinds of wiring projects, including those involving:</h4>
                        <p>-- Aluminum Wire Removal</p>
                        <p>-- Residential Electrical Rewiring</p>
                        <p>-- Electrical Panel Upgrades</p>
                        <p>-- Circuit Tracing Service</p>
                        <br>

                    </div>
                    <p class="button-2">Price: 75$/h
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
                        <input type=hidden name="productID" value="12">
                        <input type=hidden name="productName" value="Electric Wiring Repair">
                        <input type=hidden name="productPrice" value="75">
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