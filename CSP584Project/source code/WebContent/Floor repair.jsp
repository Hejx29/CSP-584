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
                        <h2>WOOD FLOOR INSTALLATION & REPAIRS</h2>
                        <p>Wood floors are a stunning option for any home. They also have a whole host of benefits:</p>
                        <p>-- Wood floors can promote better indoor air quality.</p>
                        <p>-- Wood flooring can store carbon during its service life.</p>
                        <p>-- Wood floors use less water and energy to produce.</p>
                        <p>-- Wood flooring can be burned or recycled at the end of its life.</p>
                        <p>-- Wood floors are durable and can last for hundreds of years.</p>
                        <p>Although durable, wood floorboards are not invincible. They can be damaged by pets, water,
                            kids, the moving of furniture, and more. That, however, does not mean you need to replace
                            them entirely. Just call our experienced home repair professionals and let us perform some
                            quick repairs! We can get your flooring looking beautiful again in no time—and we guarantee
                            that you will be satisfied with our workmanship.</p>
                        <br>

                    </div>
                    <p class="button-2">Price: 300$/h
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
                        <input type=hidden name="productID" value="21">
                        <input type=hidden name="productName" value="Wood furniture repair">
                        <input type=hidden name="productPrice" value="300">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2" style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>LAMINATE FLOOR INSTALLATION & REPAIRS</h2>
                        <p>Just a few benefits of laminate floors:</p>
                        <p>-- laminate floors can take a lot of impact.</p>
                        <p>-- laminate floors are durable and long-lasting.</p>
                        <p>-- laminate floors are cheaper and easier to install.</p>
                        <p>-- laminate floors are resistant to stains and water.</p>
                        <p>-- There is a wide array of designs to match your tastes.</p>
                        <p>-- There is little waste since there are no defects.</p>

                        <p>Stop worrying about your floors! Instead of adding repairs to your to-do list, add it to
                            ours. Just give us a call, and we will show up to your home on time, with the required
                            tools, and fix any issues you may have with efficient work. We are trustworthy, experienced,
                            and guarantee the job will be done right the first time.</p>
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
                        <input type=hidden name="productID" value="22">
                        <input type=hidden name="productName" value="Laminate floor repair">
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