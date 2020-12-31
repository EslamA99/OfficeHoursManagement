/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.StaffDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Staff;
import models.User;

/**
 *
 * @author eslam
 */
@WebServlet(urlPatterns = {"/StaffServlet"})
public class StaffServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("requestAction");
            switch (action) {
                case "insert":
                    insertStaff(request, response);
                    break;
                case "delete":
                    deleteStaff(request, response);
                    break;
                case "update":
                    updateStaff(request, response);
                    break;
                case "getAll":
                    getAllStaffs(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
private void insertStaff(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        Staff staff = new Staff();
        user.setUsername(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        staff.setName(request.getParameter("name"));
        staff.setPhone(request.getParameter("phone"));
        UserDAO.saveUser(user);
        User user2 = UserDAO.getUser(user.getUsername());
        staff.setUser(user2);
        //UserDAO userdao=new UserDAO();
        StaffDAO.saveStaff(staff);
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        StaffDAO.deleteStaff(id);
        UserDAO.deleteUser(id);
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        Staff staff = new Staff();
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        staff.setName(request.getParameter("name"));
        staff.setPhone(request.getParameter("phone"));
        staff.setUser(user);
        //UserDAO userdao=new UserDAO();
        UserDAO.saveUser(user);
        StaffDAO.saveStaff(staff);
    }

    private void getAllStaffs(HttpServletRequest request, HttpServletResponse response) {
        List< Staff> listUser = StaffDAO.getAllstaff();
    }
}
