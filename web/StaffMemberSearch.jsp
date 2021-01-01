<%-- 
    Document   : StaffMemberSearch
    Created on : Dec 31, 2020, 3:23:04 AM
    Author     : EEC
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="SQL.SqlConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>

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
            String name = request.getParameter("staffName");
            Connection connection = SqlConnector.getConnection();
            Statement Stmt = null;
            Statement Stmt2 = null;
            ResultSet RS = null;
            ResultSet RS2 = null;
            if (name == null || name.isEmpty()) {
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
                <%}
                } else {
                    Stmt = connection.createStatement();
                    Stmt2 = connection.createStatement();
                    RS = Stmt.executeQuery("SELECT * FROM user WHERE '" + name + "' = user.name and user.type = 'staff' ");
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
                <%}
                    }
                %>
    </tbody>
</table>

