package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio19 {
    public static void main(String[] args) {
        List<Entrenador> competidores = Arrays.asList(
                new Entrenador(1L, "Lance",  11, Arrays.asList(
                        new Pokemon(1L, "Dragonite", "Dragón", 82, 2500, "Kanto", false))),
                new Entrenador(2L, "Red",    9,  Arrays.asList(
                        new Pokemon(2L, "Charizard", "Fuego",  80, 1900, "Kanto", false))),
                new Entrenador(3L, "Ethan",  8,  Arrays.asList(
                        new Pokemon(3L, "Typhlosion","Fuego",  70, 2200, "Johto", false))),
                new Entrenador(4L, "Blue",   7,  Arrays.asList(
                        new Pokemon(4L, "Arcanine",  "Fuego",  65, 1700, "Kanto", false)))
        );
        Comparator<Entrenador> criterio = Comparator
                .comparingInt(Entrenador::getMedallas).reversed()
                .thenComparingDouble(Entrenador::getPoderTotal).reversed()
                .thenComparing(Entrenador::getNombre);
        List<Entrenador> top3 = competidores.stream()
                .sorted(criterio)
                .limit(3)
                .toList();
        System.out.println("Top 3 Entrecotes:");
        int[] pos = {1};
        top3.forEach(e -> System.out.printf(
                "  #%d %-6s – %d medallas, PC: %.0f%n",
                pos[0]++, e.getNombre(),
                e.getMedallas(), e.getPoderTotal()));
    }
}