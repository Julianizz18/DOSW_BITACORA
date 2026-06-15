package main.dosw.semana2.pokemon.Epatron1;

public abstract class ProcesadorPago {
    public abstract MetodoPago crearMetodoPago();
    public void realizarPago(double monto) {
        MetodoPago metodo = crearMetodoPago();
        metodo.procesarPago(monto);
    }
}
