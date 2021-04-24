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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class DBConnection {
    static String driver = "com.mysql.jdbc.Driver"; 
    static String url = "jdbc:mysql://localhost:3306/Usuarios";
    static String username = "root";
    static String password = "1234";
    
    protected Connection con = null;
    
    public DBConnection(){
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(con != null){
                System.out.println("Conexión con la BD establecida");
            }
        }catch(SQLException ex){
            System.out.println("Error al conectar a BD " + ex.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Falta el drive de MySQL" + e.getMessage());
        }
    }
    
    public Connection conectarBD(){
        return con;
    }
    
    public void desconectarDeBD(){
        System.out.println("Cerrando conexion");
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo desconectar de BD" + ex.getMessage());
        }
    }
    /*
    public Boolean validateUser(String usernameToValidate, String passwordToValidate){
        //String url = "jdbc:mysql://localhost:3306/Usuarios";
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
    */
}
