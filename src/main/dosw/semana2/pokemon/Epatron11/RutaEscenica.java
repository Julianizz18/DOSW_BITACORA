package main.dosw.semana2.pokemon.Epatron11;
public class RutaEscenica implements EstrategiaRuta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta ESCÉNICA de " + origen + " a " + destino + ": pasando por lugares turísticos y paisajes bonitos.");
    }
}
