package beans;
public class Usuario {
    private String username;
    private String contrasena;   
    private String nombre; 	
    private String apellidos; 	
    private String email; 
    private String sexo; 
    private double altura; 
    private double peso; 
    private int actividad_fisica; 
    private int edad; 
    private int nivel_fisico; 
    private int calorias_recomendadas; 

    public Usuario(String username, String contrasena, String nombre, String apellidos, String email, String sexo, double altura, double peso, int actividad_fisica, int edad, int nivel_fisico) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.actividad_fisica = actividad_fisica;
        this.edad = edad;
        this.nivel_fisico = nivel_fisico;
        
    }

    public String getUsername() {
        return username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int getActividad_fisica() {
        return actividad_fisica;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivel_fisico() {
        return nivel_fisico;
    }

    public int getCalorias_recomendadas() {
        return calorias_recomendadas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", sexo=" + sexo + ", altura=" + altura + ", peso=" + peso + ", actividad_fisica=" + actividad_fisica + ", edad=" + edad + ", nivel_fisico=" + nivel_fisico + ", calorias_recomendadas=" + calorias_recomendadas + '}';
    }

    
        
            
    
}
