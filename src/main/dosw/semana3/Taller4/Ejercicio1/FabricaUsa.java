package main.dosw.semana3.Taller4.Ejercicio1;

public class FabricaUsa implements FabricaPagos {
    public MetodoPago crear(String tipo) {
        switch(tipo.toLowerCase()) {
            case "paypal": return new PagoPaypal(); case "stripe": return new PagoStripe();
            default: throw new IllegalArgumentException("No disponible en USA: "+tipo);
        }
    }
}
