package main.dosw.semana2.pokemon.Epatron7;

public class RadarAvanzado extends ModuloBarco {
    public RadarAvanzado(Barco barco) {
        super(barco);
    }
    @Override
    public String describir() {
        return barco.describir() + " + Radar Avanzado";
    }
    @Override
    public int getAtaque() {
        return barco.getAtaque() + 10;
    }
}
