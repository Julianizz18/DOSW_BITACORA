package main.dosw.semana1.streams;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> lenguajes = Arrays.asList("java", "stream", "api", "functional", "code", "git");
        long total = lenguajes.stream()
                .filter(palabra -> palabra.length() > 4)
                .map(palabra -> palabra.toUpperCase())
                .sorted()
                .count();
        System.out.println("Cantidad de palabras resultantes: " + total);
    }
}