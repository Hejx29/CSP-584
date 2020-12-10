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
                        <h2>Clogged Showers and Bathtubs</h2>
                        <p>What are the signs of a clogged shower or tub?</p>
                        <p>Water rising slowly toward your ankles as you shower or overflowing as you bathe.
                        </p>
                        <p>Flood conditions in your bathroom.
                        </p>
                        <p>A slow-to-drain tub or shower.
                        </p>
                        <p>Strange gurgling or “strangled” noises coming from the tub or shower drain.
                        </p>
                        <p>An unpleasant odor coming from the drains.
                        </p>
                        <p>A pool of water around the drain when it hasn’t been used in hours.</p>
                        <br>
                        <br>
                        <br>
                    </div>
                </div>

            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>tub drain repair</h2>
                        <p>Unclogging a tub drain can take more than just basic DIY methods. Often, clearing a clogged
                            tub involves extensive work, specialty equipment, and training that ensure the job gets done
                            right. That’s what you’ll find with the Homehub, and we provide expert solutions that
                            includes 24/7 emergency service, sewer rodding, pipe cleaning, and a lifetime repair
                            guarantee to protect your investment.</p>

                        <br>

                    </div>
                    <p class="button-2">Price: 70$/h
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
                        <input type=hidden name="productID" value="70">
                        <input type=hidden name="productName" value="Tub Drain Repair">
                        <input type=hidden name="productPrice" value="70">
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