<%@ page import="Bean.Profile" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>

<!-- Top content -->
<div class="top-content-container">
    <div class="inner-bg">
    </div>
</div>

<%
    String username = (String) session.getAttribute("username");
    String usertype = (String) session.getAttribute("userType");
    Profile profile = (Profile) session.getAttribute("profile");
%>
<%
    if (profile == null) {
%>
<!-- Portfolio -->
<div class="portfolio-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 portfolio">
                <h2>User Profile</h2>
            </div>
            <div id="emptycartindent">
                <h2 id="h2">You have not created your own profile, <a
                        href="createProfile.jsp">create</a> now!</h2>
            </div>

        </div>
    </div>
</div>
<%} else {%>
<!-- Portfolio -->
<div class="portfolio-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 portfolio">
                <h2>User Profile</h2>
            </div>
            <span class="errorMsg">
                ${requestScope.msg}
            </span>
            <div style="color: #0b0b0b">
                <table border="1" cellpadding="3" cellspacing="0" style="width: 100%;margin:auto">
                    <tr style="font-size: large">
                        <td>Username</td>
                        <td>User Type</td>
                        <td>Street</td>
                        <td>City</td>
                        <td>State</td>
                        <td>Zip Code</td>
                        <td>Phone</td>
                        <td>Email</td>
                        <td colspan="2"><td>
                    </tr>
                    <tr>
                        <td><%=username%>
                        </td>
                        <td><%=usertype%>
                        </td>
                        <td><%=profile.getStreet()%>
                        </td>
                        <td><%=profile.getCity()%>
                        </td>
                        <td><%=profile.getState()%>
                        </td>
                        <td><%=profile.getZipCode()%>
                        </td>
                        <td><%=profile.getPhone()%>
                        </td>
                        <td><%=profile.getEmail()%>
                        </td>
                        <td>
                            <form method='post' action='updateProfile.jsp'>
                                <input type='submit' name='updateProfile' value='Update' class='button-5'/>
                            </form>
                        </td>
                        <td>
                            <form method='post' action='UserProfile'>
                                <input type='submit' name='delete' value='delete' class='button-5'/>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


<%}%>
</body>

<!-- Footer -->
<jsp:include page="footer.jsp"/>

</html>

