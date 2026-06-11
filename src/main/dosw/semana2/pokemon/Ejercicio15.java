package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio15 {
    public static void main(String[] args) {
        List<Entrenador> competidores = Arrays.asList(
                new Entrenador(1L, "Red",    9,  List.of()),
                new Entrenador(2L, "Blue",   7,  List.of()),
                new Entrenador(3L, "Silver", 5,  List.of()),
                new Entrenador(4L, "Lance",  11, List.of())
        );
        competidores.stream()
                .max(Comparator.comparingInt(Entrenador::getMedallas))
                .ifPresent(e -> {
                    System.out.println("Campeón de gimnasios: " + e.getNombre());
                    System.out.println("Medallas obtenidas: "   + e.getMedallas());
                });
    }
}