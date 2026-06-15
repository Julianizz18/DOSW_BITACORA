package main.dosw.semana2.pokemon.Epatron7;

public class SistemaAntitorpedos extends ModuloBarco {
    public SistemaAntitorpedos(Barco barco) {
        super(barco);
    }
    @Override
    public String describir() {
        return barco.describir() + " + Sistema Antitorpedos";
    }
    @Override
    public int getAtaque() {
        return barco.getAtaque() + 20;
    }
}
