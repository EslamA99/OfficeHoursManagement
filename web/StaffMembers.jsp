<%-- 
    Document   : StaffMembers
    Created on : Dec 30, 2020, 11:41:27 PM
    Author     : EEC
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="SQL.SqlConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/TableDesignCss.css" rel="stylesheet">
        <link href="CSS/HomePageCss.css" rel="stylesheet">
        <link href="CSS/HomeContent.css" rel="stylesheet">
        <link href="CSS/SearchBarCss.css" rel="stylesheet">
    </head>
    <body>
        <div class="area">
            <center>
                <div id="formContent"> 
                    <h1>Staff Members</h1>
                    <form method="post" onsubmit="showStaff(event)">
                        <div class="search">
                            <input type="text" id="staffName" class="searchTerm" placeholder="Find staff?">
                            <button type="submit" class="searchButton">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>


                    <center>
                        <table id="tableData">
                            <thead>
                                <tr>
                                    <th>Name
                                    <th>Email
                                    <th>Dr/TA
                                    <th>Contact
                            </thead>
                            <tbody>
                                <%
                                    Connection connection = SqlConnector.getConnection();
                                    Statement Stmt = null;
                                    Statement Stmt2 = null;
                                    ResultSet RS = null;
                                    ResultSet RS2 = null;
                                    Stmt = connection.createStatement();
                                    Stmt2 = connection.createStatement();
                                    RS = Stmt.executeQuery("SELECT * FROM user WHERE user.type = 'staff' ");
                                    while (RS.next()) {%>
                                <tr>
                                    <td><%= RS.getString("name")%>
                                    <td><%= RS.getString("email")%>
                                        <%
                                            String id = RS.getString("id");
                                            RS2 = Stmt2.executeQuery("SELECT * FROM staff WHERE '" + id + "' = staff.user_id");
                                            RS2.next();
                                        %>
                                    <td><%= RS2.getString("staff_type")%>
                                    <td><%= RS.getString("phone")%>
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
            function showStaff(e) {
                e.preventDefault();
                var xhttp;
                let name = document.getElementById("staffName").value;
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("tableData").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "StaffMemberSearch.jsp?staffName=" + name, true);
                xhttp.send();
            }
        </script>
    </body>
</html>
