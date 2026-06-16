package main.dosw.semana3.Taller4.Ejercicio8;

public class Recepcion implements ServicioHotel {
    public void alConfirmarReserva(Reserva r) {
        System.out.println("Preparando llave hab." + r.getNumeroHabitacion() + " para " + r.getHuesped() + " (" + r.getNoches() + " noche/s)");
        if (!r.getPeticion().equals("Ninguna"))
            System.out.println("Peticion especial: " + r.getPeticion());
    }
}
