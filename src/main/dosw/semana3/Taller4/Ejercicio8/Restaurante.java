package main.dosw.semana3.Taller4.Ejercicio8;

public class Restaurante implements ServicioHotel {
    public void alConfirmarReserva(Reserva r) {
        if (r.tieneDesayuno()) {
            System.out.println("Registrando desayuno diario para: " + r.getHuesped()
                    + " | Dias: " + r.getNoches());
        } else {
            System.out.println("Sin desayuno incluido para: " + r.getHuesped());
        }
    }
}
