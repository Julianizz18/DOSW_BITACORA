package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio5 {
    record Criatura(String nombre, int nivel) {}
    public static void main(String[] args) {
        List<Criatura> equipo = Arrays.asList(
                new Criatura("Arcanine",  58),
                new Criatura("Articuno",  85),
                new Criatura("Zapdos",    83),
                new Criatura("Machamp",   62),
                new Criatura("Moltres",   87),
                new Criatura("Geodude",   35)
        );
        List<String> poderosos = equipo.stream()
                .filter(c -> c.nivel() > 80)
                .map(Criatura::nombre)
                .collect(Collectors.toList());
        System.out.println("Pokémon con nivel > 80: " + poderosos.size());
        System.out.println(poderosos);
    }
}