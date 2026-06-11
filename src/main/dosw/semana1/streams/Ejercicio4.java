package main.dosw.semana1.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {
    record Usuario(int id, String nombre, int edad, boolean activo) {}
    public static void main(String[] args) {
        List<Usuario> lista = Arrays.asList(
                new Usuario(1, "Sofia",    24, true),
                new Usuario(2, "Miguel",   15, false),
                new Usuario(3, "Valentina",17, true),
                new Usuario(4, "Andres",   27, true),
                new Usuario(5, "Lucia",    14, false)
        );
        List<String> mayoresDeEdad = lista.stream()
                .filter(u -> u.edad() >= 18)
                .map(u -> u.nombre())
                .collect(Collectors.toList());
        System.out.println("Mayores de edad: " + mayoresDeEdad);
    }
}