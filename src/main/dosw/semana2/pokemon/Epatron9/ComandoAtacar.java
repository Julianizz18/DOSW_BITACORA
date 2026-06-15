package main.dosw.semana2.pokemon.Epatron9;

public class ComandoAtacar implements Comando {
    private Personaje personaje;
    public ComandoAtacar(Personaje personaje) {
        this.personaje = personaje;
    }
    @Override
    public void ejecutar() {
        personaje.atacar();
    }
}
