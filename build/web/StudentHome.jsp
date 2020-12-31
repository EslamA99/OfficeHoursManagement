<%-- 
    Document   : StudentHome
    Created on : Dec 29, 2020, 8:03:41 PM
    Author     : EEC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/HomePageCss.css" rel="stylesheet">
        <link href="CSS/HomeContent.css" rel="stylesheet">
    </head>
    <body>

        <div class="area">
            <center>
                <div id="formContent">                
                    <h1>Page Name</h1>

                    <!-- Login Form -->
                    <form action="StudentHome.jsp">
                        <input type="text" id="login" class="fadeIn second" name="login" placeholder="user name">
                        <input type="password" id="password" class="fadeIn third" name="login" placeholder="password">
                        <input type="submit" class="fadeIn fourth" value="Log In">
                    </form>


                </div>

            </center>
        </div>
        <nav class="main-menu">
            <ul>
                <li>
                    <a href="StudentHome.jsp">
                        <i class="fa fa-home fa-2x"></i>
                        <span class="nav-text">
                            Home
                        </span>
                    </a>

                </li>
                <li class="has-subnav">
                    <a href="StaffMembers.jsp">
                        <i class="fa fa-user fa-2x"></i>
                        <span class="nav-text">
                            Staff Members
                        </span>
                    </a>
                <li>
                    <a href="StudentProfile.jsp">
                        <i class="fa fa-info fa-2x"></i>
                        <span class="nav-text">
                            Profile
                        </span>
                    </a>
                </li>
                
                <li>
                    <a href="test.html">
                        <i class="fa fa-search fa-2x"></i>
                        <span class="nav-text">
                            test
                        </span>
                    </a>
                </li>
            </ul>

            <ul class="logout">
                <li>
                    <a href="#">
                        <i class="fa fa-power-off fa-2x"></i>
                        <span class="nav-text">
                            Logout
                        </span>
                    </a>
                </li>  
            </ul>
        </nav>
    </body>
</html>
