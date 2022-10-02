package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   
    Connection connection;
    static String bd = "railway";
    static String port = "7357";
    static String login = "root";
    static String password = "QHBQc2wxjRg44jxwcELa";
    static String ip = "containers-us-west-72.railway.app";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + DBConnection.ip+":"+ DBConnection.port + "/" + DBConnection.bd;
            connection = DriverManager.getConnection(url,DBConnection.login, this.password);
            System.out.println("Conexión establecida");
        } catch (Exception ex) {            
            System.out.println("Error de conexión");
        }
    }    
    public Connection getConnection(){
        return connection;
    }  
    public void desconectar(){
        connection = null;
    }  
   
    
}
