package main.dosw.semana3.Taller4.Ejercicio4;

public class Stats {
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;

    public Stats(int vida, int ataque, int defensa, int velocidad) {
        this.vida      = vida;
        this.ataque    = ataque;
        this.defensa   = defensa;
        this.velocidad = velocidad;
    }

    public int getVida()      { return vida; }
    public int getAtaque()    { return ataque; }
    public int getDefensa()   { return defensa; }
    public int getVelocidad() { return velocidad; }

    @Override
    public String toString() {
        return "HP:" + vida + " | ATK:" + ataque + " | DEF:" + defensa + " | VEL:" + velocidad;
    }
}
