<%-- 
    Document   : StudentHome
    Created on : Dec 29, 2020, 8:03:41 PM
    Author     : EEC
--%>

<%@page import="models.User"%>
<%@page import="models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/HomePageCss.css" rel="stylesheet">
        <link href="CSS/SignCss.css" rel="stylesheet">
        <link href="CSS/TableDesignCss.css" rel="stylesheet">
    </head>
    <body>

        <div class="area">
            <center>
                <div id="formContent">
                    <%
                        Student student = (Student) request.getSession().getAttribute("currStudent");
                        User user = student.getUser();
                    %>
                    <form action="StudentHome.jsp" onsubmit="return validate()">

                        <table>
                            <tr>
                                <td>
                                    <label>Email: </label>
                                </td>
                                <td>
                                    <input type="email" class="fadeIn second" id="email" name="email" placeholder="email" value=<%=user.getEmail()%> >
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <label>Password:</label>
                                </td>
                                <td>
                                    <input type="text"  class="fadeIn second" id="password" name="password" placeholder="password" value=<%=user.getPassword()%> >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Name: </label>
                                </td>
                                <td >
                                    <input type="text"  class="fadeIn second" id="name" name="name" placeholder="name" value=<%=student.getName()%>>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Phone: </label>
                                </td>
                                <td>
                                    <input type="text"  class="fadeIn second" id="phone" name="phone" placeholder="phone" value=<%=student.getPhone()%>>
                                </td>
                            </tr>

                        </table>

                        <input type="submit" class="fadeIn fourth" value="update">

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
            function validate() {



                let name = document.getElementById("name").value;
                if (name == "") {
                    alert("name can't be empty");
                    return false;
                }
                let password = document.getElementById("password").value;
                if (password == "") {
                    alert("password can't be empty");
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
