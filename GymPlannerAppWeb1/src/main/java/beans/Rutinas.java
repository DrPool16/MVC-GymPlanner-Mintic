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

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getGrupo_muscular() {
        return grupo_muscular;
    }

    public void setGrupo_muscular(String grupo_muscular) {
        this.grupo_muscular = grupo_muscular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    

    @Override
    public String toString() {
        return "Rutinas{" + "id_rutina=" + id_rutina + ", nivel=" + nivel + ", grupo_muscular=" + grupo_muscular + ", tipo=" + tipo + ", ejercicio=" + ejercicio + ", img=" + img + '}';
    }
    
    
    
}
