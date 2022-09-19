package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario WHERE username= '" + username + "' and contrasena= '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String sexo = rs.getString("sexo");
                double altura = rs.getDouble("altura");
                double peso = rs.getDouble("peso");
                int actividad_fisica = rs.getInt("actividad_fisica");
                int edad = rs.getInt("edad");
                int nivel_fisico = rs.getInt("nivel_fisico");
                
                Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, email, sexo, altura, peso, actividad_fisica, edad, nivel_fisico);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String nombre, String apellidos, String email, String sexo, double altura, double peso, int actividad_fisica, int edad, int nivel_fisico) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO usuario VALUES('" + username + "', '" + contrasena + "' , '" + nombre + "' ,'" + apellidos + "' ,'" + email + "' ,'" + sexo + "', " + altura + " , " + peso + " , " + actividad_fisica + " , " + edad + ", " + nivel_fisico+")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, email, sexo, altura, peso, actividad_fisica, edad, nivel_fisico);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
}
