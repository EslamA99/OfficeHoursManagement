
import DAO.StudentDAO;
import DAO.UserDAO;
import models.Student;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EEC
 */
public class test {
    public static void main(String[] args) {
       /* User user=new User();
        user.setUsername("test");
        user.setEmail("test@gmail.com");
        user.setPassword("test");
        
        UserDAO.saveUser(user);*/
        User user=UserDAO.getUser("test");
        System.out.println(user.getPassword());
        System.out.println(user.getStaff());
        /*Student student=new Student();
        student.setName("test");
        student.setPhone("011");
        student.setUser(user);
        StudentDAO.saveStudent(student);*/
    }
}
