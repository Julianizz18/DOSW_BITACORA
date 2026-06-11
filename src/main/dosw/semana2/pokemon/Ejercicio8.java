package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio8 {
    record Criatura(String nombre, boolean listaParaEvolucionar) {}
    public static void main(String[] args) {
        List<Criatura> equipo = Arrays.asList(
                new Criatura("Machop",    true),
                new Criatura("Machamp",   false),
                new Criatura("Gastly",    true),
                new Criatura("Gengar",    false),
                new Criatura("Geodude",   true),
                new Criatura("Golem",     false)
        );
        List<String> listos = equipo.stream()
                .filter(Criatura::listaParaEvolucionar)
                .map(Criatura::nombre)
                .toList();
        System.out.println("Listos para evolucionar: " + listos);
    }
}