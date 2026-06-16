package main.dosw.semana3.Taller4.Ejercicio9;

public class SolicitudCredito {
    private String nombreCliente;
    private int    edad;
    private double ingresoMensual;
    private double montoSolicitado;
    private int plazoMeses;
    private double deudaActual;
    private int    historialMeses;

    public SolicitudCredito(String nombre, int edad, double ingreso, double monto, int plazo, double deuda, int historial) {
        this.nombreCliente  = nombre;
        this.edad = edad;
        this.ingresoMensual = ingreso;
        this.montoSolicitado = monto;
        this.plazoMeses = plazo;
        this.deudaActual  = deuda;
        this.historialMeses = historial;
    }

    public String getNombre(){
        return nombreCliente;
    }
    public int    getEdad(){
        return edad;
    }
    public double getIngreso(){
        return ingresoMensual;
    }
    public double getMonto(){
        return montoSolicitado;
    }
    public int    getPlazo(){
        return plazoMeses;
    }
    public double getDeuda(){
        return deudaActual;
    }
    public int    getHistorial(){
        return historialMeses;
    }

    public double getCuotaMensual() {
        return montoSolicitado / plazoMeses;
    }
}
