package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Ejercicio14 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Arcanine",  "Fuego",    65, 555, "Kanto",  false),
                new Pokemon(2L, "Typhlosion","Fuego",    70, 534, "Johto",  false),
                new Pokemon(3L, "Blaziken",  "Fuego",    68, 510, "Hoenn",  false),
                new Pokemon(4L, "Infernape", "Fuego",    66, 518, "Sinnoh", false),
                new Pokemon(5L, "Blastoise", "Agua",     72, 530, "Kanto",  false),
                new Pokemon(6L, "Feraligatr","Agua",     69, 515, "Johto",  false)
        );
        Map<String, List<String>> porRegion = pokedex.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getRegion,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));
        porRegion.forEach((region, nombres) ->
                System.out.println(region + ": " + nombres));
    }
}