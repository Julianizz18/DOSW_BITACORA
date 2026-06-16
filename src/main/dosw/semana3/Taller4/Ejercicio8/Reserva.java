package main.dosw.semana3.Taller4.Ejercicio8;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private final String codigoReserva;
    private final String nombreHuesped;
    private final TipoHabitacion habitacion;
    private final int numeroHabitacion;
    private final int noches;
    private final boolean desayunoIncluido;
    private final boolean parkingIncluido;
    private final String peticion;
    private final double total;

    private List<ServicioHotel> observadores = new ArrayList<>();
    Reserva(ReservaBuilder b) {
        this.codigoReserva  = b.codigoReserva;
        this.nombreHuesped = b.nombreHuesped;
        this.habitacion = b.habitacion;
        this.numeroHabitacion = b.numeroHabitacion;
        this.noches = b.noches;
        this.desayunoIncluido = b.desayunoIncluido;
        this.parkingIncluido  = b.parkingIncluido;
        this.peticion  = b.peticion;
        this.total = calcularTotal(b);
    }
    private double calcularTotal(ReservaBuilder b) {
        double base = b.habitacion.tarifaPorNoche() * b.noches;
        if (b.desayunoIncluido) base += 25000 * b.noches;
        if (b.parkingIncluido)  base += 15000 * b.noches;
        return base;
    }
    public void agregarServicio(ServicioHotel s) {
        observadores.add(s);
    }
    public void confirmar() {
        System.out.println("\nConfirmando reserva " + codigoReserva + "...");
        for (ServicioHotel s : observadores) s.alConfirmarReserva(this);
        System.out.println("Reserva confirmada. Total a pagar: $" + String.format("%.0f", total) + "\n");
    }

    public String getCodigo(){
        return codigoReserva;
    }
    public String getHuesped(){
        return nombreHuesped;
    }
    public TipoHabitacion getTipo() {
        return habitacion;
    }
    public int getNumeroHabitacion(){
        return numeroHabitacion;
    }
    public int getNoches(){
        return noches;
    }
    public boolean tieneDesayuno(){
        return desayunoIncluido;
    }
    public boolean tieneParking() {
        return parkingIncluido;
    }
    public String getPeticion(){
        return peticion;
    }
    public double getTotal() {
        return total;
    }
}
