package Cine;
import java.util.ArrayList; 
import java.util.List;
public class Pelicula {
    private String nombre;
    private List<SalaHorario> salaHorarios;
    public Pelicula(String nombre) {
        this.nombre = nombre;
        this.salaHorarios = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public List<SalaHorario> getSalaHorarios() {
        return salaHorarios;
    }
    public void agregarSalaHorario(SalaHorario sh) {
        salaHorarios.add(sh);
    }
}
