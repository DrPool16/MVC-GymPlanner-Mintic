package test;

import beans.Rutinas;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesDB {
    public static void main(String[] args) {
        listarRutinas();
    }
    
    public static void actualizarRutina(int id_rutina, String tipo){
        
        DBConnection con = new DBConnection();
        String sql = "UPDATE rutina SET tipo = '" + tipo + "' WHERE id_rutina = "+id_rutina;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            con.desconectar();
        }
        
    }
     public static void  listarRutinas(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM rutina";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs =  st.executeQuery(sql);
            while (rs.next()){
                int id_rutina = rs.getInt("id_rutina");
                int nivel = rs.getInt("nivel");
                String grupo_muscular = rs.getString("grupo_muscular");
                String tipo = rs.getString("tipo");
                String ejercicio = rs.getString("ejercicio");
                String img = rs.getString("img");
                
                Rutinas rutina = new Rutinas(id_rutina, nivel, grupo_muscular, tipo, ejercicio, img);
                System.out.println(rutina.toString());
            }
            
            st.executeQuery(sql);
        } catch(Exception ex){
            System.out.println(ex.getMessage());            
        } finally{
            con.desconectar();
        }
    }
    
    
}
