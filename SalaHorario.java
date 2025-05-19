package Cine; 
import java.util.ArrayList;
import java.util.List; 
public class SalaHorario {
    private String sala;
    private String horario;
    private List<Integer> asientosDisponibles;
    public SalaHorario(String sala, String horario) {
        this.sala = sala;
        this.horario = horario;
        this.asientosDisponibles = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            asientosDisponibles.add(i);
        }
    }
    public String getSala() {
        return sala;
    }
    public String getHorario() {
        return horario;
    }
    public List<Integer> getAsientosDisponibles() {
        return asientosDisponibles;
    } 
    public boolean reservarAsiento(int asiento) {
        if (asientosDisponibles.contains(asiento)) {
            asientosDisponibles.remove(Integer.valueOf(asiento));
            return true;
        }
        return false;
    }
}


