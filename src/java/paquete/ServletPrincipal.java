package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeerUsuario")
public class ServletPrincipal extends HttpServlet 
{
    DBConnection conexion = new DBConnection();
    PreparedStatement statement;
    ResultSet rs;
    int row;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       //Primero nos conectamos a la base de datos
       conexion.conectarBD();
       
       String sql;
       
       sql = "SELECT * FROM Usuario";
        try {
            Statement stmt = conexion.con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("No se pudo ejecutar el query" + ex.getMessage());
        }
       
       
       
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CRUD Servlets</title>");
            out.println("<link rel=\"stylesheet\" href=\"tabla.css\">");
            out.println("<link rel=\"icon\" href=\"Imagenes/CRUD.ico\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"div1\">");
            out.println("<center>");
            out.println("<h1>CREAR, ALTAS, BAJAS Y CAMBIOS</h1>");
            out.println("</center>");
            out.println("</div");
            out.println("<div id=\"div2\">");
            out.println("<a href=\"http://localhost:8080/CRUD_Java_Servlets/ServletCrear\"><b>Crear nuevo usuario</b></a>");
            out.println("</div>");
            out.println("<div id=\"div3\">");
            out.println("<center>");
            out.println("<table border=\"1px\">");
            out.println("<tr>");
            out.println("<th colspan=\"1\" class=\"thead\"><b>Nombre del diagrama de perfil</b></th>");
            out.println("<th colspan=\"3\" class=\"thead\"><b>Acciones</b></th>");
            out.println("</tr>");   
            
            
            try {
                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td><b>"+rs.getString("nombre")+"</b></td>");
                    out.println("<td><a href='LeerUsuario?id="+rs.getString("id")+"'><b>Leer usuario</b></a></td>");
                    out.println("<td><a href='EditarUsuario?id=" + rs.getString("id") + "'><b>Modificar usuario</b></a></td>");
                    out.println("<td><a href='ServletEliminar?id="+rs.getString("id")+"'><b>Eliminar usuario</b></a></td>");
                    out.println("</tr>");
                }
            } catch (SQLException ex) {
                System.out.println("No se pudieron obtener los registros" + ex.getMessage());
            }
            
            out.println("</table>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");  
    }

}