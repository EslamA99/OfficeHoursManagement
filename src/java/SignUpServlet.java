/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Captcha.VerifyRecaptcha;
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
            /*String userName = request.getParameter("userName");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");

            String password = generateRandomPassword(10);
            //////////////
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
                    JavaMailMaker.sendPassword(email, password);
                    PreparedStatement stmt = connection.prepareStatement("insert into user (user_name,email,password) values (?,?,?)");
                    stmt.setString(1, userName);
                    stmt.setString(2, email);
                    stmt.setString(3, password);
                    int xx = stmt.executeUpdate();
                    stmt = connection.prepareStatement("SELECT MAX(id)FROM user");
                    ResultSet rs = stmt.executeQuery();
                    rs.next();
                    stmt = connection.prepareStatement("insert into student (user_id,name,phone) values (?,?,?)");
                    stmt.setInt(1, rs.getInt(1));
                    stmt.setString(2, name);
                    stmt.setString(3, phoneNumber);
                    int zz = stmt.executeUpdate();

                    response.sendRedirect("index.html");
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.print("ZZ");
            }*/
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
