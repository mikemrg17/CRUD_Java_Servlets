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


public class EditarUsuario extends HttpServlet {

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
            statement = conexion.con.prepareStatement("SELECT * FROM Usuario WHERE id = ?");
            statement.setString(1,idUsuario);
            rs = statement.executeQuery();
            
            while(rs.next()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Editar usuario</title>");            
                out.println("<link rel=\"stylesheet\" href=\"create.css\">");
                out.println("<link rel=\"icon\" href=\"Imagenes/CRUD.ico\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id=\"div1\">");
                out.println("<center>");
                out.println("<h1>EDITAR USUARIO</h1>");
                out.println("</center>");
                out.println("</div>");
                out.println("<div id=\"div2\">");
                out.println("<center>");
                out.println("<form class=\"styleform\" method=\"post\" action=\"EditarServlet\">");
                out.println("<input class=\"controls\" type=\"text\" name=\"idEditado\" id=\"idEditado\" value='"+ rs.getString("id") +"' readonly>");
                out.println("<input class=\"controls\" type=\"text\" name=\"nombreEditado\" id=\"nombreEditado\" value='"+ rs.getString("nombre") +"'>");
                out.println("<input class=\"controls\" type=\"text\" name=\"paternoEditado\" id=\"paternoEditado\" value='"+ rs.getString("paterno") +"'>");
                out.println("<input class=\"controls\" type=\"text\" name=\"maternoEditado\" id=\"maternoEditado\" value='"+ rs.getString("materno") +"'>");
                out.println("<input class=\"botons\" type=\"submit\" value=\"Editar\">");
                out.println("</form>");
                out.println("</center>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("No se pudo ejecutar el query" + ex.getMessage());
        }finally{
            conexion.desconectarDeBD();
        }
       
        
            
    }

}
