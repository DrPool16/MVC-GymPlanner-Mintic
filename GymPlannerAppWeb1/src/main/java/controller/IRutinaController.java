package controller;

public interface IRutinaController {
    
    public String listar(boolean ordenar, String orden);
    
    public String terminar(int id_rutina, String username);
    
    public String sumarCantidad(int id_rutina);
}
