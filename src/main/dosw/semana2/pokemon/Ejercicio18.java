package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio18 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Alakazam",  "Psíquico",  55, 445, "Kanto", false),
                new Pokemon(2L, "Articuno",  "Hielo",     75, 580, "Kanto", true),
                new Pokemon(3L, "Machamp",   "Lucha",     48, 390, "Kanto", false),
                new Pokemon(4L, "Zapdos",    "Eléctrico", 78, 620, "Kanto", true),
                new Pokemon(5L, "Geodude",   "Roca",      22, 175, "Kanto", false),
                new Pokemon(6L, "Arcanine",  "Fuego",     65, 555, "Kanto", false),
                new Pokemon(7L, "Rapidash",  "Fuego",     60, 280, "Kanto", false)
        );
        List<Pokemon> top5 = pokedex.stream()
                .sorted(Comparator.comparingDouble(p -> -p.getPoderCombate()))
                .limit(5)
                .toList();
        System.out.println("Top 5 más fuertes:");
        int[] pos = {1};
        top5.forEach(p -> System.out.printf(
                "  #%d %-12s – PC: %.0f%n",
                pos[0]++, p.getNombre(), p.getPoderCombate()));
    }
}