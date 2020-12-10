<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="header.jsp"/>


<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>

<!-- Our team -->
<div class="team-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 team">
                <h2>Get a quote</h2>
            </div>
        </div>
        <div class="row">
        </div>
        <%
            if (session.getAttribute("username") == null) {
                request.setAttribute("msg", "Please login first!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>
        <form method='post' action='ServiceOrder'>
            <%
                String productName = request.getParameter("productName");
                double price = Double.parseDouble(request.getParameter("productPrice"));
                int hours = Integer.parseInt(request.getParameter("serviceHours"));
                double total = price * hours;
            %>
            <h2>Home Information</h2>
            <div class="form-group">
                <label>ServiceName</label>
                <input type='text' name='serviceName' value='<%=productName %>' class="form-control" readonly="true">
            </div>
            <div class="form-group">
                <label>Describe details</label>
                <input type='text' name='detail' value='' class="form-control"
                       style="height:100px;">
            </div>
            
            <div class="form-group">
                <label>Select date</label>
                <input type='date' name='serviceDate' class="form-control">
            </div>
            <div class="form-group">
                <label>Select time</label>
                <input type='time' name='serviceTime' class="form-control">
            </div>

            <br>
            <h2>Contact Information</h2>
            <div class="form-group">
                <label>First Name</label>
                <input type='text' name='firstName' class="form-control">
            </div>
            <div class="form-group">
                <label>Last Name</label>
                <input type='text' name='lastName' class="form-control">
            </div>
            <div class="form-group">
                <label>Phone Number</label>
                <input type='text' name='phone' class="form-control">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type='text' name='email' class="form-control">
            </div>
            <div class="form-group">
                <label>Zip Code</label>
                <input type='text' name='zipCode' class="form-control">
            </div>
            <div class="form-group">
                <label>Street</label>
                <input type='text' name='street' class="form-control">
            </div>
            <div class="form-group">
                <label>City</label>
                <input type='text' name='city' class="form-control">
            </div>
            <div class="form-group">
                <label>State</label>
                <input type='text' name='state' class="form-control">
            </div>

            <br>
            <h2>Payment Information</h2>
            <div class="form-group">
                <label>Total hours</label>
                <input type='text' name='hour' value='<%=hours %>h' class="form-control" readonly="true">
            </div>
            <div class="form-group">
                <label>Total price</label>
                <input type='text' name='price' value='<%=total %>$' class="form-control" readonly="true">
            </div>
            <div class="form-group">
                <label>CreditNo</label>
                <input type='text' name='creditNo' class="form-control">
            </div>


            <input type="submit" name="bookService" value="Book" class="button-2" style="border-style:none"/>
            <input type=hidden name="productName" value="<%=productName %>">
            <%
                String productID = request.getParameter("productID");
            %>
            <input type=hidden name="productID" value=<%=productID %>>
        </form>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
