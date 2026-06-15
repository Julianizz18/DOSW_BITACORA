package main.dosw.semana2.pokemon.Epatron9;

public class ComandoDefenderse implements Comando {
    private Personaje personaje;

    public ComandoDefenderse(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void ejecutar() {
        personaje.defenderse();
    }
}
