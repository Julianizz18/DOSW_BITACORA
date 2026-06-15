package main.dosw.semana2.pokemon.Epatron7;

public class BarcoBase implements Barco {
    private String tipo;
    private int ataque;
    private int defensa;
    public BarcoBase(String tipo, int ataque, int defensa) {
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    @Override
    public String describir() {
        return tipo;
    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }
}
