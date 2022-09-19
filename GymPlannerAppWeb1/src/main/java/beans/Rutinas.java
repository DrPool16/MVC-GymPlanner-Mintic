package beans;
public class Rutinas {
    private int id_rutina;	
    private int nivel;	
    private String grupo_muscular; 
    private String tipo; 
    private String ejercicio; 
    private String img;

    public Rutinas(int id_rutina, int nivel, String grupo_muscular, String tipo, String ejercicio, String img) {
        this.id_rutina = id_rutina;
        this.nivel = nivel;
        this.grupo_muscular = grupo_muscular;
        this.tipo = tipo;
        this.ejercicio = ejercicio;
        this.img = img;
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public int getNivel() {
        return nivel;
    }

    public String getGrupo_muscular() {
        return grupo_muscular;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public String getImg() {
        return img;
    } 

    @Override
    public String toString() {
        return "Rutinas{" + "id_rutina=" + id_rutina + ", nivel=" + nivel + ", grupo_muscular=" + grupo_muscular + ", tipo=" + tipo + ", ejercicio=" + ejercicio + ", img=" + img + '}';
    }
    
    
    
}
