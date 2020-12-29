package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EEC
 */
public class SqlConnector {
    private static Connection Con = null;;
    public static Connection getConnection(){
        try {
            if(Con==null||Con.isClosed()){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/office_hours_db";
                    String user = "root";
                    String password = "root";
                    Con = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SqlConnector.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SqlConnector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  Con;
    }
    public static void closeConnection() throws SQLException{
        if(!Con.isClosed())
            Con.close();
    }
    
}
