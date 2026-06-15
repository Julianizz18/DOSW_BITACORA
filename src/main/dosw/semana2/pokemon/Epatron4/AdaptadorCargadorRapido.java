package main.dosw.semana2.pokemon.Epatron4;

public class AdaptadorCargadorRapido implements SurtidorGasolineria {
    private CargadorElectricoRapido cargador;

    public AdaptadorCargadorRapido(CargadorElectricoRapido cargador) {
        this.cargador = cargador;
    }

    @Override
    public void abastecer(double litros) {
        double kwh = litros * 8.0;
        System.out.println("Adaptador Rapido: convirtiendo " + litros + " litros a " + kwh + " kWh");
        cargador.cargar(kwh);
    }
}
