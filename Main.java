package Cine;
import java.util.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int precioBoleto = 16000;
    
    public static void main(String[] args) {
        List<Pelicula> peliculas = inicializarPeliculas();
        System.out.println("=== BIENVENIDO AL CINE ===");
        System.out.println("=== Elija la pelicula que desea ver ===");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + ". " + peliculas.get(i).getNombre());
        }
        
        
        
        System.out.print("Elija una pelicula (1-5): ");
        int seleccionPelicula = scanner.nextInt() - 1;
        Pelicula pelicula = peliculas.get(seleccionPelicula);
        System.out.print("Cuantos boletos desea comprar? ");
        int cantidadBoletas = scanner.nextInt();
        List<SalaHorario> horarios = pelicula.getSalaHorarios();
        for (int i = 0; i < horarios.size(); i++) {
            SalaHorario sh = horarios.get(i);
            System.out.println((i + 1) + ". " + sh.getSala() + " - " + sh.getHorario());
        }
        
        
        
        System.out.print("Seleccione sala y horario: ");
        int seleccionHorario = scanner.nextInt() - 1;
        SalaHorario salaHorario = horarios.get(seleccionHorario);
        System.out.println("Asientos disponibles:");
        System.out.println(salaHorario.getAsientosDisponibles());
        List<Integer> sillasElegidas = new ArrayList<>();
        for (int i = 0; i < cantidadBoletas; i++) {
            System.out.print("Seleccione numero de silla #" + (i + 1) + ": ");
            int silla = scanner.nextInt();
            if (salaHorario.reservarAsiento(silla)) {
                sillasElegidas.add(silla);
            } else {
                System.out.println("Silla no disponible, elija otra.");
                i--;
            }
        }
        
        
        
        int total = cantidadBoletas * precioBoleto;
        System.out.println("\n=== FACTURA ===");
        System.out.println("Pelicula: " + pelicula.getNombre());
        System.out.println("Sala: " + salaHorario.getSala());
        System.out.println("Horario: " + salaHorario.getHorario());
        System.out.println("Boletas: " + cantidadBoletas);
        System.out.println("Sillas: " + sillasElegidas);
        System.out.println("Total a pagar: $" + total);
        System.out.println("GRACIAS POR SU COMPRA!");
    }
    
    
    private static List<Pelicula> inicializarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        Pelicula p1 = new Pelicula("Inception");
        p1.agregarSalaHorario(new SalaHorario("Sala 1", "1:00 PM"));
        p1.agregarSalaHorario(new SalaHorario("Sala 2", "4:00 PM"));
        Pelicula p2 = new Pelicula("Interstellar");
        p2.agregarSalaHorario(new SalaHorario("Sala 1", "4:00 PM"));
        p2.agregarSalaHorario(new SalaHorario("Sala 3", "7:00 PM"));
        Pelicula p3 = new Pelicula("The Matrix");
        p3.agregarSalaHorario(new SalaHorario("Sala 2", "1:00 PM"));
        p3.agregarSalaHorario(new SalaHorario("Sala 3", "7:00 PM"));
        Pelicula p4 = new Pelicula("The Godfather");
        p4.agregarSalaHorario(new SalaHorario("Sala 1", "7:00 PM"));
        p4.agregarSalaHorario(new SalaHorario("Sala 3", "1:00 PM"));
        Pelicula p5 = new Pelicula("Avengers");
        p5.agregarSalaHorario(new SalaHorario("Sala 2", "1:00 PM"));
        p5.agregarSalaHorario(new SalaHorario("Sala 3", "4:00 PM"));
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);
        return peliculas;
    }
}

