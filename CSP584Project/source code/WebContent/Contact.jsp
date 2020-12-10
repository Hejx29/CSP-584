<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<jsp:include page="header.jsp"/>


<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>

<!-- Contact us -->
<div class="contact-us-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 contact-us">
                <h2>Contact us</h2>
                <p>Contact us if you have any questions</p>
            </div>
            <br>
            <span class="errorMsg">
                        ${requestScope.contactMsg}
                    </span>
        </div>
        <div class="row">
            <div class="col-sm-12 contact-us-form">
                <form action="Contact" method="post">
                    <div class="contact-us-form-left">
                        <div class="contact-us-input-container">
                            <label for="contact-us-name" class="contact-us-name-label"></label>
                            <input type="text" id="contact-us-name" name="Customername" placeholder="Name...">
                        </div>
                        <div class="contact-us-input-container">
                            <label for="contact-us-email" class="contact-us-email-label"></label>
                            <input type="text" id="contact-us-email" name="Customeremail" placeholder="Email...">
                        </div>
                        <div class="contact-us-input-container">
                            <label for="contact-us-phone" class="contact-us-phone-label"></label>
                            <input type="text" id="contact-us-phone" name="Customerphone" placeholder="Phone...">
                        </div>
                    </div>
                    <div class="contact-us-form-right">
                        <div class="contact-us-input-container">
                            <label for="contact-us-message" class="contact-us-message-label"></label>
                            <textarea id="contact-us-message" name="Customermessage"
                                      placeholder="Message..."></textarea>
                        </div>
                        <input type="submit" value="Send message">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>