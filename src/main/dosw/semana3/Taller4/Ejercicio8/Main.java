package main.dosw.semana3.Taller4.Ejercicio8;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Reservas de Hotel");
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nCodigo de reserva (o 'salir'): ");
            String codigo = sc.nextLine().trim();
            if (codigo.equalsIgnoreCase("salir")) { continuar = false; continue; }
            System.out.print("Nombre del huesped: ");
            String huesped = sc.nextLine().trim();
            System.out.println("Tipos: SENCILLA, DOBLE, SUITE, PRESIDENCIAL");
            System.out.print("Tipo de habitacion: ");
            TipoHabitacion tipo;
            try { tipo = TipoHabitacion.valueOf(sc.nextLine().trim().toUpperCase()); }
            catch (Exception e) { System.out.println("Tipo invalido."); continue; }
            System.out.print("Numero de habitacion: ");
            int numHab = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Numero de noches: ");
            int noches = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Incluir desayuno? (s/n): ");
            boolean desayuno = sc.nextLine().trim().equalsIgnoreCase("s");
            System.out.print("Incluir parqueadero? (s/n): ");
            boolean parking = sc.nextLine().trim().equalsIgnoreCase("s");
            System.out.print("Peticion especial (o Enter para ninguna): ");
            String peticion = sc.nextLine().trim();
            if (peticion.isEmpty()) peticion = "Ninguna";
            ReservaBuilder builder = new ReservaBuilder(codigo, huesped)
                    .habitacion(tipo)
                    .numero(numHab)
                    .noches(noches)
                    .peticion(peticion);
            if (desayuno) builder.conDesayuno();
            if (parking)  builder.conParking();
            Reserva reserva = builder.construir();
            System.out.println("\nResumen: " + reserva.getCodigo() + " | " + reserva.getHuesped()
                    + " | " + reserva.getTipo() + " | Hab:" + reserva.getNumeroHabitacion()
                    + " | " + reserva.getNoches() + " noche/s | Total: $" + String.format("%.0f", reserva.getTotal()));
            System.out.println("Servicios a notificar: recepcion, housekeeping, restaurante, parking");
            System.out.print("Servicios (separados por coma): ");
            for (String s : sc.nextLine().trim().split(",")) {
                switch (s.trim().toLowerCase()) {
                    case "recepcion":    reserva.agregarServicio(new Recepcion());    break;
                    case "housekeeping": reserva.agregarServicio(new Housekeeping()); break;
                    case "restaurante":  reserva.agregarServicio(new Restaurante());  break;
                    case "parking":      reserva.agregarServicio(new Parking());      break;
                    default: System.out.println("Servicio desconocido: " + s.trim());
                }
            }

            reserva.confirmar();
        }
        sc.close();
    }
}
