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
                <form onsubmit="return validate(event)" method="post">
                    <input type="hidden" id="type" name="type" value="student">
                    <h3 style="color:red;" id="wrondValidate"></h3>
                    <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="user name">
                    <input type="text" id="name" class="fadeIn second" name="name" placeholder="name">
                    <input type="email" id="email" class="fadeIn second" name="email" placeholder="email">
                    <input type="text" id="phoneNumber" class="fadeIn second" name="phoneNumber" placeholder="phone number">
                    <center>
                        <div class="g-recaptcha"
                             data-sitekey="6LfVWxgaAAAAACSOibK-ELPpcIc49WKLnt2XYn0y"></div>
                    </center>

                    <input type="submit" class="fadeIn fourth" value="Sign Up">
                </form>


            </div>
        </div>
        <script>
            function validate(e) {
                e.preventDefault();
                var xhttp;
                let userName = document.getElementById("userName").value;
                let name = document.getElementById("name").value;
                let email = document.getElementById("email").value;
                let phoneNumber = document.getElementById("phoneNumber").value;
                var captcha=document.getElementById("g-recaptcha-response").value;
                let type=document.getElementById("type").value;
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        if(this.responseText=="wrong captcha"){
                            alert("You are robot!");
                            location.replace("SignUp.jsp");
                        }
                        else if(this.responseText=="go to login"){
                            alert("signed up successfully");
                            location.replace("index.html");
                        }
                        else{
                            document.getElementById("wrondValidate").innerHTML = this.responseText;
                        }
                        
                        
                    }
                };
                xhttp.open("GET", "SignUpServlet?userName=" + userName +"&name=" + name + "&email=" + email + "&phoneNumber=" + phoneNumber+"&g-recaptcha-response="+captcha+"&type="+type, true);
                xhttp.send();
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