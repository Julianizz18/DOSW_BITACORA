package main.dosw.semana2.pokemon.Epatron7;

public class BlindajeReforzado extends ModuloBarco {
    public BlindajeReforzado(Barco barco) {
        super(barco);
    }

    @Override
    public String describir() {
        return barco.describir() + " + Blindaje Reforzado";
    }

    @Override
    public int getDefensa() {
        return barco.getDefensa() + 30;
    }
}
