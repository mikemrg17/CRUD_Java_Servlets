package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletEliminar extends HttpServlet {

    DBConnection conexion = new DBConnection();
    PreparedStatement statement;
    ResultSet rs;
    int row;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        conexion.conectarBD();
        String idUsuario = request.getParameter("id");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            statement = conexion.con.prepareStatement("DELETE FROM Usuario WHERE id = ?");
            statement.setString(1,idUsuario);
            row = statement.executeUpdate();
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Eliminar usuario</title>");            
                out.println("<link rel=\"stylesheet\" href=\"create.css\">");
                out.println("<link rel=\"icon\" href=\"Imagenes/CRUD.ico\">");
                out.println("<meta http-equiv=\"refresh\" content=\"1; URL=http://localhost:8080/CRUD_Java_Servlets/ServletPrincipal\" />");      
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuario eliminado</h1>");
                out.println("</body>");
                out.println("</html>");
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("No se pudo ejecutar el query" + ex.getMessage());
        }
       
        
            
    }

}
