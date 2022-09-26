package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

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
        String sql = "INSERT INTO usuario VALUES('" + username + "', '" + contrasena + "' , '" + nombre + "' ,'" + apellidos + "' ,'" + email + "' ,'" + sexo + "', " + altura + " , " + peso + " , " + actividad_fisica + " , " + edad + ", " + nivel_fisico + ")";

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

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario WHERE username= '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String sexo = rs.getString("sexo");
                double altura = rs.getDouble("altura");
                double peso = rs.getDouble("peso");
                int actividad_fisica = rs.getInt("actividad_fisica");
                int edad = rs.getInt("edad");
                int nivel_fisico = rs.getInt("nivel_fisico");

                Usuario usuario = new Usuario(username, contrasena, nombre, apellidos,
                        email, sexo, altura, peso, actividad_fisica, edad, nivel_fisico);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    //Metodo para modificar usuario
    @Override
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoEmail, String nuevoSexo,
            double nuevoAltura, double nuevoPeso, int nuevoActividad_fisica, int nuevoEdad,
            int nuevoNivel_fisico) {

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + nuevaContrasena
                + "', nombre = '" + nuevoNombre + "', "
                + "apellidos = '" + nuevosApellidos + "', email = '"
                + nuevoEmail + "', sexo = '" + nuevoSexo + "', altura = "
                + nuevoAltura + ", peso = " + nuevoPeso + ", actividad_fisica = "
                + nuevoActividad_fisica + ", edad = " + nuevoEdad + ", nivel_fisico = "
                + nuevoNivel_fisico;

        /*
        if (nuevoNivel_fisico == 1 || nuevoNivel_fisico == 2 || nuevoNivel_fisico == 3) {
            sql += " 1 ";
        } else {
            sql += " 0 ";
        }
        */
        sql += " where username = '" + username + "'";
        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String verNivel(String username) {

        DBConnection con = new DBConnection();
        String sql = "select id_rutina,count(*) as num_nivel from historial where username = '"
                + username + "' group by id_rutina;";

        Map<Integer, Integer> nivel = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_rutina = rs.getInt("id_rutina");
                int num_nivel = rs.getInt("num_copias");

                nivel.put(id_rutina, num_nivel);
            }

            terminarRutina(username, nivel);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    

    @Override
    public String terminarRutina(String username, Map<Integer, Integer> nivel) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> rutina : nivel.entrySet()) {
                int id_rutina = rutina.getKey();
                int num_nivel = rutina.getValue();

                String sql = "Update rutina set nivel = (Select nivel + " + num_nivel
                        + " from rutina where id_rutina = " + id_rutina + ") where id_rutina = " + id_rutina;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from historial where username = '" + username + "'";
        String sql2 = "Delete from usuario where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

}

