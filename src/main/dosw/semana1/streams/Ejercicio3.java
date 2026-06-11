package main.dosw.semana1.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ejercicio3 {
    record Usuario(int id, String nombre, int edad, boolean activo) {}
    public static void main(String[] args) {
        List<Usuario> lista = Arrays.asList(
                new Usuario(1, "Sofia",    24, true),
                new Usuario(2, "Miguel",   31, false),
                new Usuario(3, "Valentina",19, true),
                new Usuario(4, "Andres",   27, true),
                new Usuario(5, "Lucia",    33, false)
        );
        List<String> nombresActivos = lista.stream()
                .filter(u -> u.activo())
                .map(u -> u.nombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Usuarios activos ordenados: " + nombresActivos);
    }
}