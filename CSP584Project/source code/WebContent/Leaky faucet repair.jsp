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
                        <h2>Leaky Faucet Repair</h2>
                        <p>According to the EPA, the average family wastes 180 gallons of water a year from household
                            leaks. A leaking faucet isn’t just annoying—over time, a small leak increases your water
                            bill and can do considerable damage to your home. Broken knobs or handles on faucets are
                            also a nuisance that shouldn’t be ignored.</p>

                        <h4>How to Detect a Faucet Leak?
                        </h4>
                        <p>Not all faucet leaks are obvious. Use your water meter to determine if your household has a
                            leak. Take a reading from your water meter, don’t use any water for several hours, and take
                            another reading. Hopefully the meter didn’t move, if it did it means you have a leak!
                        </p>
                        <br>
                        <p>The experts at Humehub will come out to your home, determine where the leak is, disassemble
                            the faucet, supply any needed replacement parts, and reassemble your faucet.</p>


                    </div>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h4>Types of Faucets We Repair</h4>
                        <p>No matter what kind of faucet you have or where your problem faucet is located, we have the
                            experience and expertise to fix it. We can repair:</p>
                        <p>-- Kitchen faucets</p>
                        <p>-- Bathroom faucets</p>
                        <p>-- Touch on/off faucets</p>
                        <p>-- Utility sink faucets</p>


                        <br>

                    </div>
                    <p class="button-2">Price: 99$/h
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
                        <input type=hidden name="productID" value="16">
                        <input type=hidden name="productName" value="Leaky faucet repair">
                        <input type=hidden name="productPrice" value="99">
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