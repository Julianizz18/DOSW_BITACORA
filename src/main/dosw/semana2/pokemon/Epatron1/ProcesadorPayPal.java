package main.dosw.semana2.pokemon.Epatron1;

public class ProcesadorPayPal extends ProcesadorPago {
    @Override
    public MetodoPago crearMetodoPago() {
        return new PayPal();
    }
}
