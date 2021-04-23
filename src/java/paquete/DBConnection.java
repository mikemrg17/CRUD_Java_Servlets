/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author miguel
 */
public class DBConnection {
    
    public Boolean validateUser(String usernameToValidate, String passwordToValidate){
        String url = "jdbc:mysql://localhost:3306/Usuarios";
        String username = "root";
        String password = "1234";
        String sql = "SELECT * FROM user WHERE username='" + usernameToValidate + "' AND " + "password='" + passwordToValidate + "'";
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Successfully connected to DB");
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            rs.next();
            System.out.println("Usuario " + rs.getString(2) + " encontrado!");
            con.close();  
            return true;
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
    
    
}
