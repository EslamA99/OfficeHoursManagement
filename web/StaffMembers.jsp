<%-- 
    Document   : StaffMembers
    Created on : Dec 30, 2020, 11:41:27 PM
    Author     : EEC
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DAO.StaffDAO"%>
<%@page import="models.Staff"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
        <link href="CSS/TableDesignCss.css" rel="stylesheet">
        <link href="CSS/HomePageCss.css" rel="stylesheet">
        <!-- 
         <link href="CSS/HomeContent.css" rel="stylesheet">
        -->



        <link href="CSS/SearchBarCss.css" rel="stylesheet">
    </head>
    <body>

        <div class="area">

            <center>

                <div id="formContent"> 

                    <h1>Staff Member</h1>
                    <form>
                        
                        <div class="wrap">
                            <div class="search">
                                <input type="text" id="staffName" class="searchTerm" placeholder="Staff member name?">
                                <input type="submit" onkeyup="showStaff()" class="searchButton">
                            </div>
                        </div>
                    </form>


                    <div id="gradient"></div>


                    <center>
                        <table id="tableData">
                            <thead>
                                <tr>
                                    <th>Name
                                    <th>Email
                                    <th>Contact
                            </thead>
                            <tbody>
                                <%
                                    List<Staff> staffMembersList = StaffDAO.getAllstaff();
                                    for (Staff staff : staffMembersList) {%>
                                <tr>
                                    <td><%= staff.getName()%>

                                    <td><%= staff.getUser().getEmail()%>
                                    <td><%= staff.getPhone()%>
                                        <%}%>

                            </tbody>
                        </table>
                    </center>
                    <br/><br/>



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
        <script>
            function showStaff() {
                var xhttp;
                let name=document.getElementById("name").value;
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("tableData").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "StaffMemberSearch.jsp?name=" + name, true);
                xhttp.send();
            }
        </script>
    </body>
</html>
