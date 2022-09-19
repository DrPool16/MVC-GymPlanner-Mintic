package beans;

import java.util.Date;

public class Historial {
    private int id_rutina;
    private String username;
    private Date dia;
    private int nivel;
    private String tipo;

    public Historial(int id_rutina, String username, Date dia, int nivel, String tipo) {
        this.id_rutina = id_rutina;
        this.username = username;
        this.dia = dia;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public String getUsername() {
        return username;
    }

    public Date getDia() {
        return dia;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Historial{" + "id_rutina=" + id_rutina + ", username=" + username + ", dia=" + dia + ", nivel=" + nivel + ", tipo=" + tipo + '}';
    }

    
    
    
    
}
