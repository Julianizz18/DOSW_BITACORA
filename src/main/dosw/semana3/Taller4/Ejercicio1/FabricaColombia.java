package main.dosw.semana3.Taller4.Ejercicio1;

public class FabricaColombia implements FabricaPagos {
    public MetodoPago crear(String tipo) {
        switch(tipo.toLowerCase()) {
            case "pse": return new PagoPse(); case "nequi": return new PagoNequi(); case "tarjeta": return new PagoTarjeta();
            default: throw new IllegalArgumentException("No disponible en Colombia: "+tipo);
        }
    }
}
