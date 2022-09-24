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

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

        

    @Override
    public String toString() {
        return "Historial{" + "id_rutina=" + id_rutina + ", username=" + username + ", dia=" + dia + ", nivel=" + nivel + ", tipo=" + tipo + '}';
    }

    
    
    
    
}
