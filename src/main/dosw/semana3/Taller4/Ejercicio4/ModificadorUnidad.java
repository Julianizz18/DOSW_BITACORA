package main.dosw.semana3.Taller4.Ejercicio4;
public abstract class ModificadorUnidad implements Unidad {
    protected Unidad base;
    public ModificadorUnidad(Unidad base) {
        this.base = base;
    }
}
