package main.dosw.semana2.pokemon;
import java.util.Arrays;
import java.util.List;
public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> nivelesEquipo = Arrays.asList(52, 67, 41, 78, 33, 29);
        int sumaTotal = nivelesEquipo.stream()
                .reduce(0, Integer::sum);
        System.out.println("Suma total de niveles: " + sumaTotal);
    }
}