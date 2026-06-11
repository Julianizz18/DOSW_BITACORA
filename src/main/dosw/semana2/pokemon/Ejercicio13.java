package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Ejercicio13 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Arcanine",  "Fuego",    65, 555, "Kanto", false),
                new Pokemon(2L, "Rapidash",  "Fuego",    60, 500, "Kanto", false),
                new Pokemon(3L, "Vaporeon",  "Agua",     50, 430, "Kanto", false),
                new Pokemon(4L, "Blastoise", "Agua",     72, 530, "Kanto", false),
                new Pokemon(5L, "Venusaur",  "Planta",   68, 490, "Kanto", false)
        );
        Map<String, List<String>> agrupados = pokedex.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));
        agrupados.forEach((tipo, nombres) ->
                System.out.println(tipo + ": " + nombres));
    }
}