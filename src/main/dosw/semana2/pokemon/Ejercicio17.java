package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio17 {
    public static void main(String[] args) {
        List<Entrenador> competidores = Arrays.asList(
                new Entrenador(1L, "Red",   9, Arrays.asList(
                        new Pokemon(1L, "Charizard", "Fuego",     80, 900,  "Kanto", false),
                        new Pokemon(2L, "Snorlax",   "Normal",    75, 950,  "Kanto", false))),
                new Entrenador(2L, "Lance", 11, Arrays.asList(
                        new Pokemon(3L, "Dragonite", "Dragón",    82, 1200, "Kanto", false),
                        new Pokemon(4L, "Aerodactyl","Roca",      70, 1100, "Kanto", false))),
                new Entrenador(3L, "Blue",  7, Arrays.asList(
                        new Pokemon(5L, "Alakazam",  "Psíquico",  68, 820,  "Kanto", false),
                        new Pokemon(6L, "Arcanine",  "Fuego",     65, 850,  "Kanto", false)))
        );
        competidores.stream()
                .max(Comparator.comparingDouble(e -> e.getPoderTotal()))
                .ifPresent(e -> {
                    System.out.println("Entrenador más poderoso: " + e.getNombre());
                    System.out.println("Poder acumulado del equipo: " + e.getPoderTotal());
                });
    }
}