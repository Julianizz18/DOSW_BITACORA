package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio7 {
    public static void main(String[] args) {
        List<String> desordenados = Arrays.asList(
                "Gengar", "Alakazam", "Arcanine",
                "Golem", "Machamp", "Doduo"
        );
        List<String> pokedexOrdenada = desordenados.stream()
                .sorted()
                .toList();
        System.out.println("Pokédex ordenada: " + pokedexOrdenada);
    }
}