package main.dosw.semana2.pokemon.Epatron4;

public class Main {
    public static void main(String[] args) {
        SurtidorGasolineria combustion = new VehiculoCombustion();
        combustion.abastecer(40.0);
        System.out.println();
        SurtidorGasolineria electricoRapido = new AdaptadorCargadorRapido(new CargadorElectricoRapido());
        electricoRapido.abastecer(40.0);
        System.out.println();
        SurtidorGasolineria electricoLento = new AdaptadorCargadorLento(new CargadorElectricoLento());
        electricoLento.abastecer(40.0);
    }
}
