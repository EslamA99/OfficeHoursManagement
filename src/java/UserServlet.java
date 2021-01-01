/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SQL.SqlConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EEC
 */
@WebServlet(urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("requestAction");
            switch (action) {
                case "login":
                    loginUser(request, out, response);
                    break;
                case "insert":
                    insertUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "getAll":
                    getAllUsers(request, response);
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

    private void loginUser(HttpServletRequest request, PrintWriter out, HttpServletResponse response) throws IOException {
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            Connection connection = SqlConnector.getConnection();
            Statement Stmt = null;
            Statement Stmt2 = null;
            ResultSet RS = null;
            ResultSet RS2 = null;
            //Stmt = connection.createStatement();
            Stmt2 = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE user_name=? and password=?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            RS = stmt.executeQuery();

            //RS = Stmt.executeQuery("SELECT * FROM user WHERE '" + userName + "' = user.user_name and  '" + password + "' = user.password ;");
            if (RS.next()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user_id", RS.getString("id"));
                session.setAttribute("type", RS.getString("type"));
                if(RS.getString("type").equals("student"))
                    response.sendRedirect("StudentHome.jsp");
                else if(RS.getString("type").equals("staff"))
                    response.sendRedirect("StaffHome.jsp");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('invalid user name or password');");
                out.println("location='index.html';");
                out.println("</script>");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {

    }

    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) {

    }

}
