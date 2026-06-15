package main.dosw.semana2.pokemon.Epatron7;

public abstract class ModuloBarco implements Barco {
    protected Barco barco;
    public ModuloBarco(Barco barco) {
        this.barco = barco;
    }
    @Override
    public String describir() {
        return barco.describir();
    }
    @Override
    public int getAtaque() {
        return barco.getAtaque();
    }
    @Override
    public int getDefensa() {
        return barco.getDefensa();
    }
}
