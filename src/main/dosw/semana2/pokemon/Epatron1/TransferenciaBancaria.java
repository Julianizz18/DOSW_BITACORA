package main.dosw.semana2.pokemon.Epatron1;

public class TransferenciaBancaria implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con Transferencia Bancaria por $ " + monto);
    }
}
