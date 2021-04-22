package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCrear extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Crear nuevo usuario</h1>");
            out.println("<form action='ServletInsertar' method='get'>");            
            out.println("Nombre: <input name='nombre' type='text' /> <br />"); 
            out.println("Apellido paterno: <input name='paterno' type='text' /> <br />");             
            out.println("<input type='submit' />");                                                
            out.println("</form>");                        
            out.println("</body>");
            out.println("</html>");  
    }

}
