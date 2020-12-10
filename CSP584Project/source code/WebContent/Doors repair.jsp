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
                        <h2>Doors repair</h2>
                        <p>Doors receive a lot of wear and tear throughout their life, and many homeowners have older
                            homes with older doors that are important to the style of the home. If you do not want to
                            replace an ailing door, then repair is almost always an option. With one call, you can have
                            an insured and qualified professional to tackle the job quickly, whether it be entry door
                            repair or work on interior doors. For sticking, dents, squeaking, air leaks, damaged door
                            jambs, rotting/soft wood, broken locks, screen repairs, roller issues on pocket or sliding
                            doors, whatever the issue, you will get the door repair service you need.</p>
                        <br>
                        <p>Did you know having an improperly installed door can raise heating and cooling costs? The
                            truth is poor door installation can cause the doors to not be sealed correctly, which can
                            cause air infiltration. If, for example, there is a gap between the ground and an exterior
                            door, air can escape or enter your home. On the other hand, if a storm door is not properly
                            installed, your home will not receive the protection that you need. </p>

                    </div>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h4>For expert door repair service, call the professionals at HomeHub.</h4>
                        <p>-- Sticking Doors</p>
                        <p>-- Squeaking Doors</p>
                        <p>-- Air Leaks</p>
                        <p>-- Damaged Door Jambs</p>
                        <p>-- Rotting / Soft Wood</p>
                        <p>-- Broken Door Locks</p>
                        <br>
                        <br>

                    </div>
                    <p class="button-2">Price: 140$/h
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
                        <input type=hidden name="productID" value="18">
                        <input type=hidden name="productName" value="Doors Repair">
                        <input type=hidden name="productPrice" value="140">
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