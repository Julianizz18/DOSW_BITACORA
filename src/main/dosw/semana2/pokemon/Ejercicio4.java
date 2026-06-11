package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Ejercicio4 {
    record Criatura(String nombre, int nivel) {}
    public static void main(String[] args) {
        List<Criatura> equipo = Arrays.asList(
                new Criatura("Machamp",  58),
                new Criatura("Alakazam", 74),
                new Criatura("Golem",    41),
                new Criatura("Gengar",   92),
                new Criatura("Arcanine", 85)
        );
        equipo.stream()
                .max(Comparator.comparingInt(c -> c.nivel()))
                .ifPresent(c -> System.out.println(
                        "Pokémon Alfa: " + c.nombre() + " (nivel " + c.nivel() + ")"));
    }
}