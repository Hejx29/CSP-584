
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HomeHub</title>
    <!-- CSS -->
    <link rel="stylesheet" href="assets/fonts/fonts.css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/select2.css">
    <link rel="stylesheet" href="assets/css/gray.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/buttons.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/media-queries.css">
    <link rel="stylesheet" href="assets/css/admin_login.css">
    <link rel="stylesheet" href="assets/css/cart.css">


    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">


    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script language="JavaScript">
    function addUserName() {
        var myName = "<%=session.getAttribute("username")%>";
        if (typeof (myName) != "undefined" && myName != null && myName != "null") {
            document.getElementById("loginBtn").innerText = "Hello," + myName;
            document.getElementById("loginBtn").href = "#"
            document.getElementById("logoutBtn").style.display = "inline-block";
        }
    }

    // function Show(){
    //     document.getElementById('shade').classList.remove('hide');
    //     document.getElementById('modal').classList.remove('hide');
    // }
    // function Hide(){
    //     document.getElementById('shade').classList.add('hide');
    //     document.getElementById('modal').classList.add('hide');
    // }

    function displayPickup() {
        document.getElementById('pickupLocation').hidden = false;
    }

    function displayDelivery() {
        document.getElementById('pickupLocation').hidden = true;
    }
</script>

<body onload="addUserName();init()">
<script type="text/javascript" src="javascript.js"></script>
<!-- Top menu -->
<nav>
    <div class="container">
        <div class="row">
            <div class="col-sm-2 nav-logo" style="height:0px;width:300px;left:-130px;">
            <img src="assets/img/logo.PNG" >
                <a href="">Services</a>
            </div>
            <div class="col-sm-10 nav-links" style="right:-130px;">
                <a class="scroll-link button-1 " href="Home">Home</a>
                <div class="dropdown">
                    <a class="scroll-link button-1" href="#">Account</a>
                    <div class="dropdown-content" style="text-align: center">
                        <a class="scroll-link button-3" href="UserProfile">User Profile</a>
                        <a class="scroll-link button-3" href="cart.jsp">Cart</a>
                        <a class="scroll-link button-3" href="ToolOrder?name=viewToolOrder">View Order</a>
                        <a class="scroll-link button-3" href="ServiceOrder?name=viewService">View Service</a>
                        <a class="scroll-link button-3" href="WriteReview?name=viewReview">View Review</a>
                    </div>
                </div>
                <a class="scroll-link button-1 " href="Trending">Trending</a>
                <a class="scroll-link button-1" href="Services.jsp">Services</a>
                <a class="scroll-link button-1" href="getProduct">Tools</a>
                <a class="scroll-link button-1" href="Reviews.jsp">Reviews</a>
                <a class="scroll-link button-1" href="Contact.jsp">Contact</a>
                <a id="loginBtn" class="scroll-link button-1" href="login.jsp">Login</a>
                <a id="logoutBtn" style="display: none" class="scroll-link button-1" href="Logout">Logout</a>
                <div class="show-menu"><span></span></div>
            </div>

            <div name="autofillform" style="width: 200px;margin-top: 8px;margin-right:20px;float:right;position: relative" >
                <input type='text' name='searchId' value='' class='input' id='searchId'
                       onkeyup='doCompletion()' placeholder='search here..' style='padding: 15px; font-size: 16px;'/>
                <div id='auto-row' style="position: absolute">
                    <table id='complete-table' class='gridtable' style='position: relative; width: 200px;'>
                    </table>
                </div>
            </div>
        </div>
    </div>
</nav>

