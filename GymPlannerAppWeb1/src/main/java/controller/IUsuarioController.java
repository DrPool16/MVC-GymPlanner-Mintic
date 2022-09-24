package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena, String nombre, String apellidos, String email, String sexo, double altura, double peso, int actividad_fisica, int edad, int nivel_fisico);
    
    public String pedir(String username);
}
