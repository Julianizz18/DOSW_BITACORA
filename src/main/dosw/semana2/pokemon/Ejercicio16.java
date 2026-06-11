package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio16 {
    public static void main(String[] args) {
        List<Entrenador> competidores = Arrays.asList(
                new Entrenador(1L, "Red",     9,  List.of()),
                new Entrenador(2L, "Blue",    7,  List.of()),
                new Entrenador(3L, "Silver",  4,  List.of()),
                new Entrenador(4L, "Lance",   11, List.of()),
                new Entrenador(5L, "Kris",    3,  List.of()),
                new Entrenador(6L, "Ethan",   8,  List.of())
        );
        List<String> experimentados = competidores.stream()
                .filter(e -> e.getMedallas() > 5)
                .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
                .toList();
        System.out.println("Entrenadores con > 5 medallas: " + experimentados);
    }
}