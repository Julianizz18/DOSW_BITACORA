package main.dosw.semana2.pokemon.Epatron1;

public class ProcesadorTarjeta extends ProcesadorPago {
    @Override
    public MetodoPago crearMetodoPago() {
        return new TarjetaCredito();
    }
}
