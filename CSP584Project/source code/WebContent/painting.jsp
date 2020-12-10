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
                        <h2>interior painting</h2>
                        <p>Our interior painter contractors specialize in staining, painting, wall repair, ceiling
                            repair, and wallpaper removal. Preparation is key in all painting projects. Our painters
                            will cover carpets, remove wall hangings and move and cover furniture. We work with you to
                            decide what types of paints and colors meet your decorating needs. Additionally, after each
                            painting project is completed we place everything back in its original location.</p>
                        <br>
                        <br>
                    </div>
                    <p class="button-2">Price: 25$/h
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
                        <input type=hidden name="productID" value="3">
                        <input type=hidden name="productName" value="Interior Painting">
                        <input type=hidden name="productPrice" value="25">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2" style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>Exterior Painting</h2>
                        <p>All loose paint and defective caulking should then be removed. Any rotted boards should be
                            replaced, and all new and bare wood primed. Gaps between adjoining wood, or wood and
                            masonry, should be caulked with a powerful sealant. Hardware and light fixtures which are
                            not to be painted should be removed or properly protected, and all plants should be moved or
                            covered.</p>
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
                        <input type=hidden name="productID" value="4">
                        <input type=hidden name="productName" value="Exterior Painting">
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