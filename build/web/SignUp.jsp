<%-- 
    Document   : SignUp
    Created on : Dec 28, 2020, 5:25:50 PM
    Author     : EEC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="US-ASCII">
        <title>Login Page</title>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        <link href="CSS/SignCss.css" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">                
                <!-- Icon -->
                <div class="fadeIn first">
                    <img src="bussiness-man.svg" id="icon" alt="User Icobn" />
                </div>

                <!-- Login Form -->
                <form action="SignUpServlet"  onsubmit="return validate()" method="post">
                    <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="user name">
                    <input type="text" id="name" class="fadeIn second" name="name" placeholder="name">
                    <input type="email" id="email" class="fadeIn second" name="email" placeholder="email">
                    <input type="text" id="phone" class="fadeIn second" name="phoneNumber" placeholder="phone number">
                    <center>
                        <div class="g-recaptcha"
                             data-sitekey="6LfVWxgaAAAAACSOibK-ELPpcIc49WKLnt2XYn0y"></div>
                    </center>

                    <input type="submit" class="fadeIn fourth" value="Sign Up">
                </form>


            </div>
        </div>
        <script>
            function validate() {
                
                let userName = document.getElementById("userName").value;
                if (userName == "") {
                    alert("user name can't be empty");
                    return false;
                }
                
                let name = document.getElementById("name").value;
                if (name == "") {
                    alert("name can't be empty");
                    return false;
                }
                
                let email = document.getElementById("email").value;
                if (email == "") {
                    alert("email can't be empty");
                    return false;
                }
                
                let phone = document.getElementById("phone").value;
                if (phone == "") {
                    alert("phone can't be empty");
                    return false;
                }
                
                return true;
            }

        </script>
    </body>
</html>
<!--
        <form action="SignUpServlet" method="post">
            Username: <input type="text" name="user"> <br>
            Password:<input type="password" name="pwd"> <br>
            <div class="g-recaptcha"
                 data-sitekey="6LfVWxgaAAAAACSOibK-ELPpcIc49WKLnt2XYn0y"></div>
            <br> <input type="submit" value="Login">
        </form>
-->