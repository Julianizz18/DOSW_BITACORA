package main.dosw.semana2.pokemon.Epatron9;

public class ComandoCaminar implements Comando {
    private Personaje personaje;
    public ComandoCaminar(Personaje personaje) {
        this.personaje = personaje;
    }
    @Override
    public void ejecutar() {
        personaje.caminar();
    }
}
