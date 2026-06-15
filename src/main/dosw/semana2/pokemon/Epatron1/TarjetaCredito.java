package main.dosw.semana2.pokemon.Epatron1;

public class TarjetaCredito implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con Tarjeta de Crédito por $ " + monto);
    }
}
