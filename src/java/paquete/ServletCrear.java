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
            out.println("<title>Agregar usuario</title>");            
            out.println("<link rel=\"stylesheet\" href=\"create.css\">");
            out.println("<link rel=\"icon\" href=\"Imagenes/CRUD.ico\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"div1\">");
            out.println("<center>");
            out.println("<h1>CREAR NUEVO USUARIO</h1>");
            out.println("</center>");
            out.println("</div>");
            out.println("<div id=\"div2\">");
            out.println("<center>");
            out.println("<form class=\"styleform\" method=\"post\" action=\"ServletInsertar\">");
            out.println("<input class=\"controls\" type=\"text\" name=\"nombre\" id=\"nombre\" placeholder=\"Ingrese su Nombre\">");
            out.println("<input class=\"controls\" type=\"text\" name=\"paterno\" id=\"paterno\" placeholder=\"Ingrese su Apellido paterno\">");
            out.println("<input class=\"controls\" type=\"text\" name=\"materno\" id=\"materno\" placeholder=\"Ingrese su Apellido materno\">");
            out.println("<input class=\"botons\" type=\"submit\" value=\"Registrar\">");
            out.println("</form>");
            out.println("</center>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");  
    }

}