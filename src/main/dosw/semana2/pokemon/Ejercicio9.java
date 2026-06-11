package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio9 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Alakazam",  "Psíquico", 55, 445, "Kanto", false),
                new Pokemon(2L, "Articuno",  "Hielo",    75, 580, "Kanto", true),
                new Pokemon(3L, "Machamp",   "Lucha",    48, 390, "Kanto", false),
                new Pokemon(4L, "Zapdos",    "Eléctrico",78, 620, "Kanto", true),
                new Pokemon(5L, "Geodude",   "Roca",     22, 175, "Kanto", false),
                new Pokemon(6L, "Arcanine",  "Fuego",    65, 555, "Kanto", false)
        );
        List<Pokemon> elitePC = pokedex.stream()
                .filter(p -> p.getPoderCombate() > 500)
                .sorted(Comparator.comparingDouble(p -> -p.getPoderCombate()))
                .toList();
        System.out.println("Equipo Élite (PC > 500):");
        elitePC.forEach(p -> System.out.println(
                "  " + p.getNombre() + " (PC: " + p.getPoderCombate() + ")"));
    }
}