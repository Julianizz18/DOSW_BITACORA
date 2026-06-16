package main.dosw.semana3.Taller4.Ejercicio8;

public class Parking implements ServicioHotel {
    public void alConfirmarReserva(Reserva r) {
        if (r.tieneParking()) {
            System.out.println(" Asignando cupo de parqueadero por " + r.getNoches() + " dia/s");
        } else {
            System.out.println(" Sin parqueadero para reserva " + r.getCodigo());
        }
    }
}
