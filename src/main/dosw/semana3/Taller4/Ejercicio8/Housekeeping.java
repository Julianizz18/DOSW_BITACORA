package main.dosw.semana3.Taller4.Ejercicio8;

public class Housekeeping implements ServicioHotel {
    public void alConfirmarReserva(Reserva r) {
        System.out.println("  [Housekeeping] Preparando habitacion " + r.getNumeroHabitacion()
                + " tipo " + r.getTipo().name());
        System.out.println("                 Amenities para " + r.getNoches() + " noche/s");
    }
}
