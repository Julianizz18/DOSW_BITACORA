package main.dosw.semana2.pokemon.Epatron11;
public class RutaMasRapida implements EstrategiaRuta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta MÁS RÁPIDA de " + origen + " a " + destino + ": usando autopistas y vías principales.");
    }
}
