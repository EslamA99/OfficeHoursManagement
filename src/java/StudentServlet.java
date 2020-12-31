/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.StudentDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;
import models.User;

/**
 *
 * @author eslam
 */
@WebServlet(urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

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
                    insertStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "update":
                    updateStudent(request, response);
                    break;
                case "getAll":
                    getAllStudents(request, response);
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

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        Student student = new Student();
        user.setUsername(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        student.setName(request.getParameter("name"));
        student.setPhone(request.getParameter("phone"));
        UserDAO.saveUser(user);
        User user2 = UserDAO.getUser(user.getUsername());
        student.setUser(user2);
        //UserDAO userdao=new UserDAO();
        StudentDAO.saveStudent(student);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO.deleteStudent(id);
        UserDAO.deleteUser(id);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        Student student = new Student();
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        student.setName(request.getParameter("name"));
        student.setPhone(request.getParameter("phone"));
        student.setUser(user);
        //UserDAO userdao=new UserDAO();
        UserDAO.saveUser(user);
        StudentDAO.saveStudent(student);
    }

    private void getAllStudents(HttpServletRequest request, HttpServletResponse response) {
        List< Student> listUser = StudentDAO.getAllStudent();
    }
}
