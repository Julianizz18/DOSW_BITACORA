package main.dosw.semana2.pokemon.Epatron11;
public class RutaTransportePublico implements EstrategiaRuta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta TRANSPORTE PÚBLICO de " + origen + " a " + destino + ": usando metro, buses y tren.");
    }
}
