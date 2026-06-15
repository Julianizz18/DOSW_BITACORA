package main.dosw.semana2.pokemon.Epatron1;
public class Main {
    public static void main(String[] args) {
        ProcesadorPago p1 = new ProcesadorTarjeta();
        p1.realizarPago(150.75);

        ProcesadorPago p2 = new ProcesadorPayPal();
        p2.realizarPago(89.99);

        ProcesadorPago p3 = new ProcesadorTransferencia();
        p3.realizarPago(500.00);
    }
}
