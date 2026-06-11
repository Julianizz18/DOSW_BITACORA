package main.dosw.semana1.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> valores = Arrays.asList(5, 14, 7, 22, 9, 16, 30, 11);
        List<Integer> paresMayoresDiez = valores.stream()
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Resultado: " + paresMayoresDiez);
    }
}