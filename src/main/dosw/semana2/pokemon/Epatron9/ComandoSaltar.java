package main.dosw.semana2.pokemon.Epatron9;

public class ComandoSaltar implements Comando {
    private Personaje personaje;
    public ComandoSaltar(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void ejecutar() {
        personaje.saltar();
    }
}
