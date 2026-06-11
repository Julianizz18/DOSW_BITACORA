package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
public class Ejercicio1 {
    record Criatura(String nombre, String elemento) {}
    public static void main(String[] args) {
        List<Criatura> pokedex = Arrays.asList(
                new Criatura("Charizard",  "Fuego"),
                new Criatura("Blastoise",  "Agua"),
                new Criatura("Arcanine",   "Fuego"),
                new Criatura("Venusaur",   "Planta"),
                new Criatura("Rapidash",   "Fuego"),
                new Criatura("Vaporeon",   "Agua")
        );
        List<String> tipoFuego = pokedex.stream()
                .filter(c -> c.elemento().equals("Fuego"))
                .map(Criatura::nombre)
                .toList();
        System.out.println("Pokémon tipo Fuego: " + tipoFuego);
    }
}