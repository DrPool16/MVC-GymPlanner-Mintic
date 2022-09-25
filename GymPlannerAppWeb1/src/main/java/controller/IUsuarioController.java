package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena, String nombre, String apellidos, String email, String sexo, double altura, double peso, int actividad_fisica, int edad, int nivel_fisico);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos, String nuevoEmail, String nuevoSexo,
            double nuevoAltura, double nuevoPeso, int nuevoActividad_fisica, int nuevoEdad, 
            int nuevoNivel_fisico);
    
     //Metodo para eliminar usuario
    public String verNivel(String username);

    public String terminarRutina(String username, Map<Integer, Integer> nivel);

    public String eliminar(String username);
}   
