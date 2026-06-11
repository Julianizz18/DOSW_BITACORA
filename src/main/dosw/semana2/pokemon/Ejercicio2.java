package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> equipo = Arrays.asList(
                "Gengar", "Machamp", "Alakazam", "Golem"
        );
        List<String> equipoGritón = equipo.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Pokédex Gritona: " + equipoGritón);
    }
}