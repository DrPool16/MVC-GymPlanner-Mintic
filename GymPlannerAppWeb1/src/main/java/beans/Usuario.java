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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getActividad_fisica() {
        return actividad_fisica;
    }

    public void setActividad_fisica(int actividad_fisica) {
        this.actividad_fisica = actividad_fisica;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNivel_fisico() {
        return nivel_fisico;
    }

    public void setNivel_fisico(int nivel_fisico) {
        this.nivel_fisico = nivel_fisico;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", sexo=" + sexo + ", altura=" + altura + ", peso=" + peso + ", actividad_fisica=" + actividad_fisica + ", edad=" + edad + ", nivel_fisico=" + nivel_fisico +'}';
    }

    
        
            
    
}
