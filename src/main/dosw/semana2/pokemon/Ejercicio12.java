package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio12 {
    public static void main(String[] args) {
        List<Pokemon> pokedex = Arrays.asList(
                new Pokemon(1L, "Alakazam", "Psíquico",  55, 445, "Kanto", false),
                new Pokemon(2L, "Articuno", "Hielo",     75, 580, "Kanto", true),
                new Pokemon(3L, "Zapdos",   "Eléctrico", 78, 620, "Kanto", true),
                new Pokemon(4L, "Arcanine", "Fuego",     65, 555, "Kanto", false)
        );
        pokedex.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .ifPresent(p -> System.out.println(
                        "Campeón: " + p.getNombre() + " con PC: " + p.getPoderCombate()));
    }
}