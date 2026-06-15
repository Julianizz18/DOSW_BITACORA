package main.dosw.semana2.pokemon.Epatron8;

public abstract class ControlMigratorio {
    protected ControlMigratorio siguiente;

    public ControlMigratorio setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public abstract void verificar(Viajero viajero);
}
