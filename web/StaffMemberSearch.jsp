<%-- 
    Document   : StaffMemberSearch
    Created on : Dec 31, 2020, 3:23:04 AM
    Author     : EEC
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.StaffDAO"%>
<%@page import="models.Staff"%>

<table id="tableData">
    <thead>
        <tr>
            <th>Name
            <th>Email
            <th>Contact
    </thead>
    <tbody>
        <%
            String name = request.getParameter("staffName");
            List<Staff> staffMembersList;
            if (name==null||name.isEmpty()) {
                staffMembersList = StaffDAO.getAllstaff();
            } else {
                staffMembersList = StaffDAO.getStaffsWithName(name);
            }

            for (Staff staff : staffMembersList) {%>
        <tr>
            <td><%= staff.getName()%>

            <td><%= staff.getUser().getEmail()%>
            <td><%= staff.getPhone()%>
                <%}%>

    </tbody>
</table>

