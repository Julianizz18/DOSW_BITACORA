package main.dosw.semana3.Taller4.Ejercicio4;

public class UnidadBuilder {
    private String nombre;
    private String clase = "Soldado";
    private int vida = 100;
    private int ataque = 20;
    private int defensa = 10;
    private int velocidad = 5;

    public UnidadBuilder(String nombre) {
        this.nombre = nombre;
    }

    public UnidadBuilder clase(String c) {
        this.clase     = c;  return this;
    }
    public UnidadBuilder vida(int v) {
        this.vida      = v;  return this;
    }
    public UnidadBuilder ataque(int a) {
        this.ataque    = a;  return this;
    }
    public UnidadBuilder defensa(int d){
        this.defensa   = d;  return this;
    }
    public UnidadBuilder velocidad(int vel){
        this.velocidad = vel; return this;
    }

    public Unidad construir() {
        Stats stats = new Stats(vida, ataque, defensa, velocidad);
        return new UnidadBase(nombre, clase, stats);
    }
}
