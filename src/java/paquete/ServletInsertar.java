package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInsertar extends HttpServlet 
{
    DBConnection conexion = new DBConnection();
    PreparedStatement statement;
    ResultSet rs;
    int row;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    String nombre = request.getParameter("nombre");
    String paterno = request.getParameter("paterno");  
    String materno = request.getParameter("materno");
    try
    {
    conexion.conectarBD();
    Statement s = conexion.con.createStatement();        
    s.executeUpdate("INSERT INTO Usuario(nombre,paterno,materno) VALUES('"+nombre+"','"+paterno+"','"+materno+"');");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("<meta http-equiv=\"refresh\" content=\"1; URL=http://localhost:8080/CRUD_Java_Servlets/ServletPrincipal\" />");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usuario creado</h1>");
            out.println("</body>");
            out.println("</html>");  
    }
    catch(Exception e)
    {
    e.printStackTrace();
    } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
