package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Rutinas;
import connection.DBConnection;

public class RutinaController implements IRutinaController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM rutina";

        if (ordenar == true) {
            sql += " order by grupo_muscular " + orden;
        }

        List<String> rutinas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id_rutina = rs.getInt("id_rutina");
                int nivel = rs.getInt("nivel");
                String grupo_muscular = rs.getString("grupo_muscular");
                String tipo = rs.getString("tipo");
                String ejercicio = rs.getString("ejercicio");
                String img = rs.getString("img");

                Rutinas rutina = new Rutinas(id_rutina, nivel, grupo_muscular, tipo, ejercicio, img);

                rutinas.add(gson.toJson(rutina));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(rutinas);

    }

    @Override
    public String terminar(int id_rutina, String username) {

        DBConnection con = new DBConnection();

        String sql = "Delete from historial where id_rutina= "
                + id_rutina + " and username = '" + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String sumarCantidad(int id_rutina) {

        DBConnection con = new DBConnection();

        String sql = "Update rutina set nivel = (Select nivel from rutina where id_rutina = "
                + id_rutina + ") + 1 where id_rutina = " + id_rutina;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    
     @Override
    public String seleccionar(int id_rutina, String username) {

        Timestamp dia = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        String sql = "Insert into historial values ('" + id_rutina + "', '" + username + "', '" + dia + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            /*
            String modificar = modificar(id_rutina);

            if (modificar.equals("true")) {
                return "true";
            }
            */
            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }
        return "false";
    }


}
