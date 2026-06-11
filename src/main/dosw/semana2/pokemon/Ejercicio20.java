package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Ejercicio20 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L,  "Arcanine",   "Fuego",     65, 555, "Kanto",  false),
                new Pokemon(2L,  "Zapdos",     "Eléctrico", 78, 620, "Kanto",  true),
                new Pokemon(3L,  "Blastoise",  "Agua",      72, 530, "Kanto",  false),
                new Pokemon(4L,  "Typhlosion", "Fuego",     70, 534, "Johto",  false),
                new Pokemon(5L,  "Feraligatr", "Agua",      69, 515, "Johto",  false),
                new Pokemon(6L,  "Ho-Oh",      "Fuego",     90, 680, "Johto",  true),
                new Pokemon(7L,  "Blaziken",   "Fuego",     68, 510, "Hoenn",  false),
                new Pokemon(8L,  "Swampert",   "Agua",      66, 495, "Hoenn",  false),
                new Pokemon(9L,  "Infernape",  "Fuego",     66, 518, "Sinnoh", false),
                new Pokemon(10L, "Vaporeon",   "Agua",      50, 430, "Kanto",  false)
        );
        Map<String, Long> cantPorTipo = pokedex.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));
        Map<String, Long> cantPorRegion = pokedex.stream()
                .collect(Collectors.groupingBy(Pokemon::getRegion, Collectors.counting()));
        long totalLegendarily = pokedex.stream()
                .filter(Pokemon::isLegendario)
                .count();
        double nivelPrompted = pokedex.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0);
        Pokemon elMasFuerte = pokedex.stream()
                .reduce(pokedex.getFirst(), (a, b) -> a.getPoderCombate() >= b.getPoderCombate() ? a : b);
        System.out.println("Pokédex Analítica");
        System.out.println("Por tipo:     " + cantPorTipo);
        System.out.println("Por región:   " + cantPorRegion);
        System.out.println("Legendarios:  " + totalLegendarily);
        System.out.printf( "Promedio niv: %.1f%n", nivelPrompted);
        System.out.println("Más fuerte:   " + elMasFuerte.getNombre() +
                " (PC: " + elMasFuerte.getPoderCombate() + ")");
    }
}