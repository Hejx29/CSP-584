<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>

<jsp:include page="managerHeader.jsp" />
<link rel="stylesheet" type="text/css" href="assets/css/common.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
<link rel="stylesheet" href="assets/css/style.css">
<body onload="addUserName();">

<div class="top-content-container">
    <div class="inner-bg">
   	 <div class="manager-container">
   	         <!--/LeftNavigationBar-->
		    <jsp:include  page="LeftNavigationBar.jsp"/>
		    <!--/rightContent-->
		    <div id = rightcontent>
		     <div class = post>
		     <p class = homepagetitle>Welcome to HomeHub StoreManager Home</p>
		     <br>
		     </div>
		    </div>
		    <table border="1px" width="700px" height="80px" >
		    <img style="margin-left:35px" src="assets/img/manager.png" alt="">
		    </table>
    </div>
 </div>


</div>
</body>
<!-- Footer -->
<jsp:include page="footer.jsp"/>
</html>
