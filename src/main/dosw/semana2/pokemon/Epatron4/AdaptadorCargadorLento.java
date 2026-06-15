package main.dosw.semana2.pokemon.Epatron4;


public class AdaptadorCargadorLento implements SurtidorGasolineria {
    private CargadorElectricoLento cargador;

    public AdaptadorCargadorLento(CargadorElectricoLento cargador) {
        this.cargador = cargador;
    }

    @Override
    public void abastecer(double litros) {
        double kwh = litros * 7.0;
        System.out.println("Adaptador Lento: convirtiendo " + litros + " litros a " + kwh + " kWh");
        cargador.cargar(kwh);
    }
}
