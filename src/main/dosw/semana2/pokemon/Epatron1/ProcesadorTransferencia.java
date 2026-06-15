package main.dosw.semana2.pokemon.Epatron1;

public class ProcesadorTransferencia extends ProcesadorPago {
    @Override
    public MetodoPago crearMetodoPago() {
        return new TransferenciaBancaria();
    }
}
