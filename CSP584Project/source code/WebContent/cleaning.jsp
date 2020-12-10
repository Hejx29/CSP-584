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
                        <h2>STANDARD CLEANING</h2>
                        <p>This service is used for the maintenance of your property on a monthly, bi-weekly, weekly, or
                            daily cleanings.</p>
                        <p>As with all of our cleaning services, we use only biodegradable products that are
                            environmentally friendly and refrain from jeopardizing your health. Certain cleaning
                            products release harmful chemicals into your house which triggers a cycle of environmental
                            pollution. Not only do those products affect your living space, they contaminate our
                            planet.</p>
                        <br>
                        <p>At a high level, our Standard Cleaning service includes the following:</p>
                        <br>
                        <p>Kitchen:</p>
                        <p>- Clean outside and top of refrigerator</p>
                        <p>- Clean stove and hood</p>
                        <p>- Clean outside/inside of microwave</p>
                        <p>- Clean outside of dish washer</p>
                        <p>- Clean and disinfect countertops, back splash, sinks, and faucets</p>
                        <p>- Spot clean outside of cabinets</p>

                        <br>
                        <p> Bathrooms:</p>
                        <p>- Clean and disinfect tubs, showers, countertops, towel bars, sinks, faucets, toilets, and
                            floors</p>
                        <br>
                        <p>All rooms:</p>
                        <p>- Hand dust all horizontal surfaces</p>
                        <p>- Dust ceiling corners</p>
                        <p>- Vacuum carpet and rugs</p>
                        <p>- Dust light fixtures and disinfect switches</p>
                        <p>- Clean hard floors and mirrors</p>
                        <p>- Window washing (inside/outside)</p>
                        <br>
                        <br>
                        <br>
                    </div>
                    <p class="button-2">Price: 20$/h
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
                        <input type=hidden name="productID" value="1">
                        <input type=hidden name="productName" value="Standard Clean">
                        <input type=hidden name="productPrice" value="20">
                        <input type=hidden name="productType" value="Service">
                        <input type="submit" value="BOOK ONLINE" class="button-2"
                               style="border-style:none"/>

                    </form>

                </div>
            </div>
            <div class="col-sm-6">
                <div class="product-box">
                    <div class="product-box-text">
                        <h2>DEEP CLEANING</h2>
                        <p>Our deep cleaning service is typically for those who have either never had professional
                            cleaning done before, or who haven't had professional services within the past three
                            months</p>
                        <br>
                        <p>At a high level, Our Deep Cleaning service includes, but is not limited to, the following</p>
                        <p>Kitchen:</p>
                        <p>- Clean outside and top of refrigerator</p>
                        <p>- Clean stove and hood</p>
                        <p>- Clean outside/inside of microwave</p>
                        <p>- Clean outside of dish washer</p>
                        <p>- Clean and disinfect countertops, back splash, sinks, and faucets</p>
                        <p>- Spot clean outside of cabinets</p>
                        <p>- Polish sinks and faucets</p>
                        <br>
                        <p> Bathrooms:</p>
                        <p>- Clean and disinfect tubs, showers, countertops, towel bars, sinks, faucets, toilets, and
                            floors</p>
                        <p>- Clean shower doors (remove hard water spots extra charge), mirrors, and exterior of
                            vanities</p>
                        <p>- Polish sinks and faucets</p>
                        <br>
                        <p>Bedrooms:</p>
                        <p>- Make all beds</p>
                        <br>
                        <p>All rooms:</p>
                        <p>- Hand dust all horizontal surfaces</p>
                        <p>- Dust ceiling corners</p>
                        <p>- Vacuum carpet and rugs</p>
                        <p>- Dust light fixtures and disinfect switches</p>
                        <p>- Clean hard floors and mirrors</p>
                        <p>- Window washing (inside/outside)</p>
                        <br>
                    </div>
                    <p class="button-2">Price: 30$/h
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
                        <input type=hidden name="productID" value="2">
                        <input type=hidden name="productName" value="Deep Clean">
                        <input type=hidden name="productPrice" value="30">
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