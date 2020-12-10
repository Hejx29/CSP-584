%@ page import="Bean.Profile" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>

<!-- Portfolio -->
<div class="portfolio-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 portfolio">
                <h2>Create User Profile</h2>
            </div>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
            <form action="UserProfile?name=createProfile" method="post">
                <table border="1" cellpadding="3" cellspacing="0" style="width: 50%;margin:auto">
                    <%
                    String username = (String)session.getAttribute("username");
                    String usertype = (String)session.getAttribute("userType");
                    %>

                    <tr><td><label>Username</label></td>
                        <td><input type='text' value="<%=username%>" readonly="true"></td></tr>

                    <tr><td><label>User Type</label></td>
                        <td><input type='text' value="<%=usertype%>" readonly="true"></td></tr>


                    <tr><td><label>Phone Number</label></td>
                        <td><input type='text' name='phone'></td></tr>


                    <tr><td><label>Email</label></td>
                        <td><input type='text' name='email'></td></tr>


                    <tr><td><label>Street</label></td>
                        <td><input type='text' name='street'></td></tr>


                    <tr><td><label>City</label></td>
                        <td><input type='text' name='city'></td></tr>


                    <tr><td><label>State</label></td>
                        <td><input type='text' name='state'></td></tr>

                    <tr><td><label>Zip Code</label></td>
                        <td><input type='text' name='zipCode'></td></tr>

                </table>
                <br>
                <br>
                <input type="submit" value="Create" class="button-2" style="border-style:none"/>
            </form>

        </div>
    </div>
</div>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>

</html>