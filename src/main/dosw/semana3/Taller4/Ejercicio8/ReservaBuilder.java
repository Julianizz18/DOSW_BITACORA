package main.dosw.semana3.Taller4.Ejercicio8;

public class ReservaBuilder {
    String codigoReserva;
    String nombreHuesped;
    TipoHabitacion habitacion = TipoHabitacion.SENCILLA;
    int numeroHabitacion = 101;
    int noches = 1;
    boolean desayunoIncluido = false;
    boolean parkingIncluido = false;
    String peticion = "Ninguna";

    public ReservaBuilder(String codigo, String huesped) {
        this.codigoReserva = codigo;
        this.nombreHuesped = huesped;
    }

    public ReservaBuilder habitacion(TipoHabitacion t) {
        this.habitacion  = t;  return this;
    }
    public ReservaBuilder numero(int n){
        this.numeroHabitacion = n;  return this;
    }
    public ReservaBuilder noches(int n) {
        this.noches = n;
        return this;
    }
    public ReservaBuilder conDesayuno() {
        this.desayunoIncluido = true;
        return this;
    }
    public ReservaBuilder conParking(){
        this.parkingIncluido = true;
        return this;
    }
    public ReservaBuilder peticion(String p){
        this.peticion = p;
        return this;
    }

    public Reserva construir() {
        if (nombreHuesped == null || nombreHuesped.isEmpty())
            throw new IllegalStateException("El huesped no puede estar vacio.");
        if (noches < 1)
            throw new IllegalStateException("Debe reservar al menos 1 noche.");
        return new Reserva(this);
    }
}
