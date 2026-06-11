package main.dosw.semana1.streams;
import java.util.Arrays;
import java.util.List;

public class Ejercicio5 {
    record Transaction(String id, double amount, boolean approved) {}
    public static void main(String[] args) {
        List<Transaction> movimientos = Arrays.asList(
                new Transaction("TRX-01", 200.0,  true),
                new Transaction("TRX-02", 450.5,  true),
                new Transaction("TRX-03", 75.0,   false),
                new Transaction("TRX-04", 310.0,  true),
                new Transaction("TRX-05", 180.25, false)
        );
        boolean hayNoAprobadas = movimientos.stream()
                .peek(t -> System.out.println(
                        "Revisando: " + t.id() +
                                " | Monto: $" + t.amount() +
                                " | Estado: " + (t.approved() ? "Aprobada" : "Rechazada")))
                .anyMatch(t -> !t.approved());
        System.out.println("\nLote válido: " + !hayNoAprobadas);
    }
}