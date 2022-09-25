package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Historial;
import connection.DBConnection;

public class HistorialController  implements IHistorialController{
    
    @Override
    public String listarHistorials(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id_rutina, l.ejercicio, l.tipo, l.nivel, a.dia from rutina l "
                + "inner join historial a on l.id_rutina = a.id_rutina inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> historials = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_rutina = rs.getInt("id_rutina");
                String ejercicio = rs.getString("ejercicio");
                String tipo = rs.getString("tipo");
                int nivel = rs.getInt("nivel");
                Date dia = rs.getDate("dia");
                
                Historial historial = new Historial(id_rutina, ejercicio, dia, nivel, tipo);

                historials.add(gson.toJson(historial));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(historials);
    }
    
}
