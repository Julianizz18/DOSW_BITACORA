package main.dosw.semana2.pokemon.Epatron1;

public class PayPal implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal por $ " + monto);
    }
}
