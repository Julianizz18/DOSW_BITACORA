package main.dosw.semana3.Taller4.Ejercicio1;

public class ProcesadorCompra {
    private MetodoPago metodo;
    public ProcesadorCompra(MetodoPago m) { metodo=m; }
    public void finalizarCompra(double monto) {
        System.out.println("Procesando compra..."); metodo.ejecutarPago(monto); System.out.println("Transaccion exitosa.");
    }
}

