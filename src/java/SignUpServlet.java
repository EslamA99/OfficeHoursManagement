/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Captcha.VerifyRecaptcha;
import SQL.SqlConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EEC
 */
@WebServlet(urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

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
            String userName = request.getParameter("userName");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phoneNumber");
            //String type = request.getParameter("type");
            String password = generateRandomPassword(10);
            if (userName == null || userName.isEmpty()) {
                out.print("user name can't be empty");
                return;
            } else if (name == null || name.isEmpty()) {
                out.print("name can't be empty");
                return;
            } else if (email == null || email.isEmpty()) {
                out.print("email can't be empty");
                return;
            } else if (phone == null || phone.isEmpty()) {
                out.print("phone can't be empty");
                return;
            }
            boolean verify;
            try {
                String gRecaptchaResponse = request
                        .getParameter("g-recaptcha-response");
                verify = VerifyRecaptcha.verify(gRecaptchaResponse);
            } catch (Exception e) {
                verify = false;
            }

            if (verify) {
                Connection connection = SqlConnector.getConnection();
                try {
                    PreparedStatement stmtCheck = connection.prepareStatement("select * from user where user_name=?");
                    stmtCheck.setString(1, userName);
                    if (stmtCheck.executeQuery().next()) {
                        out.print("user name found before");
                        return;
                    }
                    stmtCheck = connection.prepareStatement("select * from user where email=?");
                    stmtCheck.setString(1, email);
                    if (stmtCheck.executeQuery().next()) {
                        out.print("email found before");
                        return;
                    }
                    JavaMailMaker.sendPassword(email, password);
                    PreparedStatement stmt = connection.prepareStatement("insert into user (user_name,email,password,name,phone,type) values (?,?,?,?,?,?)");
                    stmt.setString(1, userName);
                    stmt.setString(2, email);
                    stmt.setString(3, password);
                    stmt.setString(4, name);
                    stmt.setString(5, phone);
                    stmt.setString(6, request.getParameter("type"));
                    int row = stmt.executeUpdate();
                    stmt = connection.prepareStatement("SELECT MAX(id)FROM user");
                    ResultSet rs = stmt.executeQuery();
                    rs.next();
                    String type = request.getParameter("type");
                    if (type.equals("student")) {
                        stmt = connection.prepareStatement("insert into student (user_id) values (?)");
                        stmt.setInt(1, rs.getInt(1));
                        int row2 = stmt.executeUpdate();
                    } else if (type.equals("staff")) {
                        stmt = connection.prepareStatement("insert into staff (user_id,staff_type) values (?,?)");
                        stmt.setInt(1, rs.getInt(1));
                        stmt.setString(2, "Dr");
                        int row2 = stmt.executeUpdate();
                    }
                    /*stmt = connection.prepareStatement("insert into student (user_id,type) values (?,?)");
                    stmt.setInt(1, rs.getInt(1));
                    stmt.setInt(2,"Dr");
                    int row2 = stmt.executeUpdate();
                    response.sendRedirect("index.html");*/

                    out.print("go to login");

                } catch (SQLException ex) {
                    Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                    out.print("failed to sign up");
                } catch (MessagingException ex) {
                    Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                    out.print("message not sent");
                }
            } else {
                out.print("wrong captcha");
            }
        }
    }

    private String generateRandomPassword(int len) {
        // ASCII range - alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of loop choose a character randomly from the given ASCII range
        // and append it to StringBuilder instance
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
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

}
