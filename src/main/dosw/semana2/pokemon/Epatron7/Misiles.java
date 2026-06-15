package main.dosw.semana2.pokemon.Epatron7;
public class Misiles extends ModuloBarco {
    public Misiles(Barco barco) {
        super(barco);
    }
    @Override
    public String describir() {
        return barco.describir() + " + Misiles";
    }
    @Override
    public int getAtaque() {
        return barco.getAtaque() + 40;
    }
}
