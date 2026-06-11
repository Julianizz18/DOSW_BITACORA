package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio6 {
    public static void main(String[] args) {
        List<String> capturados = Arrays.asList(
                "Gengar", "Arcanine", "Gengar",
                "Alakazam", "Arcanine", "Golem"
        );
        List<String> pokedexUnica = capturados.stream()
                .distinct()
                .toList();
        System.out.println("Pokédex sin duplicados: " + pokedexUnica);
    }
}