package main.dosw.semana2.pokemon.Epatron11;

public class RutaMasCorta implements EstrategiaRuta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta MÁS CORTA de " + origen + " a " + destino + ": calculando menor distancia posible.");
    }
}
