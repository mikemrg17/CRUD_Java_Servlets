package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miguel
 */
public class EditarServlet extends HttpServlet {

    DBConnection conexion = new DBConnection();
    PreparedStatement statement;
    ResultSet rs;
    int row;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        conexion.conectarBD();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String idEditado = request.getParameter("idEditado");
            String nombreEditado = request.getParameter("nombreEditado");
            String paternoEditado = request.getParameter("paternoEditado");
            String maternoEditado = request.getParameter("maternoEditado");
            
            statement = conexion.con.prepareStatement("UPDATE Usuario SET nombre = ?, paterno = ?, materno = ? WHERE id = ?");
            statement.setString(1, nombreEditado);
            statement.setString(2, paternoEditado);
            statement.setString(3, maternoEditado);
            statement.setString(4, idEditado);
            
            row = statement.executeUpdate();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CRUD</title>");
            out.println("<link rel=\"icon\" href=\"Imagenes/CRUD.ico\">");
            out.println("<meta http-equiv=\"refresh\" content=\"1; URL=http://localhost:8080/CRUD_Java_Servlets/ServletPrincipal\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Se te va a redireccionar al CRUD :D</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            
            
            
        }catch (SQLException ex) {
            System.out.println("No se pudo ejecutar el query" + ex.getMessage());
        }
    }
}
