package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioRegister(){
        super();
    }
            
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuario = new UsuarioController();
        
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        double altura = Double.parseDouble(request.getParameter("altura"));
        double peso = Double.parseDouble(request.getParameter("peso"));
        int actividad_fisica = Integer.parseInt(request.getParameter("actividad_fisica"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        int nivel_fisico = Integer.parseInt(request.getParameter("nivel_fisico"));
        
        String result = usuario.register(username, contrasena,nombre,apellidos, email, sexo, altura,peso, actividad_fisica, edad, nivel_fisico);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    

}
